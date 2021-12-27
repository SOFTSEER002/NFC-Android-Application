package com.ahsanshamim.nfcreader.Models.candidate;

import com.google.gson.annotations.SerializedName;

public class CandidateResponse {


    @SerializedName("result")
    public CandidateResult result;
    @SerializedName("targetUrl")
    public String targetUrl;
    @SerializedName("success")
    public boolean success;
    @SerializedName("error")
    public Error error;
    @SerializedName("unAuthorizedRequest")
    public boolean unAuthorizedRequest;
    @SerializedName("__abp")
    public boolean __abp;


    public CandidateResult getResult() {
        return result;
    }

    public void setResult(CandidateResult result) {
        this.result = result;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String  targetUrl) {
        this.targetUrl = targetUrl;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
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
