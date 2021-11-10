package com.ahsanshamim.nfcreader.Models;

import com.google.gson.annotations.SerializedName;

public class iteminfoP {
    @SerializedName("items")
    public Items items;
    @SerializedName("decryption_key")
    public String decryption_key;
}
