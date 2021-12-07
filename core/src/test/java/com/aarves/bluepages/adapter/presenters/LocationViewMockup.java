package com.aarves.bluepages.adapter.presenters;

import java.util.List;

public class LocationViewMockup implements LocationView {

    private boolean locationDisplayed;

    public void displayLocations(List<LocationViewModel> locations) {
        this.locationDisplayed = true;
    }
    public boolean isLocationDisplayed() {
        return this.locationDisplayed;
    }
}
