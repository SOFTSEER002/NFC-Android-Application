package com.ahsanshamim.nfcreader.Activities.item;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.ahsanshamim.nfcreader.R;

public class ItemMenusActivity extends AppCompatActivity {

    private LinearLayout item_list_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_menus);
        setXML();
    }

    private void setXML(){
        item_list_layout = findViewById(R.id.item_list_layout);
        item_list_layout.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(), ItemListActivity.class));
        });
    }
}
