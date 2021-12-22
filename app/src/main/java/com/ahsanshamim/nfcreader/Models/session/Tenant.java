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
    public Date subscriptionEndDateUtc;
    @SerializedName("isInTrialPeriod")
    public boolean isInTrialPeriod;
    @SerializedName("subscriptionPaymentType")
    public int subscriptionPaymentType;
    @SerializedName("edition")
    public Edition edition;
    @SerializedName("creationTime")
    public Date creationTime;
    @SerializedName("paymentPeriodType")
    public int paymentPeriodType;
    @SerializedName("subscriptionDateString")
    public String subscriptionDateString;
    @SerializedName("creationTimeString")
    public String creationTimeString;
    @SerializedName("id")
    public int id;
}
