package com.aarves.bluepages.usecase.interactors.review;

import com.aarves.bluepages.usecase.data.review.ReviewDAO;
import com.aarves.bluepages.usecase.data.review.ReviewRepositoryImpl;

/**
 * The injector class for all review dependencies on the use case layer.
 */
public class ReviewUseCaseInjector {
    private final ReviewManager reviewManager;

    /**
     * Creates a ReviewUseCaseInjector object
     * @param reviewDAO the ReviewDAO to inject
     * @param reviewOutput the ReviewOutputBoundary to inject
     */
    public ReviewUseCaseInjector(ReviewDAO reviewDAO, ReviewOutputBoundary reviewOutput) {
        // Creates new review repository with data adapter dependency
        ReviewRepository reviewRepository = new ReviewRepositoryImpl(reviewDAO);
        // Injects review repository into use case
        this.reviewManager = new ReviewManager(reviewRepository, reviewOutput);
    }

    /**
     * Gets the ReviewManager for this ReviewUseCaseInjector
     * @return the ReviewManager for this ReviewUseCaseInjector
     */
    public ReviewManager getReviewManager() {
        return this.reviewManager;
    }
}
