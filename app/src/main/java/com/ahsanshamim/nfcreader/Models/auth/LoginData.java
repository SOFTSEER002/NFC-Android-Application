package com.ahsanshamim.nfcreader.Models.auth;

import com.google.gson.annotations.SerializedName;

public class LoginData {
    @SerializedName("accessToken")
    String token = null;

    @SerializedName("encryptedAccessToken")
    String encryptedAccessToken = null;


    @SerializedName("expireInSeconds")
    String expireInSeconds = null;

    @SerializedName("shouldResetPassword")
    Boolean shouldResetPassword = false;

    @SerializedName("passwordResetCode")
    String passwordResetCode = null;


    @SerializedName("userId")
    int userId;

    @SerializedName("requiresTwoFactorVerification")
    Boolean requiresTwoFactorVerification = false;

    @SerializedName("twoFactorAuthProviders")
    String twoFactorAuthProviders = null;

    @SerializedName("twoFactorRememberClientToken")
    String twoFactorRememberClientToken = null;


    @SerializedName("returnUrl")
    String returnUrl = null;


    @SerializedName("refreshToken")
    String refreshToken = null;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEncryptedAccessToken() {
        return encryptedAccessToken;
    }

    public void setEncryptedAccessToken(String encryptedAccessToken) {
        this.encryptedAccessToken = encryptedAccessToken;
    }

    public String getExpireInSeconds() {
        return expireInSeconds;
    }

    public void setExpireInSeconds(String expireInSeconds) {
        this.expireInSeconds = expireInSeconds;
    }

    public Boolean getShouldResetPassword() {
        return shouldResetPassword;
    }

    public void setShouldResetPassword(Boolean shouldResetPassword) {
        this.shouldResetPassword = shouldResetPassword;
    }

    public String getPasswordResetCode() {
        return passwordResetCode;
    }

    public void setPasswordResetCode(String passwordResetCode) {
        this.passwordResetCode = passwordResetCode;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Boolean getRequiresTwoFactorVerification() {
        return requiresTwoFactorVerification;
    }

    public void setRequiresTwoFactorVerification(Boolean requiresTwoFactorVerification) {
        this.requiresTwoFactorVerification = requiresTwoFactorVerification;
    }

    public String getTwoFactorAuthProviders() {
        return twoFactorAuthProviders;
    }

    public void setTwoFactorAuthProviders(String twoFactorAuthProviders) {
        this.twoFactorAuthProviders = twoFactorAuthProviders;
    }

    public String getTwoFactorRememberClientToken() {
        return twoFactorRememberClientToken;
    }

    public void setTwoFactorRememberClientToken(String twoFactorRememberClientToken) {
        this.twoFactorRememberClientToken = twoFactorRememberClientToken;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
