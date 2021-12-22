package com.ahsanshamim.nfcreader.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.ahsanshamim.nfcreader.Models.auth.LoginData;
import com.ahsanshamim.nfcreader.Models.auth.UserData;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

public class SharePref {
    private Context context;

    private String LOGIN_USER = "login_user";
    private SharedPreferences sharedPreferences;

    public SharePref(Context context){
        this.context = context;
        this.sharedPreferences = context.getSharedPreferences("softApp",Context.MODE_PRIVATE);
    }

    public void saveLogindata(String data){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(LOGIN_USER,data);
        editor.commit();
    }
    public UserData getUserLoginData(){
        String data = sharedPreferences.getString(LOGIN_USER,"");
        if(!data.isEmpty()){
            return  new Gson().fromJson(data, UserData.class);
        }
        return null;
    }
}
