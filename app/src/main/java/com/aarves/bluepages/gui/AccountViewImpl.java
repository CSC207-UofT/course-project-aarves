package com.aarves.bluepages.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.aarves.bluepages.MainApplication;
import com.aarves.bluepages.adapter.controllers.AccountController;
import com.aarves.bluepages.adapter.presenters.AccountView;

public class AccountViewImpl extends AppCompatActivity implements AccountView {
    protected AccountController accountController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainApplication application = (MainApplication) this.getApplication();
        this.accountController = application.getAdapters().getAccountController();
        application.setAccountView(this);
    }

    @Override
    public void displayPopUp(String message) {
        Toast popUp = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        popUp.show();
    }

    @Override
    public void startMainMenu() {
        Intent intent = new Intent(this, MainMenuActivity.class);
        this.startActivity(intent);
    }

    @Override
    public void finishActivity() {
        this.finish();
    }
}
