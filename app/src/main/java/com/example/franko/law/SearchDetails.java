package com.example.franko.law;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SearchDetails extends AppCompatActivity {
    TextView title,description,keywords;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_details);

        title = findViewById(R.id.law_title);
        description = findViewById(R.id.law_details_text);
        keywords = findViewById(R.id.law_keywords);

        //intent data
        Intent intentData = getIntent();
        String id = intentData.getStringExtra("MODEL ID");
        String title = intentData.getStringExtra("MODEL TITLE");
        String description = intentData.getStringExtra("MODEL DESCRIPTION");
        String keywords = intentData.getStringExtra("MODEL KEYWORDS");
    }
}
