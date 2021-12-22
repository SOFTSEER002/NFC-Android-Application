package com.ahsanshamim.nfcreader.Models.session;

import com.google.gson.annotations.SerializedName;

public class CurrentSessionModel {
    @SerializedName("user")
    public User user;
    @SerializedName("impersonatorUser")
    public Object impersonatorUser;
    @SerializedName("tenant")
    public Tenant tenant;
    @SerializedName("impersonatorTenant")
    public Object impersonatorTenant;
    @SerializedName("application")
    public Application application;
    @SerializedName("targetUrl")
    public Object targetUrl;
    @SerializedName("success")
    public boolean success;
    @SerializedName("error")
    public Object error;
    @SerializedName("unAuthorizedRequest")
    public boolean unAuthorizedRequest;
    @SerializedName("__abp")
    public boolean __abp;
    @SerializedName("theme")
    public Theme theme;
}
