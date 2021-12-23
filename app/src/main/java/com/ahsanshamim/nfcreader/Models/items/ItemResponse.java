package com.ahsanshamim.nfcreader.Models.items;

import com.google.gson.annotations.SerializedName;

public class ItemResponse {

    @SerializedName("result")
    public ItemResult result;
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

    public ItemResult getResult() {
        return result;
    }

    public void setResult(ItemResult result) {
        this.result = result;
    }

    public Object getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(Object targetUrl) {
        this.targetUrl = targetUrl;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public boolean isUnAuthorizedRequest() {
        return unAuthorizedRequest;
    }

    public void setUnAuthorizedRequest(boolean unAuthorizedRequest) {
        this.unAuthorizedRequest = unAuthorizedRequest;
    }

    public boolean is__abp() {
        return __abp;
    }

    public void set__abp(boolean __abp) {
        this.__abp = __abp;
    }
}
