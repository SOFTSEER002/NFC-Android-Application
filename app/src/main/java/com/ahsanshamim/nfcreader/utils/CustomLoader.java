package com.ahsanshamim.nfcreader.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.ahsanshamim.nfcreader.R;

public class CustomLoader extends Dialog {
    public CustomLoader(@NonNull Context context) {
        super(context);
    }
    public void showProgressDialog(){
        setContentView(R.layout.loader);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        ImageView img = findViewById(R.id.loader_one);
        Animation aniRotate = AnimationUtils.loadAnimation(getContext(),R.anim.clock_rotate);
        img.startAnimation(aniRotate);

        ImageView img2 = findViewById(R.id.loader_two);
        Animation aniRotate2 = AnimationUtils.loadAnimation(getContext(),R.anim.anticlock_rotate);
        img2.startAnimation(aniRotate2);
        show();
    }
}
