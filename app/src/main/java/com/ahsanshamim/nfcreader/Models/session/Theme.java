package com.ahsanshamim.nfcreader.Models.session;

import com.google.gson.annotations.SerializedName;

public class Theme {

    @SerializedName("baseSettings")
    public BaseSettings baseSettings;
    @SerializedName("isLeftMenuUsed")
    public boolean isLeftMenuUsed;
    @SerializedName("isTopMenuUsed")
    public boolean isTopMenuUsed;
    @SerializedName("isTabMenuUsed")
    public boolean isTabMenuUsed;
    @SerializedName("allowMenuScroll")
    public boolean allowMenuScroll;

}
