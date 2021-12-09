package com.aarves.bluepages.gui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.aarves.bluepages.MainApplication;
import com.aarves.bluepages.adapter.controllers.AccountController;
import com.aarves.bluepages.adapter.presenters.AccountView;

public class AccountViewImpl extends AppCompatActivity implements AccountView {
    protected AccountController accountController;

    /**
     * Start the main menu activity.
     */
    @Override
    public void startMainMenu() {
        Intent intent = new Intent(this, MainMenuActivity.class);
        this.startActivity(intent);
    }

    /**
     * Start the access activity.
     */
    @Override
    public void returnToAccessMenu() {
        Intent intent = new Intent(this, AccessActivity.class);
        this.startActivity(intent);
    }

    /**
     * Show a toast message.
     * @param message The message to show.
     */
    @Override
    public void displayPopUp(String message) {
        Toast popUp = Toast.makeText(this.getApplicationContext(), message, Toast.LENGTH_SHORT);
        popUp.show();
    }

    /**
     * Finish this activity.
     */
    @Override
    public void finishActivity() {
        this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainApplication application = (MainApplication) this.getApplication();
        this.accountController = application.getAdapters().getAccountController();
        application.setAccountView(this);
    }
}
