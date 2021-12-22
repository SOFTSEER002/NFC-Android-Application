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

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public SubHeader getSubHeader() {
        return subHeader;
    }

    public void setSubHeader(SubHeader subHeader) {
        this.subHeader = subHeader;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Footer getFooter() {
        return footer;
    }

    public void setFooter(Footer footer) {
        this.footer = footer;
    }
}
