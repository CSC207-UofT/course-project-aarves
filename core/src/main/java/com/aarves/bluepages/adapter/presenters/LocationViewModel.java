package com.aarves.bluepages.adapter.presenters;

import com.aarves.bluepages.usecase.data.location.LocationType;

public class LocationViewModel {
    private final String locationName;
    private final LocationType locationType;

    public LocationViewModel(String locationName, LocationType locationType) {
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
