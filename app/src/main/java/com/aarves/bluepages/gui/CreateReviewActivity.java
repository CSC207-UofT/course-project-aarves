package com.aarves.bluepages.gui;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import android.os.Bundle;

import com.aarves.bluepages.R;
import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;

public class CreateReviewActivity extends CreateReviewViewImpl {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_review);
    }

    /**
     * Sets the rating of the review
     * @param view
     */
    public void setRating(View view) {
        int[] starIds = getStarIds(view);

        // Get the rating of the review
        int rating = getRating(view, starIds);

        // Modify the image button display
        for(int i = 0; i < rating; i++) {
            ImageView star = view.findViewById(starIds[i]);
            star.setImageResource(R.drawable.ic_baseline_star_24);
        }

    }

    /**
     * Gets the rating of the review based on the number of stars the user has clicked.
     * @param view The current view.
     * @param starIds The array of image buttons available for clicking.
     * @return the rating of the review
     */
    public int getRating(View view, int[] starIds) {

        int rating = 0;

        // Get the rating
        for (int i = 0; i < 4; i++) {
            if (view.getId() == starIds[i]) {
                rating = i;
            }
        }

        return rating;
    }

    /**
     * Returns an array of the ids of the star buttons.
     * @param view
     * @return
     */
    public int[] getStarIds(View view) {
        int[] starIds = {R.id.starButton1, R.id.starButton2, R.id.starButton3, R.id.starButton4, R.id.starButton5};
        return starIds;
    }

    public void submitReview(View view) throws NotLoggedInException {
        // Get the rating of the review
        int[] starIds = getStarIds(view);
        int rating = getRating(view, starIds);

        // Get the text of the review
        EditText reviewTextBody = this.findViewById(R.id.reviewTextBody);
        String reviewBody = reviewTextBody.getText().toString();

        // TODO: Pass in location ID
        this.reviewController.createReview(1, rating, reviewBody);
    }

}
