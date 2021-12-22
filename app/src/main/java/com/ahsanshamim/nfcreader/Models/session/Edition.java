package com.ahsanshamim.nfcreader.Models.session;

import com.google.gson.annotations.SerializedName;

public class Edition {
    @SerializedName("displayName")
    public String displayName;
    @SerializedName("trialDayCount")
    public int trialDayCount;
    @SerializedName("monthlyPrice")
    public double monthlyPrice;
    @SerializedName("annualPrice")
    public double annualPrice;
    @SerializedName("isHighestEdition")
    public boolean isHighestEdition;
    @SerializedName("isFree")
    public boolean isFree;
    @SerializedName("id")
    public int id;
}
