package com.aarves.bluepages.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.aarves.bluepages.R;
import com.aarves.bluepages.MainApplication;
import com.aarves.bluepages.adapter.controllers.AccountController;

public class MainMenuActivity extends AppCompatActivity {
    private AccountController accountController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        MainApplication application = (MainApplication) this.getApplication();
        this.accountController = application.getAdapters().getAccountController();
    }

    @Override
    public void onBackPressed() {
        if (!this.accountController.isLoggedIn()) {
            super.onBackPressed();
        }
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

    public void viewLocations(View view) {
        Intent intent = new Intent(this, LocationActivity.class);
        intent.putExtra(LocationActivity.IS_BOOKMARK, false);
        startActivity(intent);
    }
}
