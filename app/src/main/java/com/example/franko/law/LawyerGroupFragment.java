package com.example.franko.law;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.franko.law.Models.LawyerGroupModel;
import com.example.franko.law.Models.LawyerModel;
import com.example.franko.law.adapters.LawyerGroupAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LawyerGroupFragment extends android.support.v4.app.Fragment {
    LawyerGroupAdapter adapter;
    RecyclerView recyclerView;
    List<LawyerGroupModel> content = new ArrayList<>();

    public static LawyerGroupFragment newInstance(){
        LawyerGroupFragment lawyer1 = new LawyerGroupFragment();
        return lawyer1;
    }
//    public Lawyers(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.lawyers,container,false);
        setUIComponent(rootView);
        return rootView;
    }

    public void setUIComponent(View rootView){
        recyclerView = rootView.findViewById(R.id.lawyers_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext(),LinearLayoutManager.VERTICAL,false));
//        recyclerView.setLayoutManager(new GridLayoutManager(rootView.getContext(), 2));
        recyclerView.setHasFixedSize(true);
        adapter = new LawyerGroupAdapter(content, getActivity());
        recyclerView.setAdapter(adapter);
        adapter.setCustomClickListener(new CustomClickListener() {
            @Override
            public void onClick(int position) {
                LawyerGroupModel model = content.get(position);

                Intent intent = new Intent(LawyerGroupFragment.this.getContext(),LawyerCategory.class);
                intent.putExtra("MODEL_ID", model.getId());
                startActivity(intent);
            }
        });

        populateList();

        FloatingActionButton fab = rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), BotActivity.class));
            }
        });

    }
    private void populateList() {
        //an instance of the database class in firebase is made
        DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        //making a  reference to a particular table in the database
        mDatabaseReference.child("lawyer_groups").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                HashMap<String, Object> item = (HashMap<String, Object>) dataSnapshot.getValue();
                content.add(new LawyerGroupModel(dataSnapshot.getKey(), String.valueOf(item.get("name"))));
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                LawyerModel lawyer = dataSnapshot.getValue(LawyerModel.class);
                System.out.println("lawyer is " + lawyer.getName());
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


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        ((MainActivity)context).onNavigationItemSelected();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Lawyers Category");
    }
}
