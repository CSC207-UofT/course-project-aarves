package com.aarves.bluepages.adapter.presenters;

public class LocationViewModel {
    private final String locationName;
    private final String locationType;
    private final int rating;

    public LocationViewModel(String locationName, String locationType, int rating) {
        this.locationName = locationName;
        this.locationType = locationType;
        this.rating = rating;
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
}
