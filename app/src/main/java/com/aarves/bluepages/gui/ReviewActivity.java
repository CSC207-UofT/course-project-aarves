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
    private ReviewController reviewController;
    private ReviewArrayAdapter reviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_view);
        ListView reviewListView = this.findViewById(R.id.listView);

        // TODO: When Location UI is done, all that is needed to be done is to pass the location's array list of reviews into this class, and then into the ReviewArrayAdapter
        // TODO: Same for RegisteredUser.
        this.reviewAdapter = new ReviewArrayAdapter(this, R.layout.activity_review);
        reviewListView.setAdapter(this.reviewAdapter);

        MainApplication application = (MainApplication) this.getApplication();
        this.reviewController = application.getAdapters().getReviewController();
        application.setReviewView(this);

        this.reviewController.loadReviews();
    }

    @Override
    protected void onResume() {
        super.onResume();

        MainApplication application = (MainApplication) this.getApplication();
        application.setReviewView(this);

        this.reviewController.loadReviews();
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
