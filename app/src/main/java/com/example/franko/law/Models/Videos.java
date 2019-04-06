package com.example.franko.law.Models;

public class Videos {

    String url;
    String thumbnailUrl;
    String title;
    String category;

    public Videos(String url, String thumbnailUrl, String title, String category) {
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
        this.title = title;
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
