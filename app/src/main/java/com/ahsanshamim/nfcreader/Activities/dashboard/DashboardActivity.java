package com.ahsanshamim.nfcreader.Activities.dashboard;

import static com.ahsanshamim.nfcreader.utils.SystemUtils.setWindowFlag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.ahsanshamim.nfcreader.Activities.LoginActivity;
import com.ahsanshamim.nfcreader.Activities.item.ItemListActivity;
import com.ahsanshamim.nfcreader.Activities.profile.ProfileScannerActivity;
import com.ahsanshamim.nfcreader.Models.auth.LoginData;
import com.ahsanshamim.nfcreader.Models.auth.UserData;
import com.ahsanshamim.nfcreader.Models.encrypt.EncryptItem;
import com.ahsanshamim.nfcreader.Models.encrypt.EncryptResponse;
import com.ahsanshamim.nfcreader.Models.session.CurrentSessionModel;
import com.ahsanshamim.nfcreader.Models.session.SessionRequest;
import com.ahsanshamim.nfcreader.Models.user.UserDetailsResponse;
import com.ahsanshamim.nfcreader.R;
import com.ahsanshamim.nfcreader.Repository.EncryptRespository;
import com.ahsanshamim.nfcreader.Repository.SessionRepository;
import com.ahsanshamim.nfcreader.Repository.user.UserDetailsRepository;
import com.ahsanshamim.nfcreader.listener.encrypt.EncryptListener;
import com.ahsanshamim.nfcreader.listener.session.SessionListener;
import com.ahsanshamim.nfcreader.listener.user.UserDetailsListener;
import com.ahsanshamim.nfcreader.roomdatabase.init.DatabaseClient;
import com.ahsanshamim.nfcreader.roomdatabase.model.SQLEncryptionModel;
import com.ahsanshamim.nfcreader.utils.CustomLoader;
import com.ahsanshamim.nfcreader.utils.SharePref;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.List;

public class DashboardActivity extends AppCompatActivity implements SessionListener, UserDetailsListener,
    EncryptListener {

    SharePref sharePref;
    SessionRepository sessionRepository;
    UserDetailsRepository userDetailsRepository;
    EncryptRespository encryptRespository;
    CustomLoader customLoader;
    UserData userData;
    LoginData result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //make translucent statusBar on kitkat devices
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        //make fully Android Transparent Status bar
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setXML();
    }

    /**
     *
     * set all XML and  init all object
     */
    private void setXML(){
        FancyToast.makeText(this,"Please wait.verifying user session...",
            FancyToast.LENGTH_LONG,FancyToast.WARNING,false).show();
        sharePref = new SharePref(getApplicationContext());

        userData = sharePref.getUserLoginData();
        Logger.v(new Gson().toJson(userData));
        result = userData.getResult();

        sessionRepository = new SessionRepository();
        sessionRepository.sessionListener  = this;
        customLoader = new CustomLoader(DashboardActivity.this);
        encryptRespository = new EncryptRespository();
        encryptRespository.encryptListener = this;
        customLoader.showProgressDialog();

        SessionRequest sessionRequest = new SessionRequest();
        sessionRequest.setAccessToken(result.getToken());
        sessionRequest.setEncryptedAccessToken(result.getEncryptedAccessToken());
        sessionRequest.setExpireInSeconds(result.getExpireInSeconds());
        sessionRepository.verifyUserSession(result.getToken(),sessionRequest);
    }

    /**
     * On Profile Click Button
     * @param view
     */
    public void openProfileScanner(View view){
        startActivity(new Intent(getApplicationContext(), ProfileScannerActivity.class));
    }

    public void openItemActivity(View view){
        startActivity(new Intent(getApplicationContext(), ItemListActivity.class));
    }

    @Override
    public void onSuccessSession(CurrentSessionModel currentSessionModel) {
        FancyToast.makeText(this,"Fetching user details.Please Wait...",
            FancyToast.LENGTH_LONG,FancyToast.WARNING,false).show();

        userDetailsRepository = new UserDetailsRepository();
        userDetailsRepository.userDetailsListener = this;

        userDetailsRepository.verifyUserSession(result.getToken(),result.getUserId());
    }

    @Override
    public void onFailureSession(String message) {
        customLoader.dismiss();
        FancyToast.makeText(this,message,FancyToast.LENGTH_LONG,FancyToast.ERROR,false).show();;
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }

    @Override
    public void onSuccessUserDetails(UserDetailsResponse userDetailsResponse) {
        sharePref.saveUserFullDetails(new Gson().toJson(userDetailsResponse));
        FancyToast.makeText(this,"Checking encryption data.",FancyToast.LENGTH_LONG,FancyToast.WARNING,false).show();;
        encryptRespository.getAllEncyption(result.getToken(),3);
    }

    @Override
    public void onFailureUserDetails(String message) {
        customLoader.dismiss();
        FancyToast.makeText(this,message,FancyToast.LENGTH_LONG,FancyToast.ERROR,false).show();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }

    @Override
    public void onSuccessEncrypt(EncryptResponse encryptResponse) {

        //save data into room database
        Thread thred = new Thread(() -> {
            List<EncryptItem> encryptItemList =  encryptResponse.getResult().getItems();
            for (EncryptItem encryptItem : encryptItemList){
                SQLEncryptionModel sqlEncryptionModel = new SQLEncryptionModel();
                sqlEncryptionModel.setKeyName(encryptItem.getKeyName());
                sqlEncryptionModel.setKeyValue(encryptItem.getKeyValue());
                sqlEncryptionModel.setAutoChangeValue(String.valueOf(encryptItem.isAutoChangeValue()));
                sqlEncryptionModel.setSchedule(encryptItem.getSchedule());
                sqlEncryptionModel.setIsActive(String.valueOf(encryptItem.isActive()));
                sqlEncryptionModel.setEncryption_id(encryptItem.getId());
                sqlEncryptionModel.setTenantId(encryptItem.getTenantId());
                sqlEncryptionModel.setOrganizationUnitId(encryptItem.getOrganizationUnitId());
                sqlEncryptionModel.setDeleted(encryptItem.isDeleted());
                sqlEncryptionModel.setDeleterUserId(encryptItem.getDeleterUserId());
                sqlEncryptionModel.setDeletionTime(encryptItem.getDeletionTime());
                sqlEncryptionModel.setLastModificationTime(encryptItem.getLastModificationTime());
                sqlEncryptionModel.setCreationTime(encryptItem.getCreationTime());
                sqlEncryptionModel.setCreatorUserId(encryptItem.getCreatorUserId());


                // Deleting old data
                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                    .taskDao()
                    .removeAll();

                //adding to database
                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                    .taskDao()
                    .insert(sqlEncryptionModel);

                List<SQLEncryptionModel> sqlEncryptionModels =  DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                    .taskDao()
                    .getAll();
                Logger.v("DATA===>"+new Gson().toJson(sqlEncryptionModels));
                runOnUiThread(() -> {
                    FancyToast.makeText(getApplicationContext(),"User verified successfully",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false).show();;
                });
            }
        });
        thred.start();
        customLoader.dismiss();
    }

    @Override
    public void onFailureEncrypt(String message) {
        customLoader.dismiss();
        FancyToast.makeText(this,message,FancyToast.LENGTH_LONG,FancyToast.ERROR,false).show();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }
}
