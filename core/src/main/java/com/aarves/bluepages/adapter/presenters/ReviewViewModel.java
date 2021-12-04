package com.aarves.bluepages.adapter.presenters;

public class ReviewViewModel {
    private final String reviewer;
    private final int rating;
    private final String body;

    public ReviewViewModel(String reviewer, int rating, String body) {
        this.reviewer = reviewer;
        this.rating = rating;
        this.body = body;
    }

    public ReviewViewModel(String reviewer, int rating) {
        this.reviewer = reviewer;
        this.rating = rating;
        this.body = "";
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

    public boolean showBody() {
        return !this.body.isEmpty();
    }
}
