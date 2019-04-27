package com.example.franko.law;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.franko.law.Models.LawyerModel;
import com.example.franko.law.adapters.LawyerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class LawyerCategory extends AppCompatActivity {

    private LawyerAdapter adapter;
    private ArrayList<LawyerModel> lawyers = new ArrayList<>();
    private DatabaseReference reference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawyer_details);

        initView();
        populateList();

    }

    @SuppressLint("RestrictedApi")
    private void initView() {

        reference = FirebaseDatabase.getInstance().getReference("lawyers");

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Lawyers");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.lawyers_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new LawyerAdapter(this, lawyers);
        recyclerView.setAdapter(adapter);

        adapter.setOnClickListener(new CustomClickListener() {
            @Override
            public void onClick(int position) {
                LawyerModel item = lawyers.get(position);
                Bundle bundle = new Bundle();
                bundle.putString("name", item.getName());
                bundle.putString("image", item.getImage_url());
                bundle.putString("desc", item.getDescription());
                bundle.putString("cases_won", item.getNumber_of_cases_won());
                bundle.putString("cases_lost", item.getNumber_of_cases_lost());
                bundle.putString("cases", item.getNumber_of_cases_witness());
                bundle.putString("workplace", item.getPlace_of_work());
                bundle.putString("id", item.getId());
                bundle.putString("contact",item.getContact());

                Intent intent = new Intent(LawyerCategory.this, LawyerProfileActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LawyerCategory.this, BotActivity.class));
            }
        });

    }

    private void populateList() {
        final String key = getIntent().getStringExtra("MODEL_ID");
        System.out.println("key "+key);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                lawyers.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    HashMap<String, Object> item = (HashMap<String, Object>) snapshot.getValue();
                    if(key.equals(String.valueOf(item.get("lawyer_group_id")))) {
                        lawyers.add(new LawyerModel(String.valueOf(item.get("lawyer_group_id")), String.valueOf(item.get("contact")), String.valueOf(item.get("imageUrl")), String.valueOf(item.get("workplace")), String.valueOf(item.get("name")), String.valueOf(item.get("cases_won")), String.valueOf(item.get("cases_lost")), String.valueOf(item.get("cases_number")),String.valueOf(item.get("description"))));
                        adapter.notifyDataSetChanged();
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }


}
