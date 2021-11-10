package com.ahsanshamim.nfcreader.Models;

import com.google.gson.annotations.SerializedName;

public class ItemInfo {
    @SerializedName("_id")
    public ItemobjectId _id;
    @SerializedName("items")
    public Items items;
    @SerializedName("decryption_key")
    public String decryption_key;


}
