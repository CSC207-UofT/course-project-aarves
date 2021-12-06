package com.aarves.bluepages.usecase.interactors.location;

public class LocationOutputModel {
    private final int locationId;
    private final String locationName;
    private final LocationType locationType;
    private final float rating;

    public LocationOutputModel(int locationId, String locationName, LocationType locationType, float rating) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.locationType = locationType;
        this.rating = rating;
    }

    public int getLocationId() {
        return this.locationId;
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
