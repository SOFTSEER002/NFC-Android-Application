package com.ahsanshamim.nfcreader.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ahsanshamim.nfcreader.Adapters.productsrecyclerviewadptr;
import com.ahsanshamim.nfcreader.Models.getproductsInfo;
import com.ahsanshamim.nfcreader.R;
import com.ahsanshamim.nfcreader.RetrofitAPI.APIClient;
import com.ahsanshamim.nfcreader.RetrofitAPI.APIInterface;
import com.facebook.shimmer.ShimmerFrameLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ShimmerFrameLayout shimmerFrameLayout;
    APIInterface apiInterface;
    private ImageView ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        recyclerView = (RecyclerView) findViewById(R.id.productrecylerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        shimmerFrameLayout = (ShimmerFrameLayout) findViewById(R.id.shimmer_view_container);
        ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        SetRFID_RetrofitAPI();
    }

    private void SetRFID_RetrofitAPI() {
        if(isNetworkConnected() == false){
            Toast.makeText(getApplicationContext(),"Internet Not Connect Please Connect the WIFI!", Toast.LENGTH_LONG).show();
            onBackPressed();
            return;
        }
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<getproductsInfo> call = apiInterface.getproducts();

        call.enqueue(new Callback<getproductsInfo>() {
            @Override
            public void onResponse(Call<getproductsInfo> call, Response<getproductsInfo> response) {
                if(response.isSuccessful()) {
                    getproductsInfo getproductsInfo = response.body();
                    if(getproductsInfo.products.length > 0){
                        shimmerFrameLayout.stopShimmer();
                        shimmerFrameLayout.hideShimmer();
                        shimmerFrameLayout.setVisibility(View.GONE);
                        recyclerView.setAdapter(new productsrecyclerviewadptr(getApplicationContext(), getproductsInfo.products));

                    }else{
                        shimmerFrameLayout.stopShimmer();
                        shimmerFrameLayout.hideShimmer();
                        shimmerFrameLayout.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(),"Warning - No Records Found.", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<getproductsInfo> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Warning - No Records Found.", Toast.LENGTH_LONG).show();
            }
        });


    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

}