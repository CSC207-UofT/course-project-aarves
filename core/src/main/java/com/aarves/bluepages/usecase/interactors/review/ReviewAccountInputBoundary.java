package com.aarves.bluepages.usecase.interactors.review;

import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;

public interface ReviewAccountInputBoundary {
    void createReview(int locationId, int rating, String reviewBody) throws NotLoggedInException;
    void createReview(int locationId, int rating) throws NotLoggedInException;

    void loadUserReviews();
    void refreshUserReviews();
}
