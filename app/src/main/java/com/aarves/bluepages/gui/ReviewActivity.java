package com.aarves.bluepages.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.aarves.bluepages.R;
import com.aarves.bluepages.entities.Review;

import java.util.ArrayList;

public class ReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_view);
        ListView reviewListView = findViewById(R.id.listView);

        // TODO: When Location UI is done, all that is needed to be done is to pass the location's array list of reviews into this class, and then into the ReviewViewAdapter
        // TODO: Same for RegisteredUser.

        ArrayList<Review> reviewList = new ArrayList<>();
        reviewList.add(new Review("user 1", 0, 1));
        reviewList.add(new Review("user 2", 0, 3));
        reviewList.add(new Review("user 3", 0, 5));
        reviewList.add(new Review("user 4", 0, 4));

        ReviewArrayAdapter adapter = new ReviewArrayAdapter(this, R.layout.activity_review, reviewList);
        reviewListView.setAdapter(adapter);
    }
}
