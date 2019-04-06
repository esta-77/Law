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
import android.widget.Toast;

import com.example.franko.law.Models.AgencyModel;
import com.example.franko.law.adapters.AgencyAdapter;
import com.example.franko.law.adapters.CourtsAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Agencies extends android.support.v4.app.Fragment implements CustomClickListener {

    private RecyclerView recyclerView;

    private ArrayList<AgencyModel> values = new ArrayList<>();private AgencyAdapter adapter;

    public static  Agencies newInstance(){
        Agencies agency1 = new Agencies();
        return agency1;
    }
    public Agencies(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.agencies,container,false);
        setupUIComponent(rootView);
        return rootView;

    }


    private void setupUIComponent(View rootView) {

        adapter = new AgencyAdapter(rootView.getContext(),values);
        adapter.setOnClickListener(this);
        recyclerView = rootView.findViewById(R.id.agency_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        fillcontent();

    }

    public void fillcontent(){
        DatabaseReference mDatabaseRef = FirebaseDatabase.getInstance().getReference();
        mDatabaseRef.child("agency").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                AgencyModel agency = dataSnapshot.getValue(AgencyModel.class);
                values.add(agency);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                AgencyModel agency = dataSnapshot.getValue(AgencyModel.class);
                System.out.println("Agency is "+agency.getName());
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
    }

//    CustomClickListener clickListener = new CustomClickListener() {
//        @Override
//        public void onClick(int position) {
//            AgencyModel model = values.get(position);
//            //Uses an explicit intent
//            //Allows interaction between other components of the application
//            Intent intent = new Intent(Agencies.this.getContext(),AgencyDetails.class);
//            intent.putExtra("MODEL_ID",model.getId());
//            intent.putExtra("MODEL_NAME",model.getName());
//            intent.putExtra("MODEL_DESCRIPTION",model.getDescription());
//            intent.putExtra("MODEL_CONTACT",model.getContact());
//            intent.putExtra("MODEL_IMAGE_URL",model.getImageUrl());
//            startActivity(intent);
//        }
//    };


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        ((MainActivity)context).onNavigationItemSelected();
    }

    @Override
    public void onClick(int position) {
        AgencyModel model = values.get(position);
        Intent intent = new Intent(Agencies.this.getContext(),AgencyDetails.class);
        intent.putExtra("MODEL_ID",model.getId());
        intent.putExtra("MODEL_NAME",model.getName());
        intent.putExtra("MODEL_DESCRIPTION",model.getDescription());
        intent.putExtra("MODEL_CONTACT",model.getContact());
        intent.putExtra("MODEL_IMAGE_URL",model.getImageUrl());
        startActivity(intent);
        //Toast.makeText(getActivity(), model.getName(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Agencies");
    }
}
