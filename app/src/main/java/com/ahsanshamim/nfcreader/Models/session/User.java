package com.ahsanshamim.nfcreader.Models.session;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("name")
    public String name;
    @SerializedName("surname")
    public String surname;
    @SerializedName("userName")
    public String userName;
    @SerializedName("emailAddress")
    public String emailAddress;
    @SerializedName("profilePictureId")
    public Object profilePictureId;
    @SerializedName("id")
    public int id;
}
