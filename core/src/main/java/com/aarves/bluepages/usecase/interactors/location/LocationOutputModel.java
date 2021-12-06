package com.aarves.bluepages.usecase.interactors.location;

public class LocationOutputModel {
    private final String locationName;
    private final LocationType locationType;
    private final float rating;

    public LocationOutputModel(String locationName, LocationType locationType, float rating) {
        this.locationName = locationName;
        this.locationType = locationType;
        this.rating = rating;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public LocationType getLocationType() {
        return this.locationType;
    }

    public float getRating() {
        return this.rating;
    }
}
