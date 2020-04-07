package com.aby.c0769778_ex6.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aby.c0769778_ex6.R;
import com.aby.c0769778_ex6.model.CanadaAttractions;

public class AttractionDetailsActivity extends AppCompatActivity {

    CanadaAttractions att;
    private TextView txtName;
    private TextView txtCity;
    private TextView txtAddress;
    private TextView txtProvince;
    private TextView txtDescription;
    private ImageView imgBtnBack;
    private ImageView imgAttractions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_details);

        getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        imgBtnBack = findViewById(R.id.imgBtnBack);
        txtName = findViewById(R.id.txtName);
        txtCity = findViewById(R.id.txtCity);
        txtAddress = findViewById(R.id.txtAddress);
        txtProvince = findViewById(R.id.txtProvince);
        txtDescription = findViewById(R.id.txtDescription);
        imgAttractions = findViewById(R.id.imgAttraction);

        imgBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        if (getIntent().getExtras() != null) {
            att = (CanadaAttractions) getIntent().getExtras().getSerializable("attractionsKey");
            txtName.setText(att.getName());
            txtCity.setText(att.getCity());
            txtAddress.setText(att.getAddress());
            txtProvince.setText(att.getProvince());
            txtDescription.setText(att.getDescription());
            imgAttractions.setImageResource(att.getAttractionImg());
        }
    }
}
