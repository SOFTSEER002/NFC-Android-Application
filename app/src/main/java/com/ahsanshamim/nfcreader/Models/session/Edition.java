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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getTrialDayCount() {
        return trialDayCount;
    }

    public void setTrialDayCount(int trialDayCount) {
        this.trialDayCount = trialDayCount;
    }

    public double getMonthlyPrice() {
        return monthlyPrice;
    }

    public void setMonthlyPrice(double monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }

    public double getAnnualPrice() {
        return annualPrice;
    }

    public void setAnnualPrice(double annualPrice) {
        this.annualPrice = annualPrice;
    }

    public boolean isHighestEdition() {
        return isHighestEdition;
    }

    public void setHighestEdition(boolean highestEdition) {
        isHighestEdition = highestEdition;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
