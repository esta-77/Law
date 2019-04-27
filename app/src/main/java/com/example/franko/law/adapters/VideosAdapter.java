package com.example.franko.law.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.franko.law.CustomClickListener;
import com.example.franko.law.Models.Videos;
import com.example.franko.law.R;

import java.util.ArrayList;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.VideoViewHolder> {

    Context context;
    ArrayList<Videos> list = new ArrayList<>();
    CustomClickListener clickListener;

    public void setOnClickListener(CustomClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public VideosAdapter(Context context, ArrayList<Videos> list) {
        this.context = context;
        this.list = list;
    }


    public class VideoViewHolder extends RecyclerView.ViewHolder {

        CardView holder;
        TextView title;

        public VideoViewHolder(View itemView) {
            super(itemView);
            holder = itemView.findViewById(R.id.row_videos_holder);
            title = itemView.findViewById(R.id.title);
        }
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row_videos,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, final int position) {

        Videos videos = list.get(position);
        holder.title.setText(videos.getTitle());

        holder.holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickListener != null) {
                    clickListener.onClick(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
