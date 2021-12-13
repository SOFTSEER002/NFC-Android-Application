package com.ahsanshamim.nfcreader.Models;

import com.google.gson.annotations.SerializedName;

public class IsTenantAvailable {
    @SerializedName("result")
    public IsTenantAvailable_result result;
    @SerializedName("targetUrl")
    public String targetUrl;
    @SerializedName("success")
    public boolean success;
    @SerializedName("error")
    public String error;
    @SerializedName("unAuthorizedRequest")
    public String unAuthorizedRequest;
    @SerializedName("__abp")
    public String __abp;
}
