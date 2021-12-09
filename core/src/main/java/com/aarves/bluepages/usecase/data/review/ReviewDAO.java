package com.aarves.bluepages.usecase.data.review;

import java.util.Map;

/**
 * Interface for review data access object adapters.
 */
public interface ReviewDAO {
    /**
     * Adds a new review to the data source.
     * @param review the review data to be added
     * @return the ID of the added review
     */
    int addReviewData(ReviewDTO review);

    /**
     * Deletes review from data source.
     * @param reviewId the ID of the review to be deleted
     */
    void deleteReviewData(int reviewId);

    /**
     * Retrieves the data of the review with given ID.
     * @param reviewId the ID of the review to be retrieved
     * @return the data of the review with given ID, or null if review does not exist
     */
    ReviewDTO getReviewData(int reviewId);

    /**
     * Reviews data for all reviews for account with given username.
     * @param username the username of the account with reviews to be retrieved
     * @return a mapping of review IDs to review data
     */
    Map<Integer, ReviewDTO> getReviewDataByUser(String username);

    /**
     * Reviews data for all reviews for location with given ID.
     * @param locationId the ID of the location with reviews to be retrieved
     * @return a mapping of review IDs to review data
     */
    Map<Integer, ReviewDTO> getReviewDataByLocation(int locationId);
}
