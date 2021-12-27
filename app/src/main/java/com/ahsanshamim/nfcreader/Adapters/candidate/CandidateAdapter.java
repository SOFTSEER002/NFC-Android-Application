package com.ahsanshamim.nfcreader.Adapters.candidate;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahsanshamim.nfcreader.Activities.item.ItemListActivity;
import com.ahsanshamim.nfcreader.Models.candidate.CandidateItems;
import com.ahsanshamim.nfcreader.R;
import com.ahsanshamim.nfcreader.roomdatabase.init.DatabaseClient;
import com.ahsanshamim.nfcreader.roomdatabase.model.SQLEncryptionModel;
import com.ahsanshamim.nfcreader.utils.SimpleCrypto;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import java.util.List;

public class CandidateAdapter extends RecyclerView.Adapter<CandidateAdapter.CandidateViewHolder> {


    private List<CandidateItems> candidateItemsList;
    private Context context;

    public CandidateAdapter(List<CandidateItems> candidateItemsList, Context context) {
        this.candidateItemsList = candidateItemsList;
        this.context = context;
    }

    @NonNull
    @Override
    public CandidateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CandidateViewHolder(
            LayoutInflater.from(parent.getContext()).inflate(R.layout.candidate_list,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull CandidateViewHolder holder, int position) {
        CandidateItems candidateItems = candidateItemsList.get(position);
        Thread t =  new Thread(() -> {
            SQLEncryptionModel sqlEncryptionModel =  DatabaseClient.getInstance(context).getAppDatabase()
                .taskDao()
                .findEncr(candidateItems.getEncryptionKeyId());
            Logger.w("DECRYPT:  "+new Gson().toJson(sqlEncryptionModel));
            try {
                String fname = SimpleCrypto.decrypt(sqlEncryptionModel.keyValue.getBytes(),candidateItems.getCandidateFirstName());
                String lname = SimpleCrypto.decrypt(sqlEncryptionModel.keyValue.getBytes(),candidateItems.getCandidateLastName());
                String photo = SimpleCrypto.decrypt(sqlEncryptionModel.keyValue.getBytes(),candidateItems.getPhoto());
                ((ItemListActivity)context).runOnUiThread(()->{
                    holder.candi_name.setText(fname +" "+lname);
                    Glide
                        .with(context)
                        .load(photo)
                        .centerCrop()
                        .placeholder(R.drawable.loading)
                        .into(holder.profile);

                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            // String data =decryptMsg(Base64.encodeToString(Base64.decode(, Base64.DEFAULT), Base64.DEFAULT).getBytes(), generateKey("3232575943671488"));
            //String data = decrypt("vb67+UWjMUyOurITxmYhHg==","3232575943671488");
        });
        t.start();



        if(candidateItems.isInterviewed()){
            holder.iterview_layout.setVisibility(View.VISIBLE);
        }else{
            holder.iterview_layout.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return candidateItemsList.size();
    }


    public class CandidateViewHolder extends RecyclerView.ViewHolder {


        public TextView interviewText,candi_name;
        public LinearLayout iterview_layout;
        public ImageView profile;

        public CandidateViewHolder(@NonNull View itemView) {
            super(itemView);
            interviewText = itemView.findViewById(R.id.iterview);
            candi_name = itemView.findViewById(R.id.candi_name);
            profile = itemView.findViewById(R.id.profile);
            iterview_layout = itemView.findViewById(R.id.iterview_layout);
        }
    }
}
