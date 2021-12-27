package com.ahsanshamim.nfcreader.Models.candidate;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CandidateResult {

    @SerializedName("totalCount")
    public int totalCount;
    @SerializedName("items")
    public List<CandidateItems> items;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<CandidateItems> getItems() {
        return items;
    }

    public void setItems(List<CandidateItems> items) {
        this.items = items;
    }
}
