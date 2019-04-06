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

import com.example.franko.law.Models.CourtModel;
import com.example.franko.law.adapters.CourtsAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Courts extends android.support.v4.app.Fragment {

    private RecyclerView recyclerView;
    private CourtsAdapter adapter;
    private ArrayList<CourtModel> list = new ArrayList<>();

    public static Courts newInstance(){
        return new Courts();
    }
    public Courts(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.courts,container,false);
        setupUIComponent(rootView);
        return rootView;
    }

    private void setupUIComponent(View rootView) {

        adapter = new CourtsAdapter(rootView.getContext(),list);
        recyclerView = rootView.findViewById(R.id.court_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        adapter.setOnClickListener(clickListener);
        recyclerView.setAdapter(adapter);


        populateList();

    }

    private void populateList() {
        //an instance of the database class in firebase is made
        DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        //making a  reference to a particular table in the database
        mDatabaseReference.child("court").addChildEventListener(new ChildEventListener() {
            @Override
            // returns the whole list at the specified location
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                CourtModel court = dataSnapshot.getValue(CourtModel.class);
                //gets a new reference of the table in the database an updated version
                list.add(court);
                //notifies the adapter of any changes in the updated list
                adapter.notifyDataSetChanged();


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                CourtModel court = dataSnapshot.getValue(CourtModel.class);
                System.out.println("court is "+court.getName());
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        mDatabaseReference.child("court").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
        //Gets a snapshot of the data available at the time of request and sends it in the form of the java object
//                CourtModel court = dataSnapshot.getValue(CourtModel.class);
//                System.out.println("court is "+court.getName());
//
//
//            }
//
//            @Override
        //if the reader cancels or doesn't have permisson to perform the  read operation it should return a database error
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });


    }

    CustomClickListener clickListener = new CustomClickListener() {
        @Override
        public void onClick(int position) {
            CourtModel model = list.get(position);
            //Uses an explicit intent
            //Allows interaction between other components of the application
            Intent intent = new Intent(Courts.this.getContext(),CourtDetails.class);
            intent.putExtra("MODEL_ID",model.getId());
            intent.putExtra("MODEL_NAME",model.getName());
            intent.putExtra("MODEL_DESCRIPTION",model.getDescription());
            intent.putExtra("MODEL_IMAGE_URL",model.getImageUrl());
            startActivity(intent);
        }
    };


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        ((MainActivity)context).onNavigationItemSelected();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Courts");
  }
}
