package com.example.androidfall2022;

public class Movie {
    private final String title;
    private final String category;
    private final String imageUrl;

    public Movie(String title, String category, String imageUrl) {
        this.title = title;
        this.category = category;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
