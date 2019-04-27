package com.example.franko.law;

import android.net.Uri;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.bumptech.glide.Glide;
import com.example.franko.law.Models.Videos;
import com.google.gson.Gson;

import hb.xvideoplayer.MxVideoPlayer;
import hb.xvideoplayer.MxVideoPlayerWidget;


public class VideoActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        String videoGson = getIntent().getStringExtra("INTENT_VIDEO_GSON");
        Videos video = new Gson().fromJson(videoGson,Videos.class);

        SwipeRefreshLayout refreshLayout = findViewById(R.id.refresh);
        refreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));

        WebView webView = findViewById(R.id.web_view);
        webView.setWebViewClient(new WebClient(refreshLayout));
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
       // webView.loadUrl("https://firebasestorage.googleapis.com/v0/b/lawapp-246ec.appspot.com/o/VID-20190130-WA0003.mp4?alt=media&token=18f7689f-efe7-4c36-a769-a22f0fe6373e");
        webView.loadUrl(video.getUrl());

        System.out.println(video.getUrl());

//        System.out.print("video is "+video.getUrl());
//        MxVideoPlayerWidget videoPlayerWidget =  findViewById(R.id.mpw_video_player);
//        //Uri uri = "https://www.firebasestorage.googleapis.com/v0/b/lawapp-246ec.appspot.com/o/VID-20190130-WA0003.mp4?alt=media&token=18f7689f-efe7-4c36-a769-a22f0fe6373e");
//        videoPlayerWidget.startPlay("https://firebasestorage.googleapis.com/v0/b/lawapp-246ec.appspot.com/o/VID-20190130-WA0003.mp4?alt=media", MxVideoPlayer.SCREEN_LAYOUT_NORMAL, "video name");



    }



    @Override
    protected void onPause() {
        super.onPause();
        MxVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onBackPressed() {
        if (MxVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }





}
