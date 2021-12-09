package com.aarves.bluepages.usecase.data.review;

/**
 * Data transfer object for reviews data.
 */
public class ReviewDTO {
    private final String reviewer;
    private final int locationId;
    private final int rating;
    private final String body;

    /**
     * Constructs review data transfer object with given reviewer username, location ID, rating, and body.
     * @param reviewer the username of the reviewer
     * @param locationId the ID of the location
     * @param rating the rating of the review
     * @param body the body of the review
     */
    public ReviewDTO(String reviewer, int locationId, int rating, String body) {
        this.reviewer = reviewer;
        this.locationId = locationId;
        this.rating = rating;
        this.body = body;
    }

    /**
     * Returns the username of the reviewer for the review.
     * @return the username of the reviewer
     */
    public String getReviewer() {
        return this.reviewer;
    }

    /**
     * Returns the ID of the location for the review.
     * @return the ID of the location
     */
    public int getLocationId() {
        return this.locationId;
    }

    /**
     * Returns the rating of the review.
     * @return the rating of the review
     */
    public int getRating() {
        return this.rating;
    }

    /**
     * Returns the body of the review.
     * @return the body of the review
     */
    public String getBody() {
        return this.body;
    }
}
