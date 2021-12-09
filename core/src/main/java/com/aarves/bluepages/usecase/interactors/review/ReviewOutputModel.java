package com.aarves.bluepages.usecase.interactors.review;

public class ReviewOutputModel {
    private final String reviewer;
    private final int rating;
    private final String body;

    /**
     * Creates a ReviewOutputModel object
     * @param reviewer the username of the reviewer
     * @param rating the rating of the review
     * @param body the text body of the review
     */
    public ReviewOutputModel(String reviewer, int rating, String body) {
        this.reviewer = reviewer;
        this.rating = rating;
        this.body = body;
    }

    /**
     * Gets the username of the reviewer
     * @return the username of the reviewer
     */
    public String getReviewer() {
        return this.reviewer;
    }

    /**
     * Gets the rating of the review
     * @return the rating of the review
     */
    public int getRating() {
        return this.rating;
    }

    /**
     * Gets the text body of the review
     * @return the text body of the review
     */
    public String getBody() {
        return this.body;
    }
}
