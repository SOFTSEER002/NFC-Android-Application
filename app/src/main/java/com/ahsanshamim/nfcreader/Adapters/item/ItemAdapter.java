package com.ahsanshamim.nfcreader.Adapters.item;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahsanshamim.nfcreader.Activities.item.ItemListActivity;
import com.ahsanshamim.nfcreader.Models.items.Item;
import com.ahsanshamim.nfcreader.R;
import com.ahsanshamim.nfcreader.roomdatabase.init.DatabaseClient;
import com.ahsanshamim.nfcreader.roomdatabase.model.SQLEncryptionModel;
import com.ahsanshamim.nfcreader.utils.SimpleCrypto;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private Context context;
    List<Item> itemList;

    public ItemAdapter(Activity context, List<Item> itemList){
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(
            LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = itemList.get(position);
        Thread t =  new Thread(() -> {
           SQLEncryptionModel sqlEncryptionModel =  DatabaseClient.getInstance(context).getAppDatabase()
                .taskDao()
                .findEncr(item.getEncryptionKeyId());
            Logger.w("DECRYPT:  "+new Gson().toJson(sqlEncryptionModel));
            try {
                String data = SimpleCrypto.decrypt(sqlEncryptionModel.keyValue.getBytes(),item.getItemName());
                String detailsdata = SimpleCrypto.decrypt(sqlEncryptionModel.keyValue.getBytes(),item.getDetails());
                ((ItemListActivity)context).runOnUiThread(()->{
                    holder.item_name.setText(data);
                    holder.details.setText(detailsdata);
                    Logger.w("DECRYPT:  "+data);
                    Logger.w("DECRYPT:  "+detailsdata);
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            // String data =decryptMsg(Base64.encodeToString(Base64.decode(, Base64.DEFAULT), Base64.DEFAULT).getBytes(), generateKey("3232575943671488"));
            //String data = decrypt("vb67+UWjMUyOurITxmYhHg==","3232575943671488");
        });
        t.start();
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        public TextView item_name,details;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            details = itemView.findViewById(R.id.details);
        }
    }

}
