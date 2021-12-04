package com.aarves.bluepages.gui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.aarves.bluepages.R;
import com.aarves.bluepages.adapter.controllers.AccountController;
import com.aarves.bluepages.database.models.AccountDataEntity;
import com.aarves.bluepages.usecase.interactors.account.AccountManager;

import java.util.ArrayList;


public class AccountMenuActivity extends AccountViewImpl{

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_menu);

        // display username
        // TODO: is the app displaying username?
        TextView textView = findViewById(R.id.usernameText);
        textView.setText(String.format("Welcome %s", this.accountController.getUsername()));
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
    public void signOut(View view){

        String password = getIntent().getExtras().getString("password");
        String username = getIntent().getExtras().getString("username");
        this.accountController.login(username, password );
    }



}
