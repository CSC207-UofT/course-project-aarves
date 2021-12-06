package com.aarves.bluepages.usecase.interactors.review;

import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;

public interface ReviewInputBoundary {
    void createReview(int locationId, int rating, String reviewBody) throws NotLoggedInException;
    void createReview(int locationId, int rating) throws NotLoggedInException;

    void loadReviews();
    void refreshReviews();
}
