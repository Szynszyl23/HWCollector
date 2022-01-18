package com.example.hwcollector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
    }

    //This part allows to run AddInformation activity after button press
    public void onClick(View view) {
        Intent intent = new Intent(ListView.this, AddInformation.class);
        startActivity(intent);
        finish();
    }
}