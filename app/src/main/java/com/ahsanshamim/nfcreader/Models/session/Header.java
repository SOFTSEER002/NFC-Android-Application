package com.ahsanshamim.nfcreader.Models.session;

import com.google.gson.annotations.SerializedName;

public class Header {
    @SerializedName("desktopFixedHeader")
    public boolean desktopFixedHeader;
    @SerializedName("mobileFixedHeader")
    public boolean mobileFixedHeader;
    @SerializedName("headerSkin")
    public Object headerSkin;
    @SerializedName("minimizeDesktopHeaderType")
    public Object minimizeDesktopHeaderType;

}
