package com.aarves.bluepages.gui;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.aarves.bluepages.R;
import com.aarves.bluepages.MainApplication;
import com.aarves.bluepages.adapter.controllers.ReviewController;
import com.aarves.bluepages.adapter.presenters.BasicView;

public class CreateReviewActivity extends AppCompatActivity implements BasicView {
    private static final int[] starIds = {R.id.starButton1, R.id.starButton2, R.id.starButton3, R.id.starButton4, R.id.starButton5};
    private ReviewController reviewController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_review);

        MainApplication application = (MainApplication) this.getApplication();
        this.reviewController = application.getAdapters().getReviewController();
        application.setReviewBaseView(this);
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

    public void submitReview(View view) {
        // Get the rating of the review
        int rating = this.getRating(view);

        // Get the text of the review
        EditText reviewTextBody = this.findViewById(R.id.reviewTextBody);
        String reviewBody = reviewTextBody.getText().toString();

        // TODO: Pass in location ID
        this.reviewController.createReview(1, rating, reviewBody);
    }

    /**
     * Sets the rating of the review
     * @param view The current view
     */
    public void setRating(View view) {
        // Get the rating of the review
        int rating = this.getRating(view);

        // Modify the image button display
        for(int i = 0; i < rating; i++) {
            ImageButton star = this.findViewById(CreateReviewActivity.starIds[i]);
            star.setImageResource(R.drawable.ic_baseline_star_24);
        }

        // Set the "empty" stars
        for(int i = rating; i < 5; i++) {
            ImageButton star = this.findViewById(CreateReviewActivity.starIds[i]);
            star.setImageResource(R.drawable.ic_baseline_star_border_24);
        }
    }

    /**
     * Gets the rating of the review based on the number of stars the user has clicked.
     * @param view The current view
     * @return The rating of the review
     */
    public int getRating(View view) {
        int rating = 0;

        // Get the rating
        for (int i = 0; i < 5; i++) {
            if (view.getId() == CreateReviewActivity.starIds[i]) {
                rating = i;
            }
        }

        return rating + 1;
    }
}
