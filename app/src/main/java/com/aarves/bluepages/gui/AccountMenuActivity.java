package com.aarves.bluepages.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.aarves.bluepages.MainApplication;
import com.aarves.bluepages.R;
import com.aarves.bluepages.adapter.presenters.AccountMenuView;

public class AccountMenuActivity extends AccountViewImpl implements AccountMenuView {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_account_menu);

        ((MainApplication) this.getApplication()).setAccountMenuView(this);
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

    // Take user to bookmarks
    // TODO: connect to bookmark UI (when it is completed)
    public void viewBookmarks(View view) {
        //Intent intent = new Intent(this, );
        //startActivity(intent);
    }

    public void signOut(View view) {
         this.accountController.logout();
    }
}
