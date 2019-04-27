package com.example.franko.law;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.franko.law.Models.Search;
import com.example.franko.law.adapters.SearchAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ArrayList<Search> list = new ArrayList<>();
    private SearchAdapter adapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);


        String searchGson = getIntent().getStringExtra("SEARCH_INTENT_GSON");

        list = new Gson().fromJson(searchGson,new TypeToken<ArrayList<Search>>(){}.getType());


        toolbar = findViewById(R.id.search_toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        recyclerView = findViewById(R.id.search_recyclerview);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter = new SearchAdapter(this,list);
        adapter.setItemClickListener(clickListener);
        recyclerView.setAdapter(adapter);

        populateList();


    }

    SearchAdapter.OnItemClickListener clickListener = new SearchAdapter.OnItemClickListener() {
        @Override
        public void OnItemClick(int position) {

            Search search = list.get(position);

           // Toast.makeText(SearchActivity.this,"Am tapped on position :"+position,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SearchActivity.this,SearchDetails.class);
            intent.putExtra("MODEL_ID","1");
            intent.putExtra("MODEL_TITLE",search.getTitle());
            intent.putExtra("MODEL_DESCRIPTION",search.getDescription());
           intent.putExtra("MODEL_ACTION",search.getAction());
            startActivity(intent);

        }
    };

    private void populateList() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onNavigateUp() {
        onBackPressed();
        return true;
    }
}
