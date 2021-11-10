package com.ahsanshamim.nfcreader.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ahsanshamim.nfcreader.R;
import com.ahsanshamim.nfcreader.Settings.getNetworkstate;

public class HomeActivity extends Activity implements View.OnClickListener {
    public static final String TAG = HomeActivity.class.getSimpleName();
    private RelativeLayout rlRead;
    private RelativeLayout rlWrite;
    private RelativeLayout rlCreateProduct;
    private ImageView ivHomeicon;
    private Animation mAnimation;
    AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfc_home);
        initViews();
        rlRead.setOnClickListener(this);
        rlWrite.setOnClickListener(this);
        rlCreateProduct.setOnClickListener(this);
        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (nfcAdapter == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Warning");
            builder.setMessage("Your Device does not support NFC. Press OK to Close the application.");
            builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    alertDialog.dismiss();
                    finish();
                }
            });
            alertDialog = builder.create();
            alertDialog.show();
        } else if (!nfcAdapter.isEnabled()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Message");
            builder.setMessage("Your Device Not Enable the NFC. Goto the Setting Enable the NFC then reopen the application.");
            builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    alertDialog.dismiss();
                    finish();
                }
            });
            alertDialog = builder.create();
            alertDialog.show();
        } else {
            // NFC is enabled
        }
        if(getNetworkstate.isNetworkConnected(this) == false){
            Toast.makeText(getApplicationContext(),"Internet Not Connect Please Connect the WIFI!", Toast.LENGTH_LONG).show();
            return;
        }
    }

    private void initViews() {

        rlRead = findViewById(R.id.rlReadNFCTAG);
        rlWrite = findViewById(R.id.rlWriteWithNFC);
        rlCreateProduct = findViewById(R.id.rlCreateProduct);
        ivHomeicon = findViewById(R.id.ivHomeicon);
        mAnimation = AnimationUtils.loadAnimation(HomeActivity.this, R.anim.swinging);
    }


    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.rlReadNFCTAG:
                if(getNetworkstate.isNetworkConnected(this) == false){
                    Toast.makeText(getApplicationContext(),"Internet Not Connect Please Connect the WIFI!", Toast.LENGTH_LONG).show();
                    return;
                }
                intent = new Intent(this, ReadActivity.class);
                this.startActivity(intent);
                break;

            case R.id.rlWriteWithNFC:
                if(getNetworkstate.isNetworkConnected(this) == false){
                    Toast.makeText(getApplicationContext(),"Internet Not Connect Please Connect the WIFI!", Toast.LENGTH_LONG).show();
                    return;
                }
                intent = new Intent(this, ProductsActivity.class);
                this.startActivity(intent);
                break;

            case R.id.rlCreateProduct:
                if(getNetworkstate.isNetworkConnected(this) == false){
                    Toast.makeText(getApplicationContext(),"Internet Not Connect Please Connect the WIFI!", Toast.LENGTH_LONG).show();
                    return;
                }
                intent = new Intent(this, WriteProductActivity.class);
                this.startActivity(intent);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        ivHomeicon.startAnimation(mAnimation);
    }

    @Override
    public void onPause() {
        ivHomeicon.clearAnimation();
        super.onPause();
    }
}