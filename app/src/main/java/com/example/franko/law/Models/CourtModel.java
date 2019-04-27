package com.example.franko.law.Models;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class CourtModel {

    Integer _id;
    String name;
    String description,rewards,cases_handled;
    String image_url;

    public CourtModel() {

    }

    public CourtModel(Integer _id, String name, String description, String imageUrl,String  rewards ,String cases_handled) {
        this._id = _id;
        this.name = name;
        description = description;
        this.image_url = imageUrl;
        this.cases_handled = cases_handled;
        this.rewards = rewards;
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

    public String getRewards() {
        return rewards;
    }

    public void setRewards(String rewards) {
        this.rewards = rewards;
    }

    public String getCases_handled() {
        return cases_handled;
    }

    public void setCases_handled(String cases_handled) {
        this.cases_handled = cases_handled;
    }
}
