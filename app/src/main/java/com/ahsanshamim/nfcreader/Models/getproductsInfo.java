package com.ahsanshamim.nfcreader.Models;

import com.google.gson.annotations.SerializedName;

public class getproductsInfo {
    @SerializedName("details")
    public String details;
    @SerializedName("products")
    public ItemInfo[] products;
}
