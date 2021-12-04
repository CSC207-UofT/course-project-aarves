package com.aarves.bluepages.adapter.controllers;

import com.aarves.bluepages.usecase.interactors.review.ReviewInputBoundary;

public class ReviewController {
    private final ReviewInputBoundary reviewInput;

    public ReviewController(ReviewInputBoundary reviewInput) {
        this.reviewInput = reviewInput;
    }

    public void loadReviews() {
        this.reviewInput.loadReviews();
    }
}
