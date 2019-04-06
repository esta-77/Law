package com.example.franko.law.Models;

public class SearchModel {
    String id;
    String keyword;
    String title;
    String description;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SearchModel(String id, String title, String description, String keyword) {
        this.id =id;
        this.title = title;
        this.description =description;
        this.keyword = keyword;



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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
