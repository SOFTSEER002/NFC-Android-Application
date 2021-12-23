package com.ahsanshamim.nfcreader.Models.user;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResult {
    @SerializedName("profilePictureId")
    public String profilePictureId;
    @SerializedName("user")
    public UserFullDetails user;
    @SerializedName("roles")
    public List<Role> roles;
    @SerializedName("allOrganizationUnits")
    public List<AllOrganizationUnit> allOrganizationUnits;
    @SerializedName("memberedOrganizationUnits")
    public List<String> memberedOrganizationUnits;

    public String getProfilePictureId() {
        return profilePictureId;
    }

    public void setProfilePictureId(String profilePictureId) {
        this.profilePictureId = profilePictureId;
    }

    public UserFullDetails getUser() {
        return user;
    }

    public void setUser(UserFullDetails user) {
        this.user = user;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<AllOrganizationUnit> getAllOrganizationUnits() {
        return allOrganizationUnits;
    }

    public void setAllOrganizationUnits(List<AllOrganizationUnit> allOrganizationUnits) {
        this.allOrganizationUnits = allOrganizationUnits;
    }

    public List<String> getMemberedOrganizationUnits() {
        return memberedOrganizationUnits;
    }

    public void setMemberedOrganizationUnits(List<String> memberedOrganizationUnits) {
        this.memberedOrganizationUnits = memberedOrganizationUnits;
    }
}
