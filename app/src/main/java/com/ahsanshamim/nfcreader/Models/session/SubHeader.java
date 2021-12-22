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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAsideSkin() {
        return asideSkin;
    }

    public void setAsideSkin(String asideSkin) {
        this.asideSkin = asideSkin;
    }

    public boolean isFixedAside() {
        return fixedAside;
    }

    public void setFixedAside(boolean fixedAside) {
        this.fixedAside = fixedAside;
    }

    public boolean isAllowAsideMinimizing() {
        return allowAsideMinimizing;
    }

    public void setAllowAsideMinimizing(boolean allowAsideMinimizing) {
        this.allowAsideMinimizing = allowAsideMinimizing;
    }

    public boolean isDefaultMinimizedAside() {
        return defaultMinimizedAside;
    }

    public void setDefaultMinimizedAside(boolean defaultMinimizedAside) {
        this.defaultMinimizedAside = defaultMinimizedAside;
    }

    public String getSubmenuToggle() {
        return submenuToggle;
    }

    public void setSubmenuToggle(String submenuToggle) {
        this.submenuToggle = submenuToggle;
    }

    public boolean isSearchActive() {
        return searchActive;
    }

    public void setSearchActive(boolean searchActive) {
        this.searchActive = searchActive;
    }

    public boolean isEnableSecondary() {
        return enableSecondary;
    }

    public void setEnableSecondary(boolean enableSecondary) {
        this.enableSecondary = enableSecondary;
    }

    public boolean isHoverableAside() {
        return hoverableAside;
    }

    public void setHoverableAside(boolean hoverableAside) {
        this.hoverableAside = hoverableAside;
    }
}
