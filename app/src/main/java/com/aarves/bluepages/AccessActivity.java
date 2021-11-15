package com.aarves.bluepages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access);
    }

    /**
     * Login to UofT Yelp as a guest user.
     * @param view View object containing context on what's currently being shown.
     */
    public void loginAsGuest(View view) {
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }

    /**
     * Login to UofT Yelp as a registered user.
     * @param view View object containing context on what's currently being shown.
     */
    public void loginAsUser(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * Register for an account to access UofT Yelp with.
     * @param view View object containing context on what's currently being shown.
     */
    public void registerNewUser(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
