package com.ahsanshamim.nfcreader.Models.items;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Item {
    @SerializedName("itemName")
    public String itemName;
    @SerializedName("sku")
    public String sku;
    @SerializedName("varriationBatch")
    public List<Object> varriationBatch;
    @SerializedName("code")
    public String code;
    @SerializedName("categoryId")
    public int categoryId;
    @SerializedName("details")
    public String details;
    @SerializedName("rackCompartmentId")
    public int rackCompartmentId;
    @SerializedName("trackWeight")
    public boolean trackWeight;
    @SerializedName("encryptionKeyId")
    public int encryptionKeyId;
    @SerializedName("itemSupplierId")
    public int itemSupplierId;
    @SerializedName("manufacturerId")
    public int manufacturerId;
    @SerializedName("trackQty")
    public boolean trackQty;
    @SerializedName("lowStockAlert")
    public boolean lowStockAlert;
    @SerializedName("printValueGenerators")
    public List<Object> printValueGenerators;
    @SerializedName("lowStockValue")
    public boolean lowStockValue;
    @SerializedName("authenticateItem")
    public boolean authenticateItem;
    @SerializedName("barcode")
    public String barcode;
    @SerializedName("nfc")
    public String nfc;
    @SerializedName("rfid")
    public String rfid;
    @SerializedName("qrc")
    public String qrc;
    @SerializedName("printItem")
    public boolean printItem;
    @SerializedName("printVarriant")
    public boolean printVarriant;
    @SerializedName("printRack")
    public boolean printRack;
    @SerializedName("printQty")
    public boolean printQty;
    @SerializedName("manufactureDate")
    public String manufactureDate;
    @SerializedName("expiryDate")
    public String expiryDate;
    @SerializedName("expNotify")
    public boolean expNotify;
    @SerializedName("notifyBfor")
    public int notifyBfor;
    @SerializedName("tenantId")
    public int tenantId;
    @SerializedName("isDeleted")
    public boolean isDeleted;
    @SerializedName("deleterUserId")
    public Object deleterUserId;
    @SerializedName("deletionTime")
    public Object deletionTime;
    @SerializedName("lastModificationTime")
    public Object lastModificationTime;
    @SerializedName("lastModifierUserId")
    public Object lastModifierUserId;
    @SerializedName("creationTime")
    public String creationTime;
    @SerializedName("creatorUserId")
    public Object creatorUserId;
    @SerializedName("id")
    public int id;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public List<Object> getVarriationBatch() {
        return varriationBatch;
    }

    public void setVarriationBatch(List<Object> varriationBatch) {
        this.varriationBatch = varriationBatch;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getRackCompartmentId() {
        return rackCompartmentId;
    }

    public void setRackCompartmentId(int rackCompartmentId) {
        this.rackCompartmentId = rackCompartmentId;
    }

    public boolean isTrackWeight() {
        return trackWeight;
    }

    public void setTrackWeight(boolean trackWeight) {
        this.trackWeight = trackWeight;
    }

    public int getEncryptionKeyId() {
        return encryptionKeyId;
    }

    public void setEncryptionKeyId(int encryptionKeyId) {
        this.encryptionKeyId = encryptionKeyId;
    }

    public int getItemSupplierId() {
        return itemSupplierId;
    }

    public void setItemSupplierId(int itemSupplierId) {
        this.itemSupplierId = itemSupplierId;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public boolean isTrackQty() {
        return trackQty;
    }

    public void setTrackQty(boolean trackQty) {
        this.trackQty = trackQty;
    }

    public boolean isLowStockAlert() {
        return lowStockAlert;
    }

    public void setLowStockAlert(boolean lowStockAlert) {
        this.lowStockAlert = lowStockAlert;
    }

    public List<Object> getPrintValueGenerators() {
        return printValueGenerators;
    }

    public void setPrintValueGenerators(List<Object> printValueGenerators) {
        this.printValueGenerators = printValueGenerators;
    }

    public boolean isLowStockValue() {
        return lowStockValue;
    }

    public void setLowStockValue(boolean lowStockValue) {
        this.lowStockValue = lowStockValue;
    }

    public boolean isAuthenticateItem() {
        return authenticateItem;
    }

    public void setAuthenticateItem(boolean authenticateItem) {
        this.authenticateItem = authenticateItem;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getNfc() {
        return nfc;
    }

    public void setNfc(String nfc) {
        this.nfc = nfc;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getQrc() {
        return qrc;
    }

    public void setQrc(String qrc) {
        this.qrc = qrc;
    }

    public boolean isPrintItem() {
        return printItem;
    }

    public void setPrintItem(boolean printItem) {
        this.printItem = printItem;
    }

    public boolean isPrintVarriant() {
        return printVarriant;
    }

    public void setPrintVarriant(boolean printVarriant) {
        this.printVarriant = printVarriant;
    }

    public boolean isPrintRack() {
        return printRack;
    }

    public void setPrintRack(boolean printRack) {
        this.printRack = printRack;
    }

    public boolean isPrintQty() {
        return printQty;
    }

    public void setPrintQty(boolean printQty) {
        this.printQty = printQty;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isExpNotify() {
        return expNotify;
    }

    public void setExpNotify(boolean expNotify) {
        this.expNotify = expNotify;
    }

    public int getNotifyBfor() {
        return notifyBfor;
    }

    public void setNotifyBfor(int notifyBfor) {
        this.notifyBfor = notifyBfor;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Object getDeleterUserId() {
        return deleterUserId;
    }

    public void setDeleterUserId(Object deleterUserId) {
        this.deleterUserId = deleterUserId;
    }

    public Object getDeletionTime() {
        return deletionTime;
    }

    public void setDeletionTime(Object deletionTime) {
        this.deletionTime = deletionTime;
    }

    public Object getLastModificationTime() {
        return lastModificationTime;
    }

    public void setLastModificationTime(Object lastModificationTime) {
        this.lastModificationTime = lastModificationTime;
    }

    public Object getLastModifierUserId() {
        return lastModifierUserId;
    }

    public void setLastModifierUserId(Object lastModifierUserId) {
        this.lastModifierUserId = lastModifierUserId;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public Object getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(Object creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
