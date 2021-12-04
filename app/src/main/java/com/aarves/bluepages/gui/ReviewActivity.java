package com.aarves.bluepages.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.aarves.bluepages.R;
import com.aarves.bluepages.adapter.presenters.ReviewViewModel;

import java.util.ArrayList;

public class ReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_view);
        ListView reviewListView = findViewById(R.id.listView);

        // TODO: When Location UI is done, all that is needed to be done is to pass the location's array list of reviews into this class, and then into the ReviewArrayAdapter
        // TODO: Same for RegisteredUser.

        ArrayList<ReviewViewModel> reviewList = new ArrayList<>();
        reviewList.add(new ReviewViewModel("user 1", 1));
        reviewList.add(new ReviewViewModel("user 2", 3));
        reviewList.add(new ReviewViewModel("user 3", 5));
        reviewList.add(new ReviewViewModel("user 4",4));

        ReviewArrayAdapter adapter = new ReviewArrayAdapter(this, R.layout.activity_review, reviewList);
        reviewListView.setAdapter(adapter);
    }
}
