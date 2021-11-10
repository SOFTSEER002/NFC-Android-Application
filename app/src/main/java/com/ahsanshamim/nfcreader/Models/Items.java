package com.ahsanshamim.nfcreader.Models;

import com.google.gson.annotations.SerializedName;

public class Items {
    @SerializedName("name")
    public String name;
    @SerializedName("creation_date")
    public String creation_date;
    @SerializedName("price")
    public Integer price;
    @SerializedName("description")
    public String description;
    @SerializedName("quantity")
    public Integer quantity;
}
