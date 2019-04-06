package com.example.franko.law.Models;

public class LawyerModel {
    String id;
    String contact;
    String image_url;
    String place_of_work;
    String name;
    String number_of_cases_won;
    String number_of_cases_lost;
    String number_of_cases_witness;
    String description;

    public LawyerModel(String id, String contact, String image_url, String place_of_work, String name, String number_of_cases_won, String number_of_cases_lost, String number_of_cases_witness,String description) {
        this.id = id;
        this.contact = contact;
        this.image_url = image_url;
        this.place_of_work = place_of_work;
        this.name = name;
        this.number_of_cases_won = number_of_cases_won;
        this.number_of_cases_lost = number_of_cases_lost;
        this.number_of_cases_witness = number_of_cases_witness;
        this.description= description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getPlace_of_work() {
        return place_of_work;
    }

    public void setPlace_of_work(String place_of_work) {
        this.place_of_work = place_of_work;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber_of_cases_won() {
        return number_of_cases_won;
    }

    public void setNumber_of_cases_won(String number_of_cases_won) {
        this.number_of_cases_won = number_of_cases_won;
    }

    public String getNumber_of_cases_lost() {
        return number_of_cases_lost;
    }

    public void setNumber_of_cases_lost(String number_of_cases_lost) {
        this.number_of_cases_lost = number_of_cases_lost;
    }

    public String getNumber_of_cases_witness() {
        return number_of_cases_witness;
    }

    public void setNumber_of_cases_witness(String number_of_cases_witness) {
        this.number_of_cases_witness = number_of_cases_witness;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

