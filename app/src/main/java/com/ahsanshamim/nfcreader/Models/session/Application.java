package com.ahsanshamim.nfcreader.Models.session;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Application {
    @SerializedName("version")
    public String version;
    @SerializedName("releaseDate")
    public Date releaseDate;
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
}
