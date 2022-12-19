package com.example.androidfall2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MoviesActivity extends AppCompatActivity {

    private List<Movie> movieList;

    private RecyclerView moviesRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        moviesRecyclerView = findViewById(R.id.recyclerViewMovies);
        setupRecyclerView();
    }

    // 0. add RecyclerView in the xml file & define the item template (matrita) - DONE

    // 1. get the data source - DONE
    // 1.1. create dedicated class for Movie - DONE
    // 1.2. populate the data source - DONE
    private void setMovieList() {
        movieList = new ArrayList<>();
        movieList.add(new Movie("Home Alone", "Comedy", "https://lumiere-a.akamaihd.net/v1/images/homealone2_7706aa6d.jpeg"));
        movieList.add(new Movie("Harry Potter", "Fantasy", "https://lumiere-a.akamaihd.net/v1/images/homealone2_7706aa6d.jpeg"));
        movieList.add(new Movie("Kill Bill", "Action", ""));
        movieList.add(new Movie("Avatar", "SF", ""));
        movieList.add(new Movie("Matrix", "Action", ""));
        movieList.add(new Movie("The Light House", "SF", ""));
        movieList.add(new Movie("Anabelle", "horror", ""));
        movieList.add(new Movie("Superman", "Action", ""));
        movieList.add(new Movie(" IronMan", "Action", ""));
        movieList.add(new Movie("Lost", "Drama", ""));

    }


    // 2. get the custom adapter
    // 2.1. define the ViewHolder -DONE
    // 2.2. define the Adapter - DONE
    //setAdapter()...movieList



    // 3. setup adapter for the RecyclerView ---
    // 3.1. setup LayoutManager - DONE
    // 3.2. set the adapter - DONE
    private void setMovieLayoutManager() {
        moviesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setMoviesAdapater() {
        moviesRecyclerView.setAdapter(new MovieAdapter(movieList));
    }

    private void setupRecyclerView() {
        setMovieList();
        setMovieLayoutManager();
        setMoviesAdapater();
    }

}