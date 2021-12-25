package com.ahsanshamim.nfcreader.Activities.item;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.ahsanshamim.nfcreader.Adapters.item.ItemAdapter;
import com.ahsanshamim.nfcreader.Models.auth.LoginData;
import com.ahsanshamim.nfcreader.Models.auth.UserData;
import com.ahsanshamim.nfcreader.Models.items.Item;
import com.ahsanshamim.nfcreader.Models.items.ItemResponse;
import com.ahsanshamim.nfcreader.R;
import com.ahsanshamim.nfcreader.Repository.item.ItemRepository;
import com.ahsanshamim.nfcreader.listener.item.ItemListener;
import com.ahsanshamim.nfcreader.utils.CustomLoader;
import com.ahsanshamim.nfcreader.utils.SharePref;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.shashank.sony.fancytoastlib.FancyToast;

public class ItemListActivity extends AppCompatActivity implements ItemListener, ItemAdapter.ItemClickHandler {

    ItemRepository itemRepository;
    private RecyclerView recycle_list_item;
    CustomLoader customLoader;
    SharePref sharePref;
    ItemAdapter  itemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        setXML();
    }
    private  void setXML(){
        recycle_list_item = findViewById(R.id.recycle_list_item);

        // Set layout type recycleview
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recycle_list_item.setLayoutManager(layoutManager);

        itemRepository = new ItemRepository();
        sharePref = new SharePref(getApplicationContext());
        customLoader = new CustomLoader(ItemListActivity.this);
        itemRepository.itemListener = this;
        // get data from cache
        UserData userData = sharePref.getUserLoginData();
        Logger.v(new Gson().toJson(userData));
        LoginData result = userData.getResult();
        customLoader.showProgressDialog();
        // Hit api for get all item
        itemRepository.getAllItems(result.getToken());

    }

    @Override
    public void onSuccessItem(ItemResponse itemResponse) {
        itemAdapter = new ItemAdapter(ItemListActivity.this,itemResponse.getResult().getItems());
        itemAdapter.itemClickHandler = this;
        recycle_list_item.setAdapter(itemAdapter);
        customLoader.dismiss();
    }

    @Override
    public void onFailureItem(String message) {
        customLoader.dismiss();
        FancyToast.makeText(this,message,FancyToast.LENGTH_LONG,FancyToast.ERROR,false).show();;
    }

    @Override
    public void onClickItem(Item item) {
        startActivity(new Intent(getApplicationContext(),ItemDetailsActivity.class));
    }
}
