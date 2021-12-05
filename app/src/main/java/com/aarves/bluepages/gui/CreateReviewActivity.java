package com.aarves.bluepages.gui;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.aarves.bluepages.R;
import com.aarves.bluepages.MainApplication;
import com.aarves.bluepages.adapter.controllers.ReviewController;
import com.aarves.bluepages.adapter.presenters.ReviewView;
import com.aarves.bluepages.adapter.presenters.ReviewViewModel;

public class CreateReviewActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_review);
    }
}
