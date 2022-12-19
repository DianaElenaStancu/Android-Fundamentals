package com.example.androidfall2022.networking;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

//retrofit will generate the implementation of this interface
public interface GithubApi {
    @GET("/users") //path
    Call<List<User>> getAllUsers();
}
