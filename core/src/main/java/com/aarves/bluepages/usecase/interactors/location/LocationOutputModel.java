package com.aarves.bluepages.usecase.interactors.location;

public class LocationOutputModel {
    private final String locationName;
    private final LocationType locationType;

    public LocationOutputModel(String locationName, LocationType locationType) {
        this.locationName = locationName;
        this.locationType = locationType;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public LocationType getLocationType() {
        return this.locationType;
    }
}
