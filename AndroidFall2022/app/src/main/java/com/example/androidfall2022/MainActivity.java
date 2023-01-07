package com.example.androidfall2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidfall2022.activities.FirstActivity;
import com.example.androidfall2022.navigation.NavigationActivity;
import com.example.androidfall2022.storage.StorageActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private EditText editTextEmail, editTextPassword;
    private TextView textViewDisplayAccount;
    private Button buttonDisplayAboutAndroid;
    private Button buttonOpenActivity;
    private Button buttonOpenNavigationActivity;
    private Button buttonOpenStorageActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setupViews();
        displayAboutAndroidOnClick();
        openActivityOnClick();
        openNavigationActivityOnClick();
        openStorageActivity();
    }

    private void openStorageActivity() {
        buttonOpenStorageActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent navigationActivity = new Intent(MainActivity.this, StorageActivity.class);
                startActivity(navigationActivity);
            }
        }
        );
    }

    private void setupViews() {
        editTextEmail = findViewById(R.id.editTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextPassword);
        textViewDisplayAccount = findViewById(R.id.textViewDisplayAccount);
        buttonDisplayAboutAndroid = findViewById(R.id.buttonAboutAndroid);
        buttonOpenActivity = findViewById(R.id.buttonOpenActivity);
        buttonOpenNavigationActivity = findViewById(R.id.buttonOpenNavigationActivity);
        buttonOpenStorageActivity = findViewById(R.id.buttonOpenStorageActivity);
    }

    private void openNavigationActivityOnClick() {
        buttonOpenNavigationActivity.setOnClickListener(view -> {
            Intent navigationActivity = new Intent(MainActivity.this, NavigationActivity.class);
            startActivity(navigationActivity);
        });
    }


    private void displayAboutAndroidOnClick() {
        buttonDisplayAboutAndroid.setOnClickListener(view -> {
            Intent moveFromMainToAboutAndroidActivity = new Intent(MainActivity.this, AboutAndroid.class);
            startActivity(moveFromMainToAboutAndroidActivity);
        });
    }

    private void openActivityOnClick() {
        buttonOpenActivity.setOnClickListener(view -> {
            Intent openNewActivity = new Intent(MainActivity.this, FirstActivity.class);
            startActivity(openNewActivity);
        });
    }

    public void loginOnClick(View view) {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        if (isValidForm(email, password)) {
            if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                moveToMoviesActivity(email, password);
            } else {
                invalidEmail();
            }
        } else {
            invalidForm();
        }
    }

    private void moveToMoviesActivity(String email, String password) {
        textViewDisplayAccount.setText(new StringBuilder().append(email).append(", ").append(password).toString());
        Intent displayMoviesActivity = new Intent(MainActivity.this, MoviesActivity.class);
        startActivity(displayMoviesActivity);
    }

    private void invalidEmail() {
        editTextEmail.setError(getString(R.string.add_email));
        Toast.makeText(MainActivity.this, getString(R.string.email_not_valid), Toast.LENGTH_LONG).show();
    }

    private void invalidForm() {
        //TODO add validation per field
        editTextEmail.setError(getString(R.string.add_email));
        editTextPassword.setError(getString(R.string.add_password));
        Log.e(TAG, "email and password empty");
    }

    private boolean isValidForm(String email, String password) {
        return email.length() > 0 && password.length() > 0;
    }
}