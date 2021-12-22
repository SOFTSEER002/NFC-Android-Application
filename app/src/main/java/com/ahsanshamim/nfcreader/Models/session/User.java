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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Object getProfilePictureId() {
        return profilePictureId;
    }

    public void setProfilePictureId(Object profilePictureId) {
        this.profilePictureId = profilePictureId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
