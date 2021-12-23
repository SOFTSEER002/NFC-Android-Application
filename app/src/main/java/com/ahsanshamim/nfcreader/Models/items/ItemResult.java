package com.ahsanshamim.nfcreader.Models.items;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemResult {
    @SerializedName("totalCount")
    public int totalCount;
    @SerializedName("items")
    public List<Item> items;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
