package com.ahsanshamim.nfcreader.Models.session;

import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("user")
    public User user;

    @SerializedName("tenant")
    public Tenant tenant;

    @SerializedName("application")
    public Application application;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }



    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }


}
