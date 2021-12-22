package com.ahsanshamim.nfcreader.Models.session;

import com.google.gson.annotations.SerializedName;

public class Footer {
    @SerializedName("fixedFooter")
    public boolean fixedFooter;

    public boolean isFixedFooter() {
        return fixedFooter;
    }

    public void setFixedFooter(boolean fixedFooter) {
        this.fixedFooter = fixedFooter;
    }
}
