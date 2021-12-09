package com.aarves.bluepages.usecase.interactors.review;

import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;

/**
 * An interface for inputting review related information for a given account to use cases.
 */
public interface ReviewAccountInputBoundary {
    void createReview(int locationId, int rating, String reviewBody) throws NotLoggedInException;
    void createReview(int locationId, int rating) throws NotLoggedInException;

    void loadUserReviews();
    void refreshUserReviews();
    void loadLocationReviews(int locationId);
}
