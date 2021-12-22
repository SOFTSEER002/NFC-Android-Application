package com.ahsanshamim.nfcreader.Models.session;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Tenant {

    @SerializedName("tenancyName")
    public String tenancyName;
    @SerializedName("name")
    public String name;
    @SerializedName("logoId")
    public Object logoId;
    @SerializedName("logoFileType")
    public Object logoFileType;
    @SerializedName("customCssId")
    public Object customCssId;
    @SerializedName("subscriptionEndDateUtc")
    public String subscriptionEndDateUtc;
    @SerializedName("isInTrialPeriod")
    public boolean isInTrialPeriod;
    @SerializedName("subscriptionPaymentType")
    public int subscriptionPaymentType;
    @SerializedName("edition")
    public Edition edition;
    @SerializedName("creationTime")
    public String creationTime;
    @SerializedName("paymentPeriodType")
    public int paymentPeriodType;
    @SerializedName("subscriptionDateString")
    public String subscriptionDateString;
    @SerializedName("creationTimeString")
    public String creationTimeString;
    @SerializedName("id")
    public int id;

    public String getTenancyName() {
        return tenancyName;
    }

    public void setTenancyName(String tenancyName) {
        this.tenancyName = tenancyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getLogoId() {
        return logoId;
    }

    public void setLogoId(Object logoId) {
        this.logoId = logoId;
    }

    public Object getLogoFileType() {
        return logoFileType;
    }

    public void setLogoFileType(Object logoFileType) {
        this.logoFileType = logoFileType;
    }

    public Object getCustomCssId() {
        return customCssId;
    }

    public void setCustomCssId(Object customCssId) {
        this.customCssId = customCssId;
    }

    public String getSubscriptionEndDateUtc() {
        return subscriptionEndDateUtc;
    }

    public void setSubscriptionEndDateUtc(String subscriptionEndDateUtc) {
        this.subscriptionEndDateUtc = subscriptionEndDateUtc;
    }

    public boolean isInTrialPeriod() {
        return isInTrialPeriod;
    }

    public void setInTrialPeriod(boolean inTrialPeriod) {
        isInTrialPeriod = inTrialPeriod;
    }

    public int getSubscriptionPaymentType() {
        return subscriptionPaymentType;
    }

    public void setSubscriptionPaymentType(int subscriptionPaymentType) {
        this.subscriptionPaymentType = subscriptionPaymentType;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public int getPaymentPeriodType() {
        return paymentPeriodType;
    }

    public void setPaymentPeriodType(int paymentPeriodType) {
        this.paymentPeriodType = paymentPeriodType;
    }

    public String getSubscriptionDateString() {
        return subscriptionDateString;
    }

    public void setSubscriptionDateString(String subscriptionDateString) {
        this.subscriptionDateString = subscriptionDateString;
    }

    public String getCreationTimeString() {
        return creationTimeString;
    }

    public void setCreationTimeString(String creationTimeString) {
        this.creationTimeString = creationTimeString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
