package com.aarves.bluepages.adapter.controllers;

import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;
import com.aarves.bluepages.usecase.interactors.review.ReviewAccountInputBoundary;

public class ReviewController {
    private final ReviewAccountInputBoundary reviewInput;

    /**
     * Creates a ReviewController object.
     * @param reviewInput the ReviewAccountInputBoundary interface to inject.
     */
    public ReviewController(ReviewAccountInputBoundary reviewInput) {
        this.reviewInput = reviewInput;
    }

    /**
     * Loads all reviews associated with the user to present via the ReviewPresenter.
     */
    public void loadUserReviews() {
        this.reviewInput.loadUserReviews();
    }

    /**
     * Loads all location reviews associated with the location to present via the ReviewPresenter.
     * @param locationId the ID of the location to load the reviews for
     */
    public void loadLocationReviews(int locationId) {
        this.reviewInput.loadLocationReviews(locationId);
    }

    /**
     * Creates a review with the given rating and review text for a given location.
     * @param locationId the ID of the location being reviewed
     * @param rating the user's given rating for the review
     * @param reviewBody the user's given text for the review
     */
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
