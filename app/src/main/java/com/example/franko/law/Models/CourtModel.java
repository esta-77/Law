package com.example.franko.law.Models;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class CourtModel {

    Integer _id;
    String name;
    String description;
    String image_url;

    public CourtModel() {

    }

    public CourtModel(Integer _id, String name, String description, String imageUrl) {
        this._id = _id;
        this.name = name;
        description = description;
        this.image_url = imageUrl;
    }

    public Integer getId() {
        return _id;
    }

    public void setId(Integer _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
//
//    public void setDescription(String description) {
//        Description = description;
//    }

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String imageUrl) {
        this.image_url = imageUrl;
    }
}
