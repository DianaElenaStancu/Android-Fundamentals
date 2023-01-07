package com.example.androidfall2022.storage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.androidfall2022.R;

import java.util.List;

public class StorageActivity extends AppCompatActivity {
    protected final String TAG_ACTIVITY = "storage activity";

    protected final String COLOR = "color";
    protected final String SLIDES = "slides";

    private WordViewModel wordViewModel;

    private Button buttonInsertWord;

    private LinearLayout layoutAnimations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage2);
        useSharedPreferences();

        buttonInsertWord = findViewById(R.id.buttonInsertWord);
        wordViewModel = new ViewModelProvider(this).get(WordViewModel.class);
        //onChanged method
        wordViewModel.getWords().observe(this, words -> Log.e(TAG_ACTIVITY, words.toString()));
        insertNewWords();

        layoutAnimations = findViewById(R.id.layoutAnimations);
        setAnimation();
    }


    // apply animation as a background
    //android:background="@drawable/animation"

// add an id to the element where you added the background
// in this example the element is a LinearLayout
   // android:id="@+id/layoutMain"

    // java call
    private void setAnimation() {
        AnimationDrawable animationDrawable = (AnimationDrawable) layoutAnimations.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();
    }

    private void insertNewWords() {
        buttonInsertWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                wordViewModel.insert(new Word("android" + System.currentTimeMillis()));
            }
        });
    }


    private void useSharedPreferences() {
        //save values in SharedPreferences
        ApplicationData.setStringValueInSharedPreferences(StorageActivity.this, COLOR, "blue");
        ApplicationData.setIntValueInSharedPreferences(StorageActivity.this, SLIDES, 7);


        //get values from SharedPreferences
        String valueColor = ApplicationData.getStringValueFromSharedPreferences(StorageActivity.this, COLOR);
        Toast.makeText(StorageActivity.this, valueColor, Toast.LENGTH_LONG).show();

        int valueSlides = ApplicationData.getIntValueFromSharedPreferences(StorageActivity.this, SLIDES);
        Toast.makeText(StorageActivity.this, valueSlides+"", Toast.LENGTH_LONG).show();

    }
}