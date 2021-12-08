package com.aarves.bluepages.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.aarves.bluepages.R;
import com.aarves.bluepages.MainApplication;
import com.aarves.bluepages.adapter.controllers.AccountController;
import com.aarves.bluepages.adapter.presenters.AccountMenuView;

public class AccountMenuActivity extends AppCompatActivity implements AccountMenuView {
    private AccountController accountController;

    /**
     * Called when the user clicks the "Review" button. Opens the review activity.
     * @param view View object containing context on what's currently being shown.
     */
    public void viewReviews(View view) {
        Intent intent = new Intent(this, ReviewActivity.class);
        startActivity(intent);
    }

    /**
     * Called when the user clicks the "Bookmark" button. Opens the bookmark activity.
     * @param view View object containing context on what's currently being shown.
     */
    public void viewBookmarks(View view) {
        Intent intent = new Intent(this, LocationActivity.class);
        intent.putExtra(LocationActivity.IS_BOOKMARK, true);
        startActivity(intent);
    }

    /**
     * Called when the user clicks the "Sign Out" button. Signs the user out and returns them to the access activity.
     * @param view View object containing context on what's currently being shown.
     */
    public void signOut(View view) {
        this.accountController.logout();
    }

    /**
     * Display relevant information to the user's account, and change button visibility based on the user's account type.
     * @param userText The username of the user.
     */
    @Override
    public void displayAccountInformation(String userText) {
        // Displays the account information
        TextView textView = findViewById(R.id.usernameText);
        textView.setText(userText);

        Button reviewButton = findViewById(R.id.reviewButton);
        Button bookmarkButton = findViewById(R.id.bookmarkButton);
        Button signOutButton = findViewById(R.id.signOutButton);

        if (this.accountController.isLoggedIn()) {
            reviewButton.setVisibility(View.VISIBLE);
            bookmarkButton.setVisibility(View.VISIBLE);
            signOutButton.setVisibility(View.VISIBLE);
        }
        else {
            reviewButton.setVisibility(View.INVISIBLE);
            bookmarkButton.setVisibility(View.INVISIBLE);
            signOutButton.setVisibility(View.INVISIBLE);
        }
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
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_account_menu);

        MainApplication application = (MainApplication) this.getApplication();
        this.accountController = application.getAdapters().getAccountController();
        application.setAccountMenuView(this);

        this.accountController.loadAccountInformation();
    }

}
