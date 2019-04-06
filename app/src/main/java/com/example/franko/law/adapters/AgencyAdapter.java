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
import com.example.franko.law.Models.AgencyModel;
import com.example.franko.law.R;

import java.util.ArrayList;

//
public class AgencyAdapter extends RecyclerView.Adapter<AgencyAdapter.AgencyAdapterViewHolder> {
    @NonNull
    Context context;
    ArrayList<AgencyModel> values;
    CustomClickListener listener;


    public AgencyAdapter(Context context,ArrayList<AgencyModel> values){
        this.context = context;
        this.values = values;
    }


    @Override


    public AgencyAdapter.AgencyAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AgencyAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.agency_custom_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AgencyAdapterViewHolder holder, final int position) {
        AgencyModel model = values.get(position);

        holder.name.setText(model.getName());

        Glide.with(context).load(model.getImageUrl()).into(holder.image_url);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public void setOnClickListener(CustomClickListener listener) { this.listener = listener;
    }


    public class AgencyAdapterViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView image_url;
        CardView container;

        public AgencyAdapterViewHolder(View itemView ){
            super(itemView);
            name = itemView.findViewById(R.id.agency_custom_row_name);
            image_url= itemView.findViewById(R.id.agency_custom_row_image);
            container = itemView.findViewById(R.id.agency_custom_row_container);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(getAdapterPosition());
                }
            });

        }
    }
}
