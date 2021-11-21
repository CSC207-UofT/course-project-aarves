package com.aarves.bluepages.usecase.data;

public class ReviewDTO {
    private final String reviewer;
    private final int locationId;
    private final int rating;
    private final String body;

    public ReviewDTO(String reviewer, int locationId, int rating, String body) {
        this.reviewer = reviewer;
        this.locationId = locationId;
        this.rating = rating;
        this.body = body;
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

    public String getBody() {
        return this.body;
    }
}
