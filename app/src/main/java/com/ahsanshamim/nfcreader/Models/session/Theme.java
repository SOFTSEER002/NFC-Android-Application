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

    public BaseSettings getBaseSettings() {
        return baseSettings;
    }

    public void setBaseSettings(BaseSettings baseSettings) {
        this.baseSettings = baseSettings;
    }

    public boolean isLeftMenuUsed() {
        return isLeftMenuUsed;
    }

    public void setLeftMenuUsed(boolean leftMenuUsed) {
        isLeftMenuUsed = leftMenuUsed;
    }

    public boolean isTopMenuUsed() {
        return isTopMenuUsed;
    }

    public void setTopMenuUsed(boolean topMenuUsed) {
        isTopMenuUsed = topMenuUsed;
    }

    public boolean isTabMenuUsed() {
        return isTabMenuUsed;
    }

    public void setTabMenuUsed(boolean tabMenuUsed) {
        isTabMenuUsed = tabMenuUsed;
    }

    public boolean isAllowMenuScroll() {
        return allowMenuScroll;
    }

    public void setAllowMenuScroll(boolean allowMenuScroll) {
        this.allowMenuScroll = allowMenuScroll;
    }
}
