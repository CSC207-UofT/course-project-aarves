package com.aarves.bluepages.adapter.controllers;

import com.aarves.bluepages.entities.Review;
import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;
import com.aarves.bluepages.usecase.interactors.review.ReviewAccountInputBoundary;
import com.aarves.bluepages.usecase.interactors.review.ReviewLocationInputBoundary;

import java.util.ArrayList;
import java.util.List;

public class ReviewInputMockup implements ReviewAccountInputBoundary, ReviewLocationInputBoundary {

    private final List<Review> reviews;
    private final String username;
    private boolean userLoaded;
    private boolean refreshed;
    private boolean locationLoaded;


    public ReviewInputMockup(String user) {
        this.username = user;
        this.reviews = new ArrayList<>();
    }

    public void createReview(int locationId, int rating, String reviewBody) throws NotLoggedInException {
        Review review = new Review(this.username, locationId, rating);
        review.setBody(reviewBody);
        reviews.add(review);
    }
    public void createReview(int locationId, int rating) throws NotLoggedInException {
        Review review = new Review(this.username, locationId, rating);
        reviews.add(review);
    }

    public void loadUserReviews() {
        this.userLoaded = true;
    }

    public void refreshUserReviews() {
        this.refreshed = true;
    }

    public void loadLocationReviews(int locationId) {
        this.locationLoaded = true;
    }

    public float getLocationRating(int locationId) {
        int reviewCounter = 0;
        float reviewRatingCounter = 0;

        if (reviews.isEmpty()) {
            return 0;
        }
        else {
            for (Review r: reviews) {
                if (r.getLocationId() == locationId) {
                    reviewCounter += 1;
                    reviewRatingCounter += r.getRating();
                }
            }
            return (reviewRatingCounter / reviewCounter);
        }
    }

    public boolean isUserLoaded() {
        return userLoaded;
    }

    public boolean isRefreshed() {
        return refreshed;
    }

    public boolean isLocationLoaded() {
        return locationLoaded;
    }

    public List<Review> getReviews(){
        return this.reviews;
    }
}
