package com.ahsanshamim.nfcreader.listener.item;

import com.ahsanshamim.nfcreader.Models.items.ItemResponse;

public interface ItemListener {

    public void onSuccessItem(ItemResponse itemResponse);
    public  void onFailureItem(String message);
}
