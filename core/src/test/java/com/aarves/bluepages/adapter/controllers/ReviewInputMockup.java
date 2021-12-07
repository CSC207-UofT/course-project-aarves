package com.aarves.bluepages.adapter.controllers;

import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;
import com.aarves.bluepages.usecase.interactors.review.ReviewAccountInputBoundary;

public class ReviewInputMockup implements ReviewAccountInputBoundary {

    public void createReview(int locationId, int rating, String reviewBody) throws NotLoggedInException {


    }
    public void createReview(int locationId, int rating) throws NotLoggedInException {


    }

    public void loadUserReviews() {

    }
    public void refreshUserReviews() {

    }
    public void loadLocationReviews(int locationId) {

    }
}
