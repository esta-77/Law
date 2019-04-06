package com.example.franko.law;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CourtDetails extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_court_details);


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Court Details");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        textView = findViewById(R.id.court_details_text);
        imageView = findViewById(R.id.court_details_image);


        // intent data

        Intent intentData = getIntent();
        String imageUrl = intentData.getStringExtra("MODEL_IMAGE_URL");
        String id = intentData.getStringExtra("MODEL_ID");
        String name = intentData.getStringExtra("MODEL_NAME");
        String description = intentData.getStringExtra("MODEL_DESCRIPTION");

        System.out.println("intent name is "+name+" imageUrl is "+imageUrl);


        Glide.with(this).load(imageUrl).into(imageView);
        textView.setText(description);
    }
}
