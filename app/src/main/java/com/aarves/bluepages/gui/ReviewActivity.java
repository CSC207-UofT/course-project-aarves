package com.aarves.bluepages.gui;

import android.widget.Toast;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.aarves.bluepages.R;
import com.aarves.bluepages.MainApplication;
import com.aarves.bluepages.adapter.controllers.ReviewController;
import com.aarves.bluepages.adapter.presenters.ReviewView;
import com.aarves.bluepages.adapter.presenters.ReviewViewModel;

import java.util.List;

public class ReviewActivity extends AppCompatActivity implements ReviewView {
    public static final String LOCATION_ID = "locationId";
    public static final int DEFAULT_ID = 0;

    private ReviewController reviewController;
    private ReviewArrayAdapter reviewAdapter;
    private int locationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_view);
        ListView reviewListView = this.findViewById(R.id.listView);

        this.reviewAdapter = new ReviewArrayAdapter(this, R.layout.activity_review);
        reviewListView.setAdapter(this.reviewAdapter);

        MainApplication application = (MainApplication) this.getApplication();
        this.reviewController = application.getAdapters().getReviewController();
        application.setReviewView(this);

        Bundle extras = this.getIntent().getExtras();
        if(extras != null) {
            this.locationId = extras.getInt(ReviewActivity.LOCATION_ID);
        }

        if(this.locationId == ReviewActivity.DEFAULT_ID) {
            this.reviewController.loadUserReviews();
        }
        else {
            this.reviewController.loadLocationReviews(this.locationId);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        MainApplication application = (MainApplication) this.getApplication();
        application.setReviewView(this);

        if(this.locationId == ReviewActivity.DEFAULT_ID) {
            this.reviewController.loadUserReviews();
        }
        else {
            this.reviewController.loadLocationReviews(this.locationId);
        }
    }

    @Override
    public void displayReviews(List<ReviewViewModel> reviews) {
        this.reviewAdapter.clear();
        this.reviewAdapter.addAll(reviews);
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
