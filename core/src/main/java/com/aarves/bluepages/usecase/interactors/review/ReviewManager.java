package com.aarves.bluepages.usecase.interactors.review;

import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;
import com.aarves.bluepages.usecase.exceptions.PermissionsFailureException;
import com.aarves.bluepages.entities.Review;
import com.aarves.bluepages.entities.User;
import com.aarves.bluepages.usecase.interactors.Observer;

import java.util.ArrayList;
import java.util.List;

public class ReviewManager implements ReviewAccountInputBoundary, ReviewLocationInputBoundary, Observer<User> {
    private final ReviewOutputBoundary reviewOutput;
    private final ReviewRepository reviewRepository;

    private List<Review> reviews;
    private String username;

    public ReviewManager(ReviewRepository reviewRepository, ReviewOutputBoundary reviewOutput) {
        this.reviewRepository = reviewRepository;
        this.reviewOutput = reviewOutput;

        this.reviews = new ArrayList<>();
        this.username = "";
    }

    /**
     * Creates a new review and adds it to the reviewHashMap
     *
     * @param locationId    Integer representing the ID of the Location this Review is addressed towards.
     * @param rating        Integer rating (out of 5) for location as per the User's opinion.
     * @param reviewBody    String information about the User's opinions.
     */
    @Override
    public void createReview(int locationId, int rating, String reviewBody) throws NotLoggedInException {
        this.checkLoggedIn();

        Review review = new Review(this.username, locationId, rating);
        review.setBody(reviewBody);

        Review newReview = this.reviewRepository.addReview(review);
        if(newReview != null && !this.reviews.contains(newReview)) {
            this.reviews.add(newReview);
            this.reviewOutput.createResult(true);
        }
        else {
            this.reviewOutput.createResult(false);
        }
    }

    /**
     * Creates a new review and adds it to the reviewHashMap.
     *
     * @param locationId    Integer representing the ID of the Location this Review is addressed towards.
     * @param rating        Integer rating (out of 5) for location as per the User's opinion.
     */
    @Override
    public void createReview(int locationId, int rating) throws NotLoggedInException {
        this.checkLoggedIn();

        Review review = new Review(this.username, locationId, rating);
        Review newReview = this.reviewRepository.addReview(review);

        if(newReview != null && !this.reviews.contains(newReview)) {
            this.reviews.add(newReview);
            this.reviewOutput.createResult(true);
        }
        else {
            this.reviewOutput.createResult(false);
        }
    }

    @Override
    public void loadUserReviews() {
        List<ReviewOutputModel> reviewOutputModels = ReviewOutputMapper.mapToOutputModels(this.reviews);
        this.reviewOutput.presentReviews(reviewOutputModels);
    }

    @Override
    public void refreshUserReviews() {
        this.reviews.clear();

        List<Review> reviews = this.reviewRepository.getReviewsByUser(this.username);
        this.reviews.addAll(reviews);
    }

    @Override
    public float getLocationRating(int locationId) {
        List<Review> reviews = this.reviewRepository.getReviewsByLocation(locationId);
        int sum = 0;
        for(Review review : reviews) {
            sum += review.getRating();
        }

        if(!reviews.isEmpty()) {
            return (float) sum / reviews.size();
        }
        else {
            return 0;
        }
    }

    @Override
    public void loadLocationReviews(int locationId) {
        List<Review> reviews = this.reviewRepository.getReviewsByLocation(locationId);
        List<ReviewOutputModel> reviewOutputModels = ReviewOutputMapper.mapToOutputModels(reviews);
        this.reviewOutput.presentReviews(reviewOutputModels);
    }

    @Override
    public void update(User arg) {
        if(arg != null) {
            this.reviews = arg.getReviews();
            this.username = arg.getUsername();

            this.refreshUserReviews();
        }
        else {
            this.reviews = new ArrayList<>();
            this.username = "";
        }
        this.loadUserReviews();
    }

    /**
     * Deletes all reviews associated with the User.
     */
    public void deleteAllUserReviews() throws PermissionsFailureException, NotLoggedInException {
        this.checkLoggedIn();

        for (Review review : this.reviews) {
            this.deleteReview(review);
        }
        this.reviews.clear();
    }

    /**
     * Deletes a review from all three locations where it is stored.
     * @param review    the Review to be deleted
     */
    public void deleteReview(Review review) throws PermissionsFailureException, NotLoggedInException {
        this.checkLoggedIn();

        if(this.username.equals(review.getReviewer())) {
            this.reviewRepository.deleteReview(review);
            this.reviews.remove(review);
        }
        else {
            throw new PermissionsFailureException();
        }
    }

    public Review getReview(int reviewId) {
        return this.reviewRepository.getReview(reviewId);
    }

    private void checkLoggedIn() throws NotLoggedInException {
        if(this.username.isEmpty()) {
            throw new NotLoggedInException();
        }
    }
}
