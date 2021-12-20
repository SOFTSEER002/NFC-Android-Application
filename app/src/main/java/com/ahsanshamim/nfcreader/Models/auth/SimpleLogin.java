package com.ahsanshamim.nfcreader.Models.auth;

import com.google.gson.annotations.SerializedName;

public class SimpleLogin {


    @SerializedName("usernameoremailaddress")
    String usernameoremailaddress = null;


    @SerializedName("password")
    String password = null;


    public String getUsernameoremailaddress() {
        return usernameoremailaddress;
    }

    public void setUsernameoremailaddress(String usernameoremailaddress) {
        this.usernameoremailaddress = usernameoremailaddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
