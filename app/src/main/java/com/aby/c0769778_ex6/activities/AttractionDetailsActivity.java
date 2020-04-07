package com.aby.c0769778_ex6.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.aby.c0769778_ex6.R;
import com.aby.c0769778_ex6.adapters.AttractionsAdapter;
import com.aby.c0769778_ex6.model.CanadaAttractions;

public class AttractionDetailsActivity extends AppCompatActivity {

    CanadaAttractions att;
    private TextView txtName;
    private TextView txtCity;
    private TextView txtAddress;
    private TextView txtProvince;
    private TextView txtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_details);

        txtName = findViewById(R.id.txtName);
        txtCity = findViewById(R.id.txtCity);
        txtAddress = findViewById(R.id.txtAddress);
        txtProvince = findViewById(R.id.txtProvince);
        txtDescription = findViewById(R.id.txtDescription);

        if (getIntent().getExtras() != null) {
            att = (CanadaAttractions) getIntent().getExtras().getSerializable("attractionsKey");
            txtName.setText(att.getName());

        }
    }
}
