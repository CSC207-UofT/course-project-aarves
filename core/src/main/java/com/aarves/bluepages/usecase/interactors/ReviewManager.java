package com.aarves.bluepages.usecase.interactors;

import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.entities.RegisteredUser;
import com.aarves.bluepages.entities.Review;

import java.util.ArrayList;

public class ReviewManager {
    private ReviewRepository reviewRepository;
    private AccountManager accountManager;

    public ReviewManager(ReviewRepository reviewRepository, AccountManager accountManager) {
        this.reviewRepository = reviewRepository;
        this.accountManager = accountManager;
    }

    protected Review getReview(int reviewId) {
        return this.reviewRepository.getReview(reviewId);
    }

    /**
     * Creates a new review and adds it to the reviewHashMap
     *
     * @param reviewer      The RegisteredUser creating the Review.
     * @param locationId    Integer representing the ID of the Location this Review is addressed towards.
     * @param rating        Integer rating (out of 5) for location as per the RegisteredUser's opinion.
     * @param reviewBody        String information about the RegisteredUser's opinions.
     */
    public void createReview(RegisteredUser reviewer, int locationId, int rating, String reviewBody) {
        Review newReview = new Review(reviewer.getUsername(), locationId, rating, reviewBody);
        int newId = this.reviewRepository.addReview(newReview);
        newReview.setReviewId(newId);
    }

    /**
     * Creates a new review and adds it to the reviewHashMap.
     *
     * @param reviewer      The RegisteredUser creating the Review.
     * @param locationId    Integer representing the ID of the Location this Review is addressed towards.
     * @param rating        Integer rating (out of 5) for location as per the RegisteredUser's opinion.
     */
    public void createReview(RegisteredUser reviewer, int locationId, int rating) {
        Review newReview = new Review(reviewer.getUsername(), locationId, rating);
        int newId = this.reviewRepository.addReview(newReview);
        newReview.setReviewId(newId);
    }

    /**
     * Deletes all reviews associated with a RegisteredUser.
     *
     * @param reviewer the RegisteredUser whose reviews will be deleted.
     */
    public void deleteAllUserReviews(RegisteredUser reviewer) {
        ArrayList<Review> reviews = reviewer.getReviews();
        for (Review review : reviews) {
            deleteReview(reviewer, review);
        }
    }

    /**
     * Deletes a review from all three locations where it is stored.
     *
     * @param reviewer the RegisteredUser of the review
     * @param review the Review to be deleted
     */
    public void deleteReview(RegisteredUser reviewer, Review review) {
        this.reviewRepository.deleteReview(review);
        reviewer.deleteReview(review);
    }
}
