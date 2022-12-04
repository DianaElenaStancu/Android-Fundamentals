package com.example.androidfall2022;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    private final ImageView imageViewPoster;
    private final TextView textViewTitle, textViewCategory;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        imageViewPoster = itemView.findViewById(R.id.imageViewPoster);
        textViewTitle = itemView.findViewById(R.id.textViewMovieTitle);
        textViewCategory = itemView.findViewById(R.id.textViewMovieCategory);
    }

    public ImageView getImageViewPoster() {
        return imageViewPoster;
    }

    public TextView getTextViewTitle() {
        return textViewTitle;
    }

    public TextView getTextViewCategory() {
        return textViewCategory;
    }
}
