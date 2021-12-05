package com.aarves.bluepages.usecase.interactors.review;

import com.aarves.bluepages.usecase.data.ReviewDAO;
import com.aarves.bluepages.usecase.data.ReviewRepositoryImpl;

public class ReviewUseCaseInjector {
    private final ReviewManager reviewManager;

    public ReviewUseCaseInjector(ReviewDAO reviewDAO, ReviewOutputBoundary reviewOutput) {
        ReviewRepository reviewRepository = new ReviewRepositoryImpl(reviewDAO);
        this.reviewManager = new ReviewManager(reviewRepository, reviewOutput);
    }

    public ReviewManager getReviewManager() {
        return this.reviewManager;
    }
}
