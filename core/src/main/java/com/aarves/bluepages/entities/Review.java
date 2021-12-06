package com.aarves.bluepages.entities;

public class Review {
    private static final int DEFAULT_ID = 0;

    private final int reviewId;
    private final String reviewer;
    private final int locationId;

    private String body;
    private int rating;

    /**
     * Constructs a new Review object which belongs to a given User regarding a specific Location, and an
     * Integer rating out of 5 based on the User's opinion.
     *
     * @param reviewId      Integer representing the Review's key in the database
     * @param reviewer      String representing the username of the User creating the Review.
     * @param locationId    Integer representing the ID of the Location this Review is addressed towards.
     * @param rating        Integer rating (out of 5) for location as per the User's opinion.
     */
    public Review(int reviewId, String reviewer, int locationId, int rating) {
        this.reviewer = reviewer;
        this.locationId = locationId;
        this.rating = rating;

        this.reviewId = reviewId;
    }

    /**
     * Constructs a new Review object which belongs to a given User regarding a specific Location, and an
     * Integer rating out of 5 based on the User's opinion.
     *
     * Note that any Review object with DEFAULT_ID should not be in the User's reviews List.
     *
     * @param reviewer      String representing the username of the User creating the Review.
     * @param locationId    Integer representing the ID of the Location this Review is addressed towards.
     * @param rating        Integer rating (out of 5) for location as per the User's opinion.
     */
    public Review(String reviewer, int locationId, int rating) {
        this.reviewer = reviewer;
        this.locationId = locationId;
        this.rating = rating;

        this.reviewId = Review.DEFAULT_ID;
    }

    /**
     * Return the ID associated with this Review.
     * @return  Integer representing the ID of the Review.
     */
    public int getReviewId() {
        return this.reviewId;
    }

    /**
     * Return the String representing the username of the User who left this Review.
     * @return  String representing the username of the User creating the Review.
     */
    public String getReviewer() {
        return this.reviewer;
    }

    /**
     * Return the Location for which this Review is meant for.
     * @return  Integer representing the ID of the Location who the Review is directed towards.
     */
    public int getLocationId() {
        return this.locationId;
    }

    /**
     * Return the rating associated with this Review.
     * @return  Integer representing the rating (out of 5).
     */
    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Return the written opinion associated with this Review (if applicable).
     * @return  String representing the opinion.
     */
    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return String.format(
                "User:\t%s\n Rating:\t%s/5\n Review:\t%s",
                this.reviewer,
                this.rating,
                this.body
        );
    }
}
