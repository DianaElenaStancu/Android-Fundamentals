package com.example.androidfall2022.networking;

import com.google.gson.annotations.SerializedName;
//POJO
public class User {
    private int id;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("login")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
