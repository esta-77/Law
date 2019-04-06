package com.example.franko.law.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.franko.law.CustomClickListener;
import com.example.franko.law.Models.CourtModel;
import com.example.franko.law.R;

import java.util.ArrayList;

public class CourtsAdapter extends RecyclerView.Adapter<CourtsAdapter.CourtsAdapterViewHolder> {
    @NonNull

    Context context;
    ArrayList<CourtModel> list = new ArrayList<>();
    CustomClickListener listener;


    public void setOnClickListener(CustomClickListener listener) {
        this.listener = listener;
    }



    public CourtsAdapter(@NonNull Context context, ArrayList<CourtModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public CourtsAdapter.CourtsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        return new CourtsAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.court_custom_row,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull CourtsAdapter.CourtsAdapterViewHolder holder, final int position) {

        CourtModel model = list.get(position);

        holder.heading.setText(model.getName());

        Glide.with(context).load(model.getImageUrl()).into(holder.imageView);



        holder.holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (listener != null) {
                    listener.onClick(position);
                }

            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class CourtsAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView heading,description;
        ImageView imageView;
        CardView holder;

        public CourtsAdapterViewHolder(View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.court_custom_row_name);
            imageView = itemView.findViewById(R.id.court_custom_row_image);
            holder = itemView.findViewById(R.id.court_custom_row_holder);
//            description = itemView.findViewById(R.id.court_custom_description);
        }
    }
}
