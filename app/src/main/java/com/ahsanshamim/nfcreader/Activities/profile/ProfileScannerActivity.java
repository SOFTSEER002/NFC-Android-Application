package com.ahsanshamim.nfcreader.Activities.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.ahsanshamim.nfcreader.R;
import com.ahsanshamim.nfcreader.utils.CustomLoader;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.ThreeBounce;

public class ProfileScannerActivity extends AppCompatActivity {

    ProgressBar progressBar;
    CustomLoader customLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_scanner);
        setXML();
    }
    private void setXML(){
        customLoader = new CustomLoader(ProfileScannerActivity.this);
        progressBar =  findViewById(R.id.spin_kit);
        Sprite doubleBounce = new ThreeBounce();
        progressBar.setIndeterminateDrawable(doubleBounce);
        customLoader.showProgressDialog();
        new Handler().postDelayed(() -> {
            customLoader.dismiss();
            startActivity(new Intent(getApplicationContext(),ProfileDetailsActivity.class));
        },2000);
    }
}
