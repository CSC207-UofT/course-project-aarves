package com.aarves.bluepages.usecase.interactors;

import com.aarves.bluepages.entities.User;
import com.aarves.bluepages.entities.Review;
import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;
import com.aarves.bluepages.usecase.exceptions.PermissionsFailureException;

import java.util.ArrayList;

public class ReviewManager {
    private final ReviewRepository reviewRepository;
    private final AccountManager accountManager; // TODO: Too coupled? Maybe refactor into interface.

    public ReviewManager(ReviewRepository reviewRepository, AccountManager accountManager) {
        this.reviewRepository = reviewRepository;
        this.accountManager = accountManager;
    }

    public Review getReview(int reviewId) {
        return this.reviewRepository.getReview(reviewId);
    }

    /**
     * Creates a new review and adds it to the reviewHashMap
     *
     * @param locationId    Integer representing the ID of the Location this Review is addressed towards.
     * @param rating        Integer rating (out of 5) for location as per the User's opinion.
     * @param reviewBody    String information about the User's opinions.
     */
    public void createReview(int locationId, int rating, String reviewBody) throws NotLoggedInException {
        if(this.accountManager.isLoggedIn()) {
            User user = this.getUser();
            Review newReview = new Review(user.getUsername(), locationId, rating, reviewBody);
            int newId = this.reviewRepository.addReview(newReview);

            newReview.setReviewId(newId);
            user.addReview(newReview);
        }
        else {
            throw new NotLoggedInException();
        }
    }

    /**
     * Creates a new review and adds it to the reviewHashMap.
     *
     * @param locationId    Integer representing the ID of the Location this Review is addressed towards.
     * @param rating        Integer rating (out of 5) for location as per the User's opinion.
     */
    public void createReview(int locationId, int rating) throws NotLoggedInException {
        if(this.accountManager.isLoggedIn()) {
            User user = this.getUser();
            Review newReview = new Review(user.getUsername(), locationId, rating);
            int newId = this.reviewRepository.addReview(newReview);

            newReview.setReviewId(newId);
            user.addReview(newReview);
        }
        else {
            throw new NotLoggedInException();
        }
    }

    /**
     * Deletes all reviews associated with the User.
     */
    public void deleteAllUserReviews() throws PermissionsFailureException, NotLoggedInException {
        if(this.accountManager.isLoggedIn()) {
            ArrayList<Review> reviews = this.getUser().getReviews();
            for (Review review : reviews) {
                this.deleteReview(review);
            }
            this.getUser().setReviews(new ArrayList<>());
        }
        else {
            throw new NotLoggedInException();
        }
    }

    /**
     * Deletes a review from all three locations where it is stored.
     * @param review    the Review to be deleted
     */
    public void deleteReview(Review review) throws PermissionsFailureException, NotLoggedInException {
        if(this.accountManager.isLoggedIn() && this.getUser().getUsername().equals(review.getReviewer())) {
            this.reviewRepository.deleteReview(review);
            this.getUser().deleteReview(review);
        }
        else if(this.accountManager.isLoggedIn()) {
            throw new PermissionsFailureException();
        }
        else {
            throw new NotLoggedInException();
        }
    }

    private User getUser(){
        return this.accountManager.getUser();
    }
}
