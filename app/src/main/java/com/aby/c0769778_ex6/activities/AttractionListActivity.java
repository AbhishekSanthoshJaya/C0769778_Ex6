package com.aby.c0769778_ex6.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.aby.c0769778_ex6.R;
import com.aby.c0769778_ex6.adapters.AttractionsAdapter;
import com.aby.c0769778_ex6.model.CanadaAttractions;

import java.util.ArrayList;

public class AttractionListActivity extends AppCompatActivity {
    private RecyclerView rvAttractions;
    private ArrayList<CanadaAttractions> attractions;
    private AttractionsAdapter attractionsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvAttractions = findViewById(R.id.rvAttractions);

        loadAttractions();
        attractionsAdapter = new AttractionsAdapter(attractions);
        RecyclerView.LayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvAttractions.setLayoutManager(mLinearLayoutManager);
        rvAttractions.setAdapter(attractionsAdapter);

    }

    private void loadAttractions()
    {
        attractions = new ArrayList<>();
        attractions.add(new CanadaAttractions("1","Jasper Park","Canadian Rockies","Alberta","Alberta",
                "One of Canada's wildest places, Jasper National Park provides kaleidoscopic panoramas at every turn. " +
                        "Travelers can marvel at many views as they trek from the peaks of Mount Edith Cavell to the caverns of Maligne Canyon. " +
                        "Located on the eastern edge of Alberta, the park serves as a beacon for adventurers in the Northern Hemisphere. " +
                        "Jasper boasts the distinction of being the largest park in the Canadian Rockies and was designated part of a UNESCO World Heritage Site, along with Banff and a handful of additional parks. " +
                        "With more than 2.7 million acres of land to explore, travelers are sure to spot animals ranging from caribou to wolverine to moose."
                        ,R.drawable.jasper_park));
    }
}
