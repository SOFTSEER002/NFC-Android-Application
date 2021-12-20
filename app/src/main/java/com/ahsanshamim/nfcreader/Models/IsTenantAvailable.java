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


    public IsTenantAvailable_result getResult() {
        return result;
    }

    public void setResult(IsTenantAvailable_result result) {
        this.result = result;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getUnAuthorizedRequest() {
        return unAuthorizedRequest;
    }

    public void setUnAuthorizedRequest(String unAuthorizedRequest) {
        this.unAuthorizedRequest = unAuthorizedRequest;
    }

    public String get__abp() {
        return __abp;
    }

    public void set__abp(String __abp) {
        this.__abp = __abp;
    }
}
