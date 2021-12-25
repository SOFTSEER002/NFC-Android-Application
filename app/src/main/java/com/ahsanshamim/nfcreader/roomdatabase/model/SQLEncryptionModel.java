package com.ahsanshamim.nfcreader.roomdatabase.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class SQLEncryptionModel  implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "keyName")
    public String keyName;
    @ColumnInfo(name = "keyValue")
    public String keyValue;
    @ColumnInfo(name = "autoChangeValue")
    public String autoChangeValue;
    @ColumnInfo(name = "schedule")
    public String schedule;
    @ColumnInfo(name = "isActive")
    public String isActive;
    @ColumnInfo(name = "tenantId")
    public int tenantId;
    @ColumnInfo(name = "organizationUnitId")
    public int organizationUnitId;
    @ColumnInfo(name = "isDeleted")
    public boolean isDeleted;
    @ColumnInfo(name = "deleterUserId")
    public String deleterUserId;
    @ColumnInfo(name = "deletionTime")
    public String deletionTime;
    @ColumnInfo(name = "lastModificationTime")
    public String lastModificationTime;
    @ColumnInfo(name = "lastModifierUserId")
    public String lastModifierUserId;
    @ColumnInfo(name = "creationTime")
    public String creationTime;
    @ColumnInfo(name = "creatorUserId")
    public int creatorUserId;
    @ColumnInfo(name = "encryption_id")
    public int encryption_id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAutoChangeValue() {
        return autoChangeValue;
    }

    public void setAutoChangeValue(String autoChangeValue) {
        this.autoChangeValue = autoChangeValue;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
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

    public int getEncryption_id() {
        return encryption_id;
    }

    public void setEncryption_id(int encryption_id) {
        this.encryption_id = encryption_id;
    }
}
