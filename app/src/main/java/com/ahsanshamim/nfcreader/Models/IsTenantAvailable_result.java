package com.ahsanshamim.nfcreader.Models;

import com.google.gson.annotations.SerializedName;

public class IsTenantAvailable_result {
    @SerializedName("state")
    public String state;
    @SerializedName("tenantId")
    public String tenantId;
    @SerializedName("serverRootAddress")
    public String serverRootAddress;
}
