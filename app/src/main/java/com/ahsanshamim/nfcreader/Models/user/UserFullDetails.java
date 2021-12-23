package com.ahsanshamim.nfcreader.Models.user;

import com.google.gson.annotations.SerializedName;

public class UserFullDetails {

    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("surname")
    public String surname;
    @SerializedName("userName")
    public String userName;
    @SerializedName("emailAddress")
    public String emailAddress;
    @SerializedName("phoneNumber")
    public String phoneNumber;
    @SerializedName("password")
    public Object password;
    @SerializedName("isActive")
    public boolean isActive;
    @SerializedName("profilePhoto")
    public Object profilePhoto;
    @SerializedName("dob")
    public Object dob;
    @SerializedName("address")
    public Object address;
    @SerializedName("latitude")
    public String latitude;
    @SerializedName("logitude")
    public String logitude;
    @SerializedName("profileVerified")
    public boolean profileVerified;
    @SerializedName("coinPoints_Value")
    public int coinPoints_Value;
    @SerializedName("userCode")
    public int userCode;
    @SerializedName("clientCode")
    public int clientCode;
    @SerializedName("nationalIdNo")
    public int nationalIdNo;
    @SerializedName("status")
    public boolean status;
    @SerializedName("shouldChangePasswordOnNextLogin")
    public boolean shouldChangePasswordOnNextLogin;
    @SerializedName("isTwoFactorEnabled")
    public boolean isTwoFactorEnabled;
    @SerializedName("isLockoutEnabled")
    public boolean isLockoutEnabled;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Object getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(Object profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public Object getDob() {
        return dob;
    }

    public void setDob(Object dob) {
        this.dob = dob;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLogitude() {
        return logitude;
    }

    public void setLogitude(String logitude) {
        this.logitude = logitude;
    }

    public boolean isProfileVerified() {
        return profileVerified;
    }

    public void setProfileVerified(boolean profileVerified) {
        this.profileVerified = profileVerified;
    }

    public int getCoinPoints_Value() {
        return coinPoints_Value;
    }

    public void setCoinPoints_Value(int coinPoints_Value) {
        this.coinPoints_Value = coinPoints_Value;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public int getClientCode() {
        return clientCode;
    }

    public void setClientCode(int clientCode) {
        this.clientCode = clientCode;
    }

    public int getNationalIdNo() {
        return nationalIdNo;
    }

    public void setNationalIdNo(int nationalIdNo) {
        this.nationalIdNo = nationalIdNo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isShouldChangePasswordOnNextLogin() {
        return shouldChangePasswordOnNextLogin;
    }

    public void setShouldChangePasswordOnNextLogin(boolean shouldChangePasswordOnNextLogin) {
        this.shouldChangePasswordOnNextLogin = shouldChangePasswordOnNextLogin;
    }

    public boolean isTwoFactorEnabled() {
        return isTwoFactorEnabled;
    }

    public void setTwoFactorEnabled(boolean twoFactorEnabled) {
        isTwoFactorEnabled = twoFactorEnabled;
    }

    public boolean isLockoutEnabled() {
        return isLockoutEnabled;
    }

    public void setLockoutEnabled(boolean lockoutEnabled) {
        isLockoutEnabled = lockoutEnabled;
    }
}
