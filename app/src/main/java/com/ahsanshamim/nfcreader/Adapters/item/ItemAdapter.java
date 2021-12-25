package com.ahsanshamim.nfcreader.Adapters.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahsanshamim.nfcreader.Models.items.Item;
import com.ahsanshamim.nfcreader.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private Context context;
    List<Item> itemList;

    public ItemAdapter(Context context, List<Item> itemList){
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

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
