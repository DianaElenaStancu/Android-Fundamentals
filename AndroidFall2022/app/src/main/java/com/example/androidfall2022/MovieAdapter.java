package com.example.androidfall2022;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private List<Movie> movieList;

    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    //create the items and add them to the parent (RecyclerView)
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);//adauga content la view-ul nostru
        return new MovieViewHolder(itemView);
    }

    //populate the item view
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie currentMovie = movieList.get(position);
        holder.getTextViewTitle().setText(currentMovie.getTitle());
        holder.getTextViewCategory().setText(currentMovie.getCategory());
        if (currentMovie.getImageUrl().length() > 0)
            Picasso.get().load(currentMovie.getImageUrl())
                    .placeholder(R.drawable.movie_icon)
                    .error(R.drawable.error)
                    .into(holder.getImageViewPoster());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
