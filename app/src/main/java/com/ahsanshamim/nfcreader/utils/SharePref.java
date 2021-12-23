package com.ahsanshamim.nfcreader.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.ahsanshamim.nfcreader.Models.auth.LoginData;
import com.ahsanshamim.nfcreader.Models.auth.UserData;
import com.ahsanshamim.nfcreader.Models.user.UserDetailsResponse;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

public class SharePref {
    private Context context;

    private String LOGIN_USER = "login_user";
    private String USER_DETAILS = "user_details";
    private SharedPreferences sharedPreferences;

    public SharePref(Context context){
        this.context = context;
        this.sharedPreferences = context.getSharedPreferences("softApp",Context.MODE_PRIVATE);
    }

    /**
     * user saveed after login
     * @param data
     */
    public void saveLogindata(String data){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(LOGIN_USER,data);
        editor.commit();
    }

    /**
     * get user login details
     * @return
     */
    public UserData getUserLoginData(){
        String data = sharedPreferences.getString(LOGIN_USER,"");
        if(!data.isEmpty()){
            return  new Gson().fromJson(data, UserData.class);
        }
        return null;
    }

    /**
     * save user details after seacrch by id
     * @param data
     */
    public void saveUserFullDetails(String data){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_DETAILS,data);
        editor.commit();
    }
    /**
     * get user full details
     * @return
     */
    public UserDetailsResponse getUserFullDetails(){
        String data = sharedPreferences.getString(USER_DETAILS,"");
        if(!data.isEmpty()){
            return  new Gson().fromJson(data, UserDetailsResponse.class);
        }
        return null;
    }
}
