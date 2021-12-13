package com.ahsanshamim.nfcreader.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ahsanshamim.nfcreader.Adapters.productsrecyclerviewadptr;
import com.ahsanshamim.nfcreader.Models.IsTenantAvailable;
import com.ahsanshamim.nfcreader.Models.getproductsInfo;
import com.ahsanshamim.nfcreader.Models.istenant_body;
import com.ahsanshamim.nfcreader.R;
import com.ahsanshamim.nfcreader.RetrofitAPI.APIClient;
import com.ahsanshamim.nfcreader.RetrofitAPI.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button btn_login;
    EditText edt_username, edt_password;
    APIInterface apiInterface;
    TextView txt_tenantid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        txt_tenantid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup_teltenant();
            }
        });
    }

    void init(){
        btn_login = findViewById(R.id.btnlogin);
        edt_username = findViewById(R.id.edt_user);
        edt_password = findViewById(R.id.edt_pass);
        txt_tenantid = findViewById(R.id.txt_tenantid);
    }

    private void popup_teltenant(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Authenticate Through tenant Id");
        alert.setMessage("Enter Tenant ID / Name");

        // Set an EditText view to get user input
        final EditText input = new EditText(this);
        alert.setView(input);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                if(!input.getText().equals("")){
                    istenant_body istenantBody = new istenant_body();
                    istenantBody.tenancyName = input.getText().toString();
                    apiInterface = APIClient.getClient().create(APIInterface.class);
                    Call<IsTenantAvailable> call = apiInterface.get_istenantavailable(istenantBody);

                    call.enqueue(new Callback<IsTenantAvailable>() {
                        @Override
                        public void onResponse(Call<IsTenantAvailable> call, Response<IsTenantAvailable> response) {
                            if(response.isSuccessful()){
                                IsTenantAvailable isTenantAvailable = response.body();
                                if(isTenantAvailable.success){
                                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<IsTenantAvailable> call, Throwable t) {

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
}