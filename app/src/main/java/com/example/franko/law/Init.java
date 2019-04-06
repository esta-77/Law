package com.example.franko.law;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

public class Init extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
