package com.ahsanshamim.nfcreader.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ahsanshamim.nfcreader.Models.ItemInfo;
import com.ahsanshamim.nfcreader.Models.getproductinfo;
import com.ahsanshamim.nfcreader.Models.getproductsInfo;
import com.ahsanshamim.nfcreader.Models.iteminfoP;
import com.ahsanshamim.nfcreader.Models.responseproduct;
import com.ahsanshamim.nfcreader.R;
import com.ahsanshamim.nfcreader.RetrofitAPI.APIClient;
import com.ahsanshamim.nfcreader.RetrofitAPI.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductViewActivity extends AppCompatActivity {
    private EditText edtname, edtprice, edtquan, edtdesc, edtkey,edtdate;
    private APIInterface apiInterface;
    private ImageView ivBack;
    private String id = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                id= null;
            } else {
                id= extras.getString("decrypt");
            }
        } else {
            id= (String) savedInstanceState.getSerializable("decrypt");
        }
        initview();
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<getproductinfo> call = apiInterface.getproductbyid(id);

        call.enqueue(new Callback<getproductinfo>() {
            @Override
            public void onResponse(Call<getproductinfo> call, Response<getproductinfo> response) {
                if(response.isSuccessful()){
                    getproductinfo product = response.body();
                    ItemInfo item = product.product;
                    if(!item.items.name.equals("")){
                        edtname.setText(item.items.name);
                        edtprice.setText(String.valueOf(item.items.price));
                        edtquan.setText(String.valueOf(item.items.quantity));
                        edtdesc.setText(item.items.description);
                        edtdate.setText(item.items.creation_date);
                        edtkey.setText(item.decryption_key);
                    }
                }
            }

            @Override
            public void onFailure(Call<getproductinfo> call, Throwable t) {

            }
        });
    }

    private void initview(){
        edtname = findViewById(R.id.edtname);
        edtprice = findViewById(R.id.edtprice);
        edtquan = findViewById(R.id.edtquan);
        edtdesc = findViewById(R.id.edtdesc);
        edtkey = findViewById(R.id.edtkey);
        ivBack = findViewById(R.id.ivBack);
        edtdate = findViewById(R.id.edtdate);

        edtname.setFocusable(false);
        edtprice.setFocusable(false);
        edtquan.setFocusable(false);
        edtdesc.setFocusable(false);
        edtkey.setFocusable(false);
        edtdate.setFocusable(false);
    }
}