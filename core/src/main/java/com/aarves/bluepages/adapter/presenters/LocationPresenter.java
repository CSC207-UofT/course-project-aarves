package com.aarves.bluepages.adapter.presenters;

import com.aarves.bluepages.usecase.interactors.location.LocationOutputBoundary;
import com.aarves.bluepages.usecase.interactors.location.LocationOutputModel;

import java.util.List;

public class LocationPresenter implements LocationOutputBoundary {
    private LocationView locationView;

    /**
     * Converts the list of LocationOutputModels to LocationViewModels, and then presents them via LocationView
     * @param locations the list of LocationOutputModels of locations
     * @param bookmarked whether each location is bookmarked/not bookmarked
     */
    @Override
    public void presentLocations(List<LocationOutputModel> locations, List<Boolean> bookmarked) {
        if(this.locationView != null) {
            List<LocationViewModel> locationViewModels = LocationModelMapper.mapToViewModels(locations, bookmarked);
            this.locationView.displayLocations(locationViewModels);
        }
    }

    /**
     * Sets the LocationView interface for this LocationPresenter.
     * @param locationView the LocationViewInterface to present.
     */
    public void setLocationView(LocationView locationView) {
        this.locationView = locationView;
    }
}
