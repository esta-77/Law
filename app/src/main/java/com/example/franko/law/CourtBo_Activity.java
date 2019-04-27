package com.example.franko.law;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
//import android.widget.Toolbar;

public class CourtBo_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot);
        

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("CourtBot");

        setSupportActionBar(toolbar);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        SwipeRefreshLayout refreshLayout = findViewById(R.id.refresh);
        refreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));

        WebView webView = findViewById(R.id.web_view);
        webView.setWebViewClient(new WebClient(refreshLayout));
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://assistant-chat-eu-gb.watsonplatform.net/web/public/22c8caba-0e56-4c50-b4d4-18c2b0ce2d00");

    }

    }

