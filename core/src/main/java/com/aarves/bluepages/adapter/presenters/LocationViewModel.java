package com.aarves.bluepages.adapter.presenters;

public class LocationViewModel {
    private final int locationId;
    private final String locationName;
    private final String locationType;
    private final int rating;

    private boolean bookmarked;

    public LocationViewModel(int locationId, String locationName, String locationType, int rating, boolean bookmarked) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.locationType = locationType;
        this.rating = rating;

        this.bookmarked = bookmarked;
    }

    public int getLocationId() {
        return this.locationId;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public String getLocationType() {
        return this.locationType;
    }

    public int getRating() {
        return this.rating;
    }

    public boolean isBookmarked() {
        return this.bookmarked;
    }

    public void toggleBookmarked() {
        this.bookmarked = !this.bookmarked;
    }
}
