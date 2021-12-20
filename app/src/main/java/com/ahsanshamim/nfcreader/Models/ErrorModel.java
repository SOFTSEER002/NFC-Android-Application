package com.ahsanshamim.nfcreader.Models;

import com.google.gson.annotations.SerializedName;

public class ErrorModel {

    @SerializedName("code")
    int code;

    @SerializedName("message")
    String message = null;

    @SerializedName("details")
    String details = null;

    @SerializedName("validationErrors")
    String validationErrors = null;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(String validationErrors) {
        this.validationErrors = validationErrors;
    }
}
