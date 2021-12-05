package com.aarves.bluepages.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.aarves.bluepages.R;


public class AccountMenuActivity extends AccountViewImpl {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_menu);

        // display username
        TextView textView = findViewById(R.id.usernameText);
        textView.setText(String.format(this.accountController.getUsername()));

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

    // TODO: check if this is working
    public void signOut(View view) {

        Intent intent = new Intent(this, AccessActivity.class);
        startActivity(intent);
    }



}
