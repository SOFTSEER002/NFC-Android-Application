package com.ahsanshamim.nfcreader.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ahsanshamim.nfcreader.Models.ItemInfo;
import com.ahsanshamim.nfcreader.Models.Items;
import com.ahsanshamim.nfcreader.Models.getproductsInfo;
import com.ahsanshamim.nfcreader.Models.iteminfoP;
import com.ahsanshamim.nfcreader.Models.responseproduct;
import com.ahsanshamim.nfcreader.R;
import com.ahsanshamim.nfcreader.RetrofitAPI.APIClient;
import com.ahsanshamim.nfcreader.RetrofitAPI.APIInterface;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.KeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WriteProductActivity extends AppCompatActivity {
    private EditText edtname, edtprice, edtquan, edtdesc, edtkey;
    private Button btncreate;
    private APIInterface apiInterface;
    private ImageView ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_product);

        initview();
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtname.getText().toString().matches("")){
                    Toast.makeText(getApplicationContext(), "You did not enter a Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(edtprice.getText().toString().matches("")){
                    Toast.makeText(getApplicationContext(), "You did not enter a Price", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(edtquan.getText().toString().matches("")){
                    Toast.makeText(getApplicationContext(), "You did not enter a Quantity", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(edtdesc.getText().toString().matches("")){
                    Toast.makeText(getApplicationContext(), "You did not enter a Description", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(edtkey.getText().toString().matches("")){
                    Toast.makeText(getApplicationContext(), "You did not enter a KEY", Toast.LENGTH_SHORT).show();
                    return;
                }
                iteminfoP iteminfo = new iteminfoP();
                try {
                    iteminfo.decryption_key = edtkey.getText().toString();
                    Items item = new Items();
                    item.name = edtname.getText().toString();
                    item.price = Integer.valueOf(edtprice.getText().toString());
                    item.quantity = Integer.valueOf(edtquan.getText().toString());
                    item.description = edtdesc.getText().toString();
                    iteminfo.items = item;
                    apiInterface = APIClient.getClient().create(APIInterface.class);
                    Call<responseproduct> call = apiInterface.setproducts(iteminfo);

                    call.enqueue(new Callback<responseproduct>() {
                        @Override
                        public void onResponse(Call<responseproduct> call, Response<responseproduct> response) {
                            try {
                                responseproduct res = response.body();
                                Toast.makeText(getApplicationContext(), "Successfully Insert Product " + res.name, Toast.LENGTH_LONG).show();
                                onBackPressed();
                            } catch (Exception e) {
                                Toast.makeText(getApplicationContext(), e.getMessage().toString(), Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<responseproduct> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), t.getMessage().toString(), Toast.LENGTH_LONG).show();
                        }
                    });
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.getMessage().toString(), Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    private void initview(){
        edtname = findViewById(R.id.edtname);
        edtprice = findViewById(R.id.edtprice);
        edtquan = findViewById(R.id.edtquan);
        edtdesc = findViewById(R.id.edtdesc);
        edtkey = findViewById(R.id.edtkey);
        btncreate = (Button) findViewById(R.id.cirLoginButton);
        ivBack = findViewById(R.id.ivBack);
    }


}