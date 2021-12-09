package com.aarves.bluepages.usecase.interactors.review;

import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;

/**
 * An interface for inputting review related information for a given account to use cases.
 */
public interface ReviewAccountInputBoundary {
    /**
     * Creates a review.
     * @param locationId the ID of the location of the review
     * @param rating the rating of the review
     * @param reviewBody the text body of the review
     * @throws NotLoggedInException
     */
    void createReview(int locationId, int rating, String reviewBody) throws NotLoggedInException;

    /**
     * Creates a review.
     * @param locationId the ID of the location of the review
     * @param rating the rating of the review
     * @throws NotLoggedInException
     */
    void createReview(int locationId, int rating) throws NotLoggedInException;

    /**
     * Loads all of the user's reviews to present.
     */
    void loadUserReviews();

    /**
     * Refreshes the user's reviews to ensure they have the latest information.
     */
    void refreshUserReviews();

    /**
     * Loads all of a location's reviews to present
     * @param locationId the ID of the location to load the reviews for
     */
    void loadLocationReviews(int locationId);
}
