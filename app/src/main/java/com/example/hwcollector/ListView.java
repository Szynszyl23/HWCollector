package com.example.hwcollector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.List;

public class ListView extends AppCompatActivity {

    android.widget.ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = findViewById(R.id.listShow);
        HWDatabaseHelper databaseHelper = new HWDatabaseHelper(ListView.this);
        List<DataModel> allRecords = databaseHelper.getAllRecords();
        ArrayAdapter modelArrayAdapter = new ArrayAdapter<>(ListView.this, android.R.layout.simple_list_item_1, allRecords);
        listView.setAdapter(modelArrayAdapter);
    }

    //This part allows to run AddInformation activity after button press
    public void onClick(View view) {
        Intent intent = new Intent(ListView.this, AddInformation.class);
        startActivity(intent);
        finish();
    }
}