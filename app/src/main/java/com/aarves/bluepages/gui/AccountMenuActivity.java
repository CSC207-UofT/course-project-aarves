package com.aarves.bluepages.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.aarves.bluepages.R;

import java.util.Objects;


public class AccountMenuActivity extends AccountViewImpl {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_menu);

        displayAccountInformation();
    }

    public void displayAccountInformation() {
        // displays the account information
        TextView textView = findViewById(R.id.usernameText);

        Bundle loginInformation = getIntent().getExtras();

        if (loginInformation == null) { // the user logged in as a guest
            textView.setText("Guest User");
        }
        else { // the user is logged in with an account
            //display username
            textView.setText(this.accountController.getUsername());
        }

    }

    // take user to reviews
    public void viewReviews(View view) {

        Intent intent = new Intent(this, ReviewActivity.class);
        startActivity(intent);
    }

    // take user to bookmarks
    // TODO: connect to bookmark UI (when it is completed)
    public void viewBookmarks(View view) {
        //Intent intent = new Intent(this, );
        //startActivity(intent);
    }

    public void signOut(View view) {
         this.accountController.logout();
    }



}
