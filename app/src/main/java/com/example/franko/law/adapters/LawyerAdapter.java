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
import com.example.franko.law.Models.LawyerModel;
import com.example.franko.law.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class LawyerAdapter extends RecyclerView.Adapter<LawyerAdapter.LawyerAdapterViewHolder> {
    @NonNull

    Context context;
    ArrayList<LawyerModel> content;
    CustomClickListener listener;

    public void setOnClickListener(CustomClickListener listener) {
        this.listener = listener;
    }

    public LawyerAdapter(Context context, ArrayList<LawyerModel> content) {
        this.context = context;
        this.content = content;
    }

    @Override
    public LawyerAdapter.LawyerAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LawyerAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.lawyers_custom_row,parent,false));

    }



    @Override
    public void onBindViewHolder(@NonNull LawyerAdapter.LawyerAdapterViewHolder holder, final int position) {

        LawyerModel model = content.get(position);
        holder.name.setText(model.getName());
        Glide.with(context).load(model.getImage_url()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return content.size();
    }


    public class LawyerAdapterViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private CircleImageView image;

        public LawyerAdapterViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.placeholder);
            name = itemView.findViewById(R.id.group_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(getAdapterPosition());
                }
            });
        }
    }
 }
