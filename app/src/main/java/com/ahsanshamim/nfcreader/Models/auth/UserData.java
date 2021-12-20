package com.ahsanshamim.nfcreader.Models.auth;

import com.ahsanshamim.nfcreader.Models.ErrorModel;
import com.google.gson.annotations.SerializedName;

public class UserData {
    @SerializedName("targetUrl")
    String targetUrl = null;

    @SerializedName("success")
    Boolean success = false;

    @SerializedName("error")
    ErrorModel error = null;

    @SerializedName("unAuthorizedRequest")
    Boolean unAuthorizedRequest = false;

    @SerializedName("__abp")
    Boolean __abp = false;

    @SerializedName("result")
    LoginData result;


    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ErrorModel getError() {
        return error;
    }

    public void setError(ErrorModel error) {
        this.error = error;
    }

    public Boolean getUnAuthorizedRequest() {
        return unAuthorizedRequest;
    }

    public void setUnAuthorizedRequest(Boolean unAuthorizedRequest) {
        this.unAuthorizedRequest = unAuthorizedRequest;
    }

    public Boolean get__abp() {
        return __abp;
    }

    public void set__abp(Boolean __abp) {
        this.__abp = __abp;
    }

    public LoginData getResult() {
        return result;
    }

    public void setResult(LoginData result) {
        this.result = result;
    }
}
