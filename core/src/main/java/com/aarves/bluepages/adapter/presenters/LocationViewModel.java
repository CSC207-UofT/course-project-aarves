package com.aarves.bluepages.adapter.presenters;

public class LocationViewModel {
    private final String locationName;
    private final String locationType;

    public LocationViewModel(String locationName, String locationType) {
        this.locationName = locationName;
        this.locationType = locationType;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public String getLocationType() {
        return this.locationType;
    }
}
