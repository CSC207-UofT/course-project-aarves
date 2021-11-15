package com.aarves.bluepages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    // TODO: Bookmark/Review button redirects

    /**
     * Navigate to a new activity containing the map to-be-browsed.
     * @param view View object containing context on what's currently being shown.
     */
    public void viewMap(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }
}