package com.aarves.bluepages.usecase.interactors.review;

import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;

public interface ReviewInputBoundary {
    void loadReviews();
    void createReview(int locationId, int rating, String reviewBody) throws NotLoggedInException;
    void refreshReviews();
}
