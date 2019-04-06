package com.example.franko.law.Models;

public class AgencyModel {
    Integer _id;
    String name;
    String description;
    String contact;
    String image_url;


    public AgencyModel() {

    }

    public AgencyModel(Integer _id, String name, String imageUrl,String contact,String description) {
        this._id = _id;
        this.name = name;
        this.image_url = imageUrl;
        this.contact = contact;
        this.description = description;
    }
    public Integer getId() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String image_url) {
        this.image_url = image_url;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setId(Integer _id) {
        this._id = _id;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
