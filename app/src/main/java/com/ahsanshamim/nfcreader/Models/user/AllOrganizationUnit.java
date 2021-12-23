package com.ahsanshamim.nfcreader.Models.user;

import com.google.gson.annotations.SerializedName;

public class AllOrganizationUnit {
    @SerializedName("parentId")
    public int parentId;
    @SerializedName("code")
    public String code;
    @SerializedName("displayName")
    public String displayName;
    @SerializedName("memberCount")
    public int memberCount;
    @SerializedName("roleCount")
    public int roleCount;
    @SerializedName("lastModificationTime")
    public String lastModificationTime;
    @SerializedName("lastModifierUserId")
    public int lastModifierUserId;
    @SerializedName("creationTime")
    public String creationTime;
    @SerializedName("creatorUserId")
    public int creatorUserId;
    @SerializedName("id")
    public int id;

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public int getRoleCount() {
        return roleCount;
    }

    public void setRoleCount(int roleCount) {
        this.roleCount = roleCount;
    }

    public String getLastModificationTime() {
        return lastModificationTime;
    }

    public void setLastModificationTime(String lastModificationTime) {
        this.lastModificationTime = lastModificationTime;
    }

    public int getLastModifierUserId() {
        return lastModifierUserId;
    }

    public void setLastModifierUserId(int lastModifierUserId) {
        this.lastModifierUserId = lastModifierUserId;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public int getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(int creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
