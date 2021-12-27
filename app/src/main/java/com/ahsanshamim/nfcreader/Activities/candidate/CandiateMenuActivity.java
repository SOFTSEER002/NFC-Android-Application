package com.ahsanshamim.nfcreader.Activities.candidate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.ahsanshamim.nfcreader.R;

public class CandiateMenuActivity extends AppCompatActivity {

    private LinearLayout candi_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candiate_menu);
        setXML();
    }
    private  void setXML(){
        candi_list =  findViewById(R.id.candi_list);
        candi_list.setOnClickListener(v->{
            startActivity(new Intent(this,CandidateListActivity.class));
        });
    }
}
