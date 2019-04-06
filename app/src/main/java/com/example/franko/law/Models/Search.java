package com.example.franko.law.Models;

import com.google.gson.annotations.SerializedName;

public class Search {

    @SerializedName("title")
    String title;

    @SerializedName("description")
    String description;


    public Search(String title, String description) {
        this.title = title;
        this.description = description;
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
