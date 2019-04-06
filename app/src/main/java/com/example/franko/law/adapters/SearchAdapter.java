package com.example.franko.law.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.franko.law.Models.Search;
import com.example.franko.law.R;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    Context context;
    ArrayList<Search> lawlist = new ArrayList<>();
    OnItemClickListener mListener;

    public SearchAdapter(Context context,ArrayList<Search> laws_searched) {
        this.context = context;
        lawlist = laws_searched;
    }


    public interface OnItemClickListener{
        void OnItemClick(int position);

    }

    public  void setItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class SearchViewHolder extends RecyclerView.ViewHolder{
        TextView laws_searched,description,keyword;
        LinearLayout laws_container;

        public SearchViewHolder(View itemView) {
            super(itemView);

            laws_searched = itemView.findViewById(R.id.law_title);
            description = itemView.findViewById(R.id.description);
            keyword = itemView.findViewById(R.id.keyword);
            laws_container = itemView.findViewById(R.id.laws_container);

        }
    }


    @NonNull
    @Override
    public SearchAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row_search,parent,false);
        SearchViewHolder rootview = new SearchViewHolder(view);
        return rootview;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.SearchViewHolder holder, final int position) {
         Search law = lawlist.get(position);
         holder.laws_searched.setText(law.getTitle());
         holder.description.setText(law.getDescription());
//         holder.keyword.setText(law.getKeyword());

        holder.laws_container.setOnClickListener(new View.OnClickListener() {
            @Override
            //display data in searchdetails
            public void onClick(View view) {

                if (mListener != null) {
                    mListener.OnItemClick(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return lawlist.size();
    }
}
