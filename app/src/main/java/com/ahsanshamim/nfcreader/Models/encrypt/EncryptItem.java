package com.ahsanshamim.nfcreader.Models.encrypt;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EncryptItem {


    @SerializedName("accessToken")
    public List<Object> item;
    @SerializedName("keyName")
    public String keyName;
    @SerializedName("keyValue")
    public String keyValue;
    @SerializedName("autoChangeValue")
    public boolean autoChangeValue;
    @SerializedName("schedule")
    public String schedule;
    @SerializedName("isActive")
    public boolean isActive;
    @SerializedName("tenantId")
    public int tenantId;
    @SerializedName("candidate")
    public List<Object> candidate;
    @SerializedName("organizationUnitId")
    public int organizationUnitId;
    @SerializedName("isDeleted")
    public boolean isDeleted;
    @SerializedName("deleterUserId")
    public String deleterUserId;
    @SerializedName("deletionTime")
    public String deletionTime;
    @SerializedName("lastModificationTime")
    public String lastModificationTime;
    @SerializedName("lastModifierUserId")
    public String lastModifierUserId;
    @SerializedName("creationTime")
    public String creationTime;
    @SerializedName("creatorUserId")
    public int creatorUserId;
    @SerializedName("id")
    public int id;


    public List<Object> getItem() {
        return item;
    }

    public void setItem(List<Object> item) {
        this.item = item;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public boolean isAutoChangeValue() {
        return autoChangeValue;
    }

    public void setAutoChangeValue(boolean autoChangeValue) {
        this.autoChangeValue = autoChangeValue;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public List<Object> getCandidate() {
        return candidate;
    }

    public void setCandidate(List<Object> candidate) {
        this.candidate = candidate;
    }

    public int getOrganizationUnitId() {
        return organizationUnitId;
    }

    public void setOrganizationUnitId(int organizationUnitId) {
        this.organizationUnitId = organizationUnitId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getDeleterUserId() {
        return deleterUserId;
    }

    public void setDeleterUserId(String deleterUserId) {
        this.deleterUserId = deleterUserId;
    }

    public String getDeletionTime() {
        return deletionTime;
    }

    public void setDeletionTime(String deletionTime) {
        this.deletionTime = deletionTime;
    }

    public String getLastModificationTime() {
        return lastModificationTime;
    }

    public void setLastModificationTime(String lastModificationTime) {
        this.lastModificationTime = lastModificationTime;
    }

    public String getLastModifierUserId() {
        return lastModifierUserId;
    }

    public void setLastModifierUserId(String lastModifierUserId) {
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
