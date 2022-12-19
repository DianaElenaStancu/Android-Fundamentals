package com.example.androidfall2022.activities;

import static com.example.androidfall2022.activities.FirstActivity.AGE;
import static com.example.androidfall2022.activities.FirstActivity.STATUS;

import static com.example.androidfall2022.activities.FirstActivity.MESSAGE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.androidfall2022.R;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    private TextView textViewReceivedMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.e(TAG, "onCreate");

        textViewReceivedMessage = findViewById(R.id.textViewReceivedMessage);
        receiveMessage();

        insertBlankFragment();
    }

    // add a fragment in tge activity in a dynamic way
    private void insertBlankFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutPlaceholder, new BlankFragment());
        fragmentTransaction.commit();
    }

    private void receiveMessage() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String receivedMessage = bundle.getString(MESSAGE);
            int receivedAge = bundle.getInt(AGE);
            boolean receivedStatus = bundle.getBoolean(STATUS);
            textViewReceivedMessage.setText(receivedMessage + " " + receivedAge + " " + receivedStatus);

        }
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