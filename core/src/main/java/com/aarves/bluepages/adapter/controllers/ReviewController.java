package com.aarves.bluepages.adapter.controllers;

import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;
import com.aarves.bluepages.usecase.interactors.review.ReviewAccountInputBoundary;

public class ReviewController {
    private final ReviewAccountInputBoundary reviewInput;

    public ReviewController(ReviewAccountInputBoundary reviewInput) {
        this.reviewInput = reviewInput;
    }

    public void loadReviews() {
        this.reviewInput.loadUserReviews();
    }

    public void createReview(int locationId, int rating, String reviewBody) {
        try {
            if (!reviewBody.isEmpty()) {
                this.reviewInput.createReview(locationId, rating, reviewBody);
            }
            else {
                this.reviewInput.createReview(locationId, rating);
            }
        }
        catch(NotLoggedInException exception) {
            exception.printStackTrace();
        }
    }
}
