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
import com.aarves.bluepages.usecase.interactors.AccountManager;

import java.util.ArrayList;

public class AccountMenuActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_account_menu);
        TextView textView = (TextView) findViewById(R.id.textView2);
        // in AccountController add savedInstanceState.putString("Username", username)
        //savedInstanceState is local
        // then I would grab savedInstanceState.username
        String username = super.getUsername();
        textView.setText(AccountController.getUsername());
    }


    public void viewReviews(View view) {

        Intent intent = new Intent(this, ReviewActivity.class);
        startActivity(intent);
    }

    public void viewBookmarks(View view) {
        // waiting on bookmarks UI
        Intent intent = new Intent(this, );
        startActivity(intent);
    }



}
