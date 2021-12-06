package com.aarves.bluepages.adapter.presenters;

import com.aarves.bluepages.usecase.interactors.location.LocationOutputBoundary;
import com.aarves.bluepages.usecase.interactors.location.LocationOutputModel;

import java.util.List;

public class LocationPresenter implements LocationOutputBoundary {
    private LocationView locationView;

    @Override
    public void presentLocations(List<LocationOutputModel> locations, List<Boolean> bookmarked) {
        if(this.locationView != null) {
            List<LocationViewModel> locationViewModels = LocationModelMapper.mapToViewModels(locations, bookmarked);
            this.locationView.displayLocations(locationViewModels);
        }
    }

    public void setLocationView(LocationView locationView) {
        this.locationView = locationView;
    }
}
