package com.aarves.bluepages.gui;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.aarves.bluepages.R;
import com.aarves.bluepages.MainApplication;
import com.aarves.bluepages.adapter.controllers.ReviewController;
import com.aarves.bluepages.adapter.presenters.BasicView;

public class CreateReviewActivity extends AppCompatActivity implements BasicView {
    private static final int[] starIds = {R.id.starButton1, R.id.starButton2, R.id.starButton3, R.id.starButton4, R.id.starButton5};

    private ReviewController reviewController;
    private int locationId;
    private int rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_review);
        this.rating = 0;

        MainApplication application = (MainApplication) this.getApplication();
        this.reviewController = application.getAdapters().getReviewController();
        application.setReviewBaseView(this);

        // Get Location ID
        Bundle extras = this.getIntent().getExtras();
        this.locationId = extras.getInt(LocationActivity.LOCATION_ID, 0);

        // Get location name and set the title
        TextView locationName = findViewById(R.id.locationName);
        locationName.setText(extras.getString(ReviewActivity.LOCATION_NAME, "Location Name"));
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
        // Get the text of the review
        EditText reviewTextBody = this.findViewById(R.id.reviewTextBody);
        String reviewBody = reviewTextBody.getText().toString();

        this.reviewController.createReview(this.locationId, this.rating, reviewBody);
    }

    /**
     * Sets the rating of the review
     * @param view The current view
     */
    public void setRating(View view) {
        // Get the new rating of the review
        this.updateRating(view);

        // Modify the image button display
        for(int i = 0; i < this.rating; i++) {
            ImageButton star = this.findViewById(CreateReviewActivity.starIds[i]);
            star.setImageResource(R.drawable.ic_baseline_star_24);
        }

        // Set the "empty" stars
        for(int i = this.rating; i < 5; i++) {
            ImageButton star = this.findViewById(CreateReviewActivity.starIds[i]);
            star.setImageResource(R.drawable.ic_baseline_star_border_24);
        }
    }

    /**
     * Gets the rating of the review based on the number of stars the user has clicked.
     * @param view The current view
     */
    public void updateRating(View view) {
        // Reset the rating
        this.rating = 0;

        // Get the rating
        for (int i = 1; i <= 5; i++) {
            if (view.getId() == CreateReviewActivity.starIds[i - 1]) {
                this.rating = i;
            }
        }
    }
}
