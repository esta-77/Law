package com.example.franko.law.Interfaces;

import com.example.franko.law.Models.Search;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetApi {

    @GET("onSearch")
    Call<List<Search>> searchApp(@Query("text") String searchWord);


}
