package com.aarves.bluepages.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.aarves.bluepages.R;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    /**
     * Navigate to a new activity containing the map to-be-browsed.
     * @param view View object containing context on what's currently being shown.
     */
    public void viewMap(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

    public void viewAccount(View view) {
        Intent intent = new Intent(this, AccountMenuActivity.class);
        startActivity(intent);
    }
}
