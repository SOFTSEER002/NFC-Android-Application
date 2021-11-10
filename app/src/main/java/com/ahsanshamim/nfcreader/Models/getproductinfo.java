package com.ahsanshamim.nfcreader.Models;

import com.google.gson.annotations.SerializedName;

public class getproductinfo {
    @SerializedName("details")
    public String details;
    @SerializedName("product")
    public ItemInfo product;
}
