package com.example.franko.law.Models;

import com.google.firebase.database.IgnoreExtraProperties;
import com.google.gson.annotations.Expose;

@IgnoreExtraProperties

public class SearchModel {

    @Expose
    String action;
    String title;
    String description;

    public SearchModel( String title, String description, String action) {
//        this.id =id;id
        this.title = title;
        this.description =description;
        this.action = action;
    }

//    public String getId() {
//        return id;
//    }

//    public void setId(String id) {
//        this.id = id;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;

    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
