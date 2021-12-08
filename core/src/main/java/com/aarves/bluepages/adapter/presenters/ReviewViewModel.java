package com.aarves.bluepages.adapter.presenters;

public class ReviewViewModel {
    private final String reviewer;
    private final int rating;
    private final String body;

    /**
     * Creates a ReviewViewModel, containing the review's writer, rating and text of the review.
     * @param reviewer the reviewer for the review
     * @param rating the rating of the review
     * @param body the text body of the review
     */
    public ReviewViewModel(String reviewer, int rating, String body) {
        this.reviewer = reviewer;
        this.rating = rating;
        this.body = body;
    }

    /**
     * Gets the user who wrote the review.
     * @return the username of the user who wrote the review.
     */
    public String getReviewer() {
        return this.reviewer;
    }

    /**
     * Gets the rating of the review given by the user.
     * @return the rating of the review.
     */
    public int getRating() {
        return this.rating;
    }

    /**
     * Gets the text body of the review given by the user.
     * @return the text body of the review.
     */
    public String getBody() {
        return this.body;
    }

    /**
     * Returns whether the text body of the review is empty or not.
     * @return whether there is text in the review.
     */
    public boolean showBody() {
        return !this.body.isEmpty();
    }
}
