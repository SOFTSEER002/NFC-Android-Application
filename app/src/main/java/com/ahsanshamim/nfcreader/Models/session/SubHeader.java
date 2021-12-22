package com.ahsanshamim.nfcreader.Models.session;

import com.google.gson.annotations.SerializedName;

public class SubHeader {
    @SerializedName("position")
    public String position;
    @SerializedName("asideSkin")
    public String asideSkin;
    @SerializedName("fixedAside")
    public boolean fixedAside;
    @SerializedName("allowAsideMinimizing")
    public boolean allowAsideMinimizing;
    @SerializedName("defaultMinimizedAside")
    public boolean defaultMinimizedAside;
    @SerializedName("submenuToggle")
    public String submenuToggle;
    @SerializedName("searchActive")
    public boolean searchActive;
    @SerializedName("enableSecondary")
    public boolean enableSecondary;
    @SerializedName("hoverableAside")
    public boolean hoverableAside;
}
