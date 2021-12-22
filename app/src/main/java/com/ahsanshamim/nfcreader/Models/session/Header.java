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

    public boolean isDesktopFixedHeader() {
        return desktopFixedHeader;
    }

    public void setDesktopFixedHeader(boolean desktopFixedHeader) {
        this.desktopFixedHeader = desktopFixedHeader;
    }

    public boolean isMobileFixedHeader() {
        return mobileFixedHeader;
    }

    public void setMobileFixedHeader(boolean mobileFixedHeader) {
        this.mobileFixedHeader = mobileFixedHeader;
    }

    public Object getHeaderSkin() {
        return headerSkin;
    }

    public void setHeaderSkin(Object headerSkin) {
        this.headerSkin = headerSkin;
    }

    public Object getMinimizeDesktopHeaderType() {
        return minimizeDesktopHeaderType;
    }

    public void setMinimizeDesktopHeaderType(Object minimizeDesktopHeaderType) {
        this.minimizeDesktopHeaderType = minimizeDesktopHeaderType;
    }
}
