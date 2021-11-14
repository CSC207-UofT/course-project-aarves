package com.aarves.bluepages.usecase.data;

public class ReviewDTO {
    private String reviewer;
    private int locationId;
    private int rating;
    private String review;

    public ReviewDTO(String reviewer, int locationId, int rating, String review) {
        this.reviewer = reviewer;
        this.locationId = locationId;
        this.rating = rating;
        this.review = review;
    }

    public String getReviewer() {
        return this.reviewer;
    }

    public int getLocationId() {
        return this.locationId;
    }

    public int getRating() {
        return this.rating;
    }

    public String getReview() {
        return this.review;
    }
}
