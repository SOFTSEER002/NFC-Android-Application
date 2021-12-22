package com.ahsanshamim.nfcreader.Models.session;

public class SessionRequest {
    String accessToken;
    String encryptedAccessToken;
    String expireInSeconds;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
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
}
