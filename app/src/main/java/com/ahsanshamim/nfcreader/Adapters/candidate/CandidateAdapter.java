package com.ahsanshamim.nfcreader.Adapters.candidate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahsanshamim.nfcreader.Models.candidate.CandidateItems;
import com.ahsanshamim.nfcreader.R;

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

    }

    @Override
    public int getItemCount() {
        return candidateItemsList.size();
    }


    public class CandidateViewHolder extends RecyclerView.ViewHolder {


        private TextView interviewText;
        private LinearLayout iterview_layout;

        public CandidateViewHolder(@NonNull View itemView) {
            super(itemView);
            interviewText = itemView.findViewById(R.id.iterview);
            iterview_layout = itemView.findViewById(R.id.iterview_layout);
        }
    }
}
