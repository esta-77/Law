package com.example.franko.law.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.franko.law.CustomClickListener;
import com.example.franko.law.Models.LawyerGroupModel;
import com.example.franko.law.R;

import java.util.List;

public class LawyerGroupAdapter extends RecyclerView.Adapter<LawyerGroupAdapter.LawyerGroupViewHolder> {


    private List<LawyerGroupModel> groups;
    private Context context;
    private CustomClickListener listener;

    public LawyerGroupAdapter(List<LawyerGroupModel> groups, Context context) {
        this.groups = groups;
        this.context = context;
    }

    public void setCustomClickListener(CustomClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public LawyerGroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LawyerGroupViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_lawyer_group_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LawyerGroupViewHolder holder, int position) {
        LawyerGroupModel model = groups.get(position);
        holder.group.setText(model.getName());
    }

    @Override
    public int getItemCount() {
        return groups.size();
    }

    public class LawyerGroupViewHolder extends RecyclerView.ViewHolder {

        private TextView group;

        public LawyerGroupViewHolder(View itemView) {
            super(itemView);
            group = itemView.findViewById(R.id.group_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(getAdapterPosition());
                }
            });
        }
    }
}
