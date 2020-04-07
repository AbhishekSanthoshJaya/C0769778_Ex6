package com.aby.c0769778_ex6.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.aby.c0769778_ex6.R;

public class AttractionListActivity extends AppCompatActivity {
private RecyclerView rvAttractions;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvAttractions = findViewById(R.id.rvAttractions);

    }
}
