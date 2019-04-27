package com.example.franko.law.Models;

import com.google.gson.annotations.SerializedName;

public class Search {

    @SerializedName("title")
    String title;

    @SerializedName("description")
    String description;

    @SerializedName("action")
    String action;


    public Search(String title, String description,String action) {
        this.title = title;
        this.description = description;
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

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
}
