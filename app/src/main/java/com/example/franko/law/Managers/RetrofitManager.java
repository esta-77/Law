package com.example.franko.law.Managers;

import android.content.Context;

import com.example.franko.law.BuildConfig;
import com.example.franko.law.R;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private static RetrofitManager instance;

    public static RetrofitManager getInstance() {
        if (instance == null) {
            instance = new RetrofitManager();
            return instance;
        }
        return instance;
    }


    public Retrofit getClient(Context context) {

        String baseUrl = context.getResources().getString(R.string.baseUrl);

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(provideOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static HttpLoggingInterceptor provideHttpLoggingInterceptor() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {

                System.out.println("Return values :"+message);
            }
        });

        httpLoggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.HEADERS : HttpLoggingInterceptor.Level.NONE );
        return httpLoggingInterceptor;
    }

    public static OkHttpClient provideOkHttpClient() {

        return new OkHttpClient.Builder()
                .addInterceptor(provideHttpLoggingInterceptor())
                .connectTimeout(45,TimeUnit.SECONDS)
                .readTimeout(45,TimeUnit.SECONDS)
                .build();

    }





}
