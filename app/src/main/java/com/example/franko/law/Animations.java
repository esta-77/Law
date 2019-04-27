package com.example.franko.law;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.franko.law.Models.Videos;
import com.example.franko.law.adapters.VideosAdapter;
import com.google.gson.Gson;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class Animations extends android.support.v4.app.Fragment {
    CarouselView carouselView;
    RecyclerView recyclerView;
    private ArrayList<Videos> list = new ArrayList<>();
    private VideosAdapter adapter;

    int[] setImages ={R.drawable.childlabour,R.drawable.childlabour3,R.drawable.labour_rights,R.drawable.spouse_abuse};
    public static Animations newInstance(){
        Animations animie = new Animations();
        return animie;
    }
    public Animations(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.animations,container,false);


        carouselView = (CarouselView) rootView.findViewById(R.id.carouselView);
        carouselView.setPageCount(setImages.length);

        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(setImages[position]);
            }
        });
        adapter = new VideosAdapter(rootView.getContext(),list);
        adapter.setOnClickListener(clickListener);
        recyclerView = rootView.findViewById(R.id.animation_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
        populateList();
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(getString(R.string.animation));
    }

    private void populateList() {
        list.add(new Videos("https://firebasestorage.googleapis.com/v0/b/lawapp-246ec.appspot.com/o/VID-20190130-WA0003.mp4?alt=media&token=18f7689f-efe7-4c36-a769-a22f0fe6373e","","Rubber dump correction",""));
        list.add(new Videos("https://firebasestorage.googleapis.com/v0/b/lawapp-246ec.appspot.com/o/esther.wmv?alt=media&token=0ce56c52-2690-4e78-8761-1b59b180bed2", "", "Intestate Law", ""));
        adapter.notifyDataSetChanged();
    }


    CustomClickListener clickListener = new CustomClickListener() {
        @Override
        public void onClick(int position) {

            Videos videos = list.get(position);
            String gson = new Gson().toJson(videos);
            Intent intent = new Intent(getContext(),VideoActivity.class);
            intent.putExtra("INTENT_VIDEO_GSON",gson);
            startActivity(intent);

        }
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
