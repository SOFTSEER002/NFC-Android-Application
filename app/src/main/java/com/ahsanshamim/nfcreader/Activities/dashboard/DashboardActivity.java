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
import com.ahsanshamim.nfcreader.Activities.profile.ProfileScannerActivity;
import com.ahsanshamim.nfcreader.Models.auth.LoginData;
import com.ahsanshamim.nfcreader.Models.auth.UserData;
import com.ahsanshamim.nfcreader.Models.session.CurrentSessionModel;
import com.ahsanshamim.nfcreader.Models.session.SessionRequest;
import com.ahsanshamim.nfcreader.R;
import com.ahsanshamim.nfcreader.Repository.SessionRepository;
import com.ahsanshamim.nfcreader.listener.session.SessionListener;
import com.ahsanshamim.nfcreader.utils.CustomLoader;
import com.ahsanshamim.nfcreader.utils.SharePref;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.shashank.sony.fancytoastlib.FancyToast;

public class DashboardActivity extends AppCompatActivity implements SessionListener {

    SharePref sharePref;
    SessionRepository sessionRepository;
    CustomLoader customLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        FancyToast.makeText(this,"Please wait.verifying user session",FancyToast.LENGTH_LONG,FancyToast.WARNING,false);

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
    private void setXML(){
        sharePref = new SharePref(getApplicationContext());
        sessionRepository = new SessionRepository();
        sessionRepository.sessionListener  = this;
        customLoader = new CustomLoader(DashboardActivity.this);
        customLoader.showProgressDialog();
        UserData userData = sharePref.getUserLoginData();
        Logger.v(new Gson().toJson(userData));
        LoginData result = userData.getResult();
        SessionRequest sessionRequest = new SessionRequest();
        sessionRequest.setAccessToken(result.getToken());
        sessionRequest.setEncryptedAccessToken(result.getEncryptedAccessToken());
        sessionRequest.setExpireInSeconds(result.getExpireInSeconds());
        sessionRepository.verifyUserSession(result.getToken(),sessionRequest);
    }
    public void openProfileScanner(View view){
        startActivity(new Intent(getApplicationContext(), ProfileScannerActivity.class));
    }

    @Override
    public void onSuccessSession(CurrentSessionModel currentSessionModel) {
        customLoader.dismiss();
    }

    @Override
    public void onFailureSession(String message) {
        customLoader.dismiss();
        FancyToast.makeText(this,message,FancyToast.LENGTH_LONG,FancyToast.ERROR,false);
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }
}
