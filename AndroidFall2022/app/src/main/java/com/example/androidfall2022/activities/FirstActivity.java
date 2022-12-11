package com.example.androidfall2022.activities;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.lang.UProperty;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidfall2022.R;

public class FirstActivity extends AppCompatActivity {

    protected static final String MESSAGE = "message";
    protected static final String AGE = "age";
    protected static final String STATUS = "status";

    private final String TAG = "FirstActivity";
    private Button buttonOpenSecondActivity, buttonDial, buttonOpenWebsite, buttonSendMessage;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Log.e(TAG, "onCreate");

        setupButtonOpenSecondActivity();
        setupButtonDial();
        setupButtonWebsite();
        setupButtonSendMessage();
    }

    private void setupButtonSendMessage() {
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSendMessage = findViewById(R.id.buttonSendMessage);

        buttonSendMessage.setOnClickListener(view -> {
            String message = editTextMessage.getText().toString();
            if(message.length() > 0) {
                Intent sendMessage = new Intent(FirstActivity.this, SecondActivity.class);
                sendMessage.putExtra(MESSAGE, message);
                sendMessage.putExtra(AGE, 23);
                sendMessage.putExtra(STATUS, false);

                startActivity(sendMessage);
            }
        });
    }

    private void setupButtonWebsite() {
        buttonOpenWebsite = findViewById(R.id.buttonOpenWebsite);
        buttonOpenWebsite.setOnClickListener(view -> {
            Intent openWebsite = new Intent(Intent.ACTION_VIEW);
            openWebsite.setData(Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway%2C+CA"));
            startActivity(openWebsite);
        });
    }

    private void setupButtonDial() {
        buttonDial = findViewById(R.id.buttonDial);
        buttonDial.setOnClickListener(view -> {
            try {
                Intent dialActivity = new Intent(Intent.ACTION_DIAL); //implicit intent from android
                dialActivity.setData(Uri.parse("tel:077777777"));
                //if(dialActivity.resolveActivity(getPackageManager()) != null) { //verification
                startActivity(dialActivity);
                //}
            } catch (Exception e) {
                //handle the case when this activity can not be started
            }

        });
    }

    private void setupButtonOpenSecondActivity() {
        buttonOpenSecondActivity = findViewById(R.id.buttonOpenSecondActivity);
        buttonOpenSecondActivity.setOnClickListener(view -> {
            Intent openSecondActivity = new Intent(FirstActivity.this, SecondActivity.class);
            startActivity(openSecondActivity);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }
}