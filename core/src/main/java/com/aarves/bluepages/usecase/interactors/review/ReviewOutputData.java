package com.aarves.bluepages.usecase.interactors.review;

public class ReviewOutputData {
    private final String reviewer;
    private final int rating;
    private final String body;

    public ReviewOutputData(String reviewer, int rating, String body) {
        this.reviewer = reviewer;
        this.rating = rating;
        this.body = body;
    }

    public String getReviewer() {
        return this.reviewer;
    }

    public int getRating() {
        return this.rating;
    }

    public String getBody() {
        return this.body;
    }
}
