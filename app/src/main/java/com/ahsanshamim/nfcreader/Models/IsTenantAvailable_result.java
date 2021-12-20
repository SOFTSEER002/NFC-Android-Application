package com.ahsanshamim.nfcreader.Models;

import com.google.gson.annotations.SerializedName;

public class IsTenantAvailable_result {
    @SerializedName("state")
    public String state;
    @SerializedName("tenantId")
    public String tenantId;
    @SerializedName("serverRootAddress")
    public String serverRootAddress;


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getServerRootAddress() {
        return serverRootAddress;
    }

    public void setServerRootAddress(String serverRootAddress) {
        this.serverRootAddress = serverRootAddress;
    }
}
