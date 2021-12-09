package com.aarves.bluepages.usecase.interactors.review;

import com.aarves.bluepages.entities.Review;

import java.util.List;

/**
 * Interface for the review repository which allowed for a collection-like interface of review entities by
 * the repository pattern.
 */
public interface ReviewRepository {
    /**
     * Adds review to data source.
     * @param review the review entity to be added
     * @return the added review, along with its ID
     */
    Review addReview(Review review);

    /**
     * Deletes review from data source.
     * @param review the review entity to be deleted
     */
    void deleteReview(Review review);

    /**
     * Retrieves review entity with given ID.
     * @param reviewId the ID of the review to be retrieved
     * @return the retrieved review entity
     */
    Review getReview(int reviewId);

    /**
     * Retrieves all review entities for a given user.
     * @param username the username of the user
     * @return a list of review entities made by the user
     */
    List<Review> getReviewsByUser(String username);

    /**
     * Retrieves all review entities for a given location.
     * @param locationId the ID of the location
     * @return a list of review entities for the location
     */
    List<Review> getReviewsByLocation(int locationId);
}
