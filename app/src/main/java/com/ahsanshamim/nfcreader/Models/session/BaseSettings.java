package com.ahsanshamim.nfcreader.Models.session;

import android.view.Menu;

import com.google.gson.annotations.SerializedName;

public class BaseSettings {
    @SerializedName("theme")
    public String theme;
    @SerializedName("layout")
    public Layout layout;
    @SerializedName("header")
    public Header header;
    @SerializedName("subHeader")
    public SubHeader subHeader;
    @SerializedName("menu")
    public Menu menu;
    @SerializedName("footer")
    public Footer footer;
}
