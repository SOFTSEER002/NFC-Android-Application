package com.ahsanshamim.nfcreader.Models.encrypt;

import java.util.List;

public class EncryptResult {
    public int totalCount;
    public List<EncryptItem> items;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<EncryptItem> getItems() {
        return items;
    }

    public void setItems(List<EncryptItem> items) {
        this.items = items;
    }
}
