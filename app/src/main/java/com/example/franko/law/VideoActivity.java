package com.example.franko.law;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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


        System.out.print("video is "+video.getUrl());
        MxVideoPlayerWidget videoPlayerWidget =  findViewById(R.id.mpw_video_player);
        videoPlayerWidget.startPlay("https://firebasestorage.googleapis.com/v0/b/lawapp-246ec.appspot.com/o/VID-20190130-WA0003.mp4?alt=media&token=18f7689f-efe7-4c36-a769-a22f0fe6373e", MxVideoPlayer.SCREEN_LAYOUT_NORMAL, "video name");




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
