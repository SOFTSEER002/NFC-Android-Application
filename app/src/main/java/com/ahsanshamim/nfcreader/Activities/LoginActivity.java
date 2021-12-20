package com.ahsanshamim.nfcreader.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ahsanshamim.nfcreader.Activities.dashboard.DashboardActivity;
import com.ahsanshamim.nfcreader.Adapters.productsrecyclerviewadptr;
import com.ahsanshamim.nfcreader.Models.IsTenantAvailable;
import com.ahsanshamim.nfcreader.Models.auth.LoginData;
import com.ahsanshamim.nfcreader.Models.auth.SimpleLogin;
import com.ahsanshamim.nfcreader.Models.auth.UserData;
import com.ahsanshamim.nfcreader.Models.getproductsInfo;
import com.ahsanshamim.nfcreader.Models.istenant_body;
import com.ahsanshamim.nfcreader.R;
import com.ahsanshamim.nfcreader.Repository.AuthRepository;
import com.ahsanshamim.nfcreader.RetrofitAPI.APIClient;
import com.ahsanshamim.nfcreader.RetrofitAPI.APIInterface;
import com.ahsanshamim.nfcreader.listener.auth.AuthListener;
import com.ahsanshamim.nfcreader.utils.CustomLoader;
import com.orhanobut.logger.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements AuthListener {
    Button btn_login;
    EditText edt_username, edt_password;
    APIInterface apiInterface;
    TextView txt_tenantid;
    CustomLoader customLoader;

    int id = 0;
    AuthRepository authRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        authRepository = new AuthRepository();
        authRepository.authListener = this;

        customLoader = new CustomLoader(LoginActivity.this);

        init();

        btn_login.setOnClickListener(view -> {
            if (id > 0) {
                if (checkFields()) {
                    SimpleLogin simpleLogin = new SimpleLogin();
                    simpleLogin.setUsernameoremailaddress(edt_username.getText().toString());
                    simpleLogin.setPassword(edt_password.getText().toString());
                    customLoader.showProgressDialog();
                    authRepository.loginUser(simpleLogin, id);
                }
            } else {
                Toast.makeText(getApplicationContext(), "Tenant Id is missing", Toast.LENGTH_SHORT).show();
            }
        });

        txt_tenantid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup_teltenant();
            }
        });
    }

    void init() {
        btn_login = findViewById(R.id.btnlogin);
        edt_username = findViewById(R.id.edt_user);
        edt_password = findViewById(R.id.edt_pass);
        txt_tenantid = findViewById(R.id.txt_tenantid);
    }

    /**
     * Check  Edit Fields
     *
     * @return
     */

    boolean checkFields() {
        if (edt_username.getText().toString().isEmpty()) {
            edt_username.setError("Email is required");
            return false;
        }

        if (edt_password.getText().toString().isEmpty()) {
            edt_password.setError("Password is required");
            return false;
        }
        return true;
    }

    private void popup_teltenant() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Authenticate Through tenant Id");
        alert.setMessage("Enter Tenant ID / Name");

        // Set an EditText view to get user input
        final EditText input = new EditText(this);
        alert.setView(input);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if (!input.getText().equals("")) {
                    customLoader.showProgressDialog();
                    istenant_body istenantBody = new istenant_body();
                    istenantBody.tenancyName = input.getText().toString();
                    apiInterface = APIClient.getClient().create(APIInterface.class);
                    Call<IsTenantAvailable> call = apiInterface.get_istenantavailable(istenantBody);

                    call.enqueue(new Callback<IsTenantAvailable>() {
                        @Override
                        public void onResponse(Call<IsTenantAvailable> call, Response<IsTenantAvailable> response) {
                            Logger.e("GETID " + response);
                            customLoader.dismiss();
                            if (response.isSuccessful()) {

                                IsTenantAvailable isTenantAvailable = response.body();
                                if (isTenantAvailable.success) {
                                    if (isTenantAvailable.getResult().tenantId != null) {
                                        txt_tenantid.setText(isTenantAvailable.getResult().getTenantId());
                                        id = Integer.parseInt(isTenantAvailable.getResult().getTenantId());
                                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<IsTenantAvailable> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
                            customLoader.dismiss();
                        }
                    });
                }
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
            }
        });

        alert.show();
    }

    @Override
    public void onSuccessfully(UserData userData) {
        customLoader.dismiss();
        Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
        finish();
    }

    @Override
    public void onFailure(String message) {
        customLoader.dismiss();
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
