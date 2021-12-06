package com.aarves.bluepages.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.aarves.bluepages.R;
import com.aarves.bluepages.MainApplication;
import com.aarves.bluepages.adapter.controllers.AccountController;
import com.aarves.bluepages.adapter.presenters.AccountMenuView;

/**
 * Class currently does not work, need to pass the locations in still
 */
public class AccountMenuActivity extends AppCompatActivity implements AccountMenuView {
    private AccountController accountController;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_account_menu);

        MainApplication application = (MainApplication) this.getApplication();
        this.accountController = application.getAdapters().getAccountController();
        application.setAccountMenuView(this);

        this.accountController.loadAccountInformation();
    }

    @Override
    public void displayAccountInformation(String userText) {
        // Displays the account information
        TextView textView = findViewById(R.id.usernameText);
        textView.setText(userText);
    }

    // Take user to reviews
    public void viewReviews(View view) {
        Intent intent = new Intent(this, ReviewActivity.class);
        startActivity(intent);
    }

    public void viewBookmarks(View view) {
        Intent intent = new Intent(this, BookmarkActivity.class);
        startActivity(intent);
    }

    public void signOut(View view) {
         this.accountController.logout();
    }

    @Override
    public void displayPopUp(String message) {
        Toast popUp = Toast.makeText(this.getApplicationContext(), message, Toast.LENGTH_SHORT);
        popUp.show();
    }

    @Override
    public void finishActivity() {
        this.finish();
    }
}
