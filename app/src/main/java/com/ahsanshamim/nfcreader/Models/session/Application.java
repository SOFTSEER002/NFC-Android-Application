package com.ahsanshamim.nfcreader.Models.session;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Application {
    @SerializedName("version")
    public String version;
    @SerializedName("releaseDate")
    public String releaseDate;
    @SerializedName("currency")
    public String currency;
    @SerializedName("currencySign")
    public String currencySign;
    @SerializedName("allowTenantsToChangeEmailSettings")
    public boolean allowTenantsToChangeEmailSettings;
    @SerializedName("userDelegationIsEnabled")
    public boolean userDelegationIsEnabled;
    @SerializedName("twoFactorCodeExpireSeconds")
    public double twoFactorCodeExpireSeconds;
    @SerializedName("features")
    public Features features;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrencySign() {
        return currencySign;
    }

    public void setCurrencySign(String currencySign) {
        this.currencySign = currencySign;
    }

    public boolean isAllowTenantsToChangeEmailSettings() {
        return allowTenantsToChangeEmailSettings;
    }

    public void setAllowTenantsToChangeEmailSettings(boolean allowTenantsToChangeEmailSettings) {
        this.allowTenantsToChangeEmailSettings = allowTenantsToChangeEmailSettings;
    }

    public boolean isUserDelegationIsEnabled() {
        return userDelegationIsEnabled;
    }

    public void setUserDelegationIsEnabled(boolean userDelegationIsEnabled) {
        this.userDelegationIsEnabled = userDelegationIsEnabled;
    }

    public double getTwoFactorCodeExpireSeconds() {
        return twoFactorCodeExpireSeconds;
    }

    public void setTwoFactorCodeExpireSeconds(double twoFactorCodeExpireSeconds) {
        this.twoFactorCodeExpireSeconds = twoFactorCodeExpireSeconds;
    }

    public Features getFeatures() {
        return features;
    }

    public void setFeatures(Features features) {
        this.features = features;
    }
}
