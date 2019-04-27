package com.example.franko.law;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.franko.law.Interfaces.GetApi;
import com.example.franko.law.Managers.RetrofitManager;
import com.example.franko.law.Models.Search;
import com.example.franko.law.Models.SearchModel;
import com.example.franko.law.adapters.SearchAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchFragment extends android.support.v4.app.Fragment {
    private RecyclerView recyclerView;
    private SearchAdapter searchAdapter;
    private ArrayList<SearchModel> laws_searched;
    private RecyclerView.LayoutManager mLayoutManager;
    private EditText searchtext;
    private Button searchbox;


    public static SearchFragment newInstance(){
        return new SearchFragment();
    }
    public SearchFragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
       // buildRecyclerView(view);
        setButtons(view);
        return view;
    }

    private void setButtons(View view){

        searchtext = (EditText) view.findViewById(R.id.fragment_search_text);
        searchbox = (Button) view.findViewById(R.id.search_button);

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LawDroid_Activity.class));
            }
        });

        // when the search button is clicked initially to begin search through the laws
        searchbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!TextUtils.isEmpty(searchtext.getText().toString())){

                    makeSearchRequest(searchtext.getText().toString());
                }else{
                    Toast.makeText(getContext(), "Please enter a keyword", Toast.LENGTH_SHORT).show();
                }



            }
        });



    }

    private void makeSearchRequest(String searchWord) {

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Searching");
        progressDialog.show();

        RetrofitManager.getInstance().getClient(getContext()).create(GetApi.class).searchApp(searchWord).enqueue(new Callback<List<Search>>() {
            @Override
            public void onResponse(Call<List<Search>> call, Response<List<Search>> response) {

                progressDialog.dismiss();

                if (response.code() == 200) {

                    ArrayList<Search> list = (ArrayList<Search>) response.body();

                    if (list.size() ==  0) {

                        System.out.println("No Search Item Found");

                    }else {

                        String gson = new Gson().toJson(list);
                        Intent intent = new Intent(getContext(),SearchActivity.class);
                        intent.putExtra("SEARCH_INTENT_GSON",gson);
                        startActivity(intent);
                    }


                }else {

                    Toast.makeText(getContext(),"Errow th code :"+response.code(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Search>> call, Throwable t) {
                progressDialog.dismiss();

                Toast.makeText(getContext(),"Error with reason :"+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }






    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Home");
    }
}
