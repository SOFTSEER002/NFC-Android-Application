package com.ahsanshamim.nfcreader.Activities.item;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ahsanshamim.nfcreader.R;

public class ItemMenusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_menus);
    }
    public void openItemActivity(View view){
        startActivity(new Intent(getApplicationContext(), ItemListActivity.class));
    }
}
