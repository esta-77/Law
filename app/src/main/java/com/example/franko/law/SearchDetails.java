package com.example.franko.law;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SearchDetails extends AppCompatActivity {
    TextView textView;
    TextView textView2;
    TextView textView3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_details);

        textView = findViewById(R.id.search_details_title);
        textView2 = findViewById(R.id.law_details_text);
        textView3 = findViewById(R.id.law_action);

        //intent data
        Intent intentData = getIntent();
        String id = intentData.getStringExtra("MODEL_ID");
        textView.setText(intentData.getStringExtra("MODEL_TITLE"));
        textView2.setText(intentData.getStringExtra("MODEL_DESCRIPTION"));
        textView3.setText(intentData.getStringExtra("MODEL_ACTION"));


    }
}
