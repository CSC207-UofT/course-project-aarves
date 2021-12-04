package com.aarves.bluepages.usecase.interactors;

import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;
import com.aarves.bluepages.usecase.exceptions.PermissionsFailureException;
import com.aarves.bluepages.entities.Review;
import com.aarves.bluepages.entities.User;

import java.util.ArrayList;
import java.util.List;

public class ReviewManager implements Observer<User> {
    private final ReviewRepository reviewRepository;

    private List<Review> reviews;
    private User user;

    public ReviewManager(ReviewRepository reviewRepository, AccountManager accountManager) {
        this.reviewRepository = reviewRepository;
        this.reviews = new ArrayList<>();
    }

    @Override
    public void update(User arg) {
        this.reviews = arg.getReviews();
        this.user = arg;
    }

    /**
     * Creates a new review and adds it to the reviewHashMap
     *
     * @param locationId    Integer representing the ID of the Location this Review is addressed towards.
     * @param rating        Integer rating (out of 5) for location as per the User's opinion.
     * @param reviewBody    String information about the User's opinions.
     */
    public void createReview(int locationId, int rating, String reviewBody) throws NotLoggedInException {
        this.checkLoggedIn();

        Review newReview = new Review(this.user.getUsername(), locationId, rating, reviewBody);
        int newId = this.reviewRepository.addReview(newReview);

        newReview.setReviewId(newId);
        this.user.addReview(newReview);
    }

    /**
     * Creates a new review and adds it to the reviewHashMap.
     *
     * @param locationId    Integer representing the ID of the Location this Review is addressed towards.
     * @param rating        Integer rating (out of 5) for location as per the User's opinion.
     */
    public void createReview(int locationId, int rating) throws NotLoggedInException {
        this.checkLoggedIn();

        Review newReview = new Review(this.user.getUsername(), locationId, rating);
        int newId = this.reviewRepository.addReview(newReview);

        newReview.setReviewId(newId);
        this.user.addReview(newReview);
    }

    /**
     * Deletes all reviews associated with the User.
     */
    public void deleteAllUserReviews() throws PermissionsFailureException, NotLoggedInException {
        this.checkLoggedIn();

        for (Review review : this.reviews) {
            this.deleteReview(review);
        }
        this.user.clearReviews();
    }

    /**
     * Deletes a review from all three locations where it is stored.
     * @param review    the Review to be deleted
     */
    public void deleteReview(Review review) throws PermissionsFailureException, NotLoggedInException {
        this.checkLoggedIn();

        if(this.user.getUsername().equals(review.getReviewer())) {
            this.reviewRepository.deleteReview(review);
            this.user.deleteReview(review);
        }
        else {
            throw new PermissionsFailureException();
        }
    }

    public Review getReview(int reviewId) {
        return this.reviewRepository.getReview(reviewId);
    }

    private void checkLoggedIn() throws NotLoggedInException {
        if(this.user != null) {
            throw new NotLoggedInException();
        }
    }
}
