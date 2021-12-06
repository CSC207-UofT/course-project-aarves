package com.aarves.bluepages.adapter.presenters;

import com.aarves.bluepages.usecase.interactors.location.LocationOutputModel;

import java.util.ArrayList;
import java.util.List;

public class LocationModelMapper {
    public static List<LocationViewModel> mapToViewModels(List<LocationOutputModel> locationOutputModels, List<Boolean> bookmarked) {
        List<LocationViewModel> locationViewModels = new ArrayList<>();
        for(int i = 0; i < locationOutputModels.size(); i++) {
            locationViewModels.add(LocationModelMapper.mapToViewModel(locationOutputModels.get(i), bookmarked.get(i)));
        }

        return locationViewModels;
    }

    public static LocationViewModel mapToViewModel(LocationOutputModel locationOutputModel, boolean isBookmarked) {
        return new LocationViewModel(
                locationOutputModel.getLocationId(),
                locationOutputModel.getLocationName(),
                locationOutputModel.getLocationType().name(),
                Math.round(locationOutputModel.getRating()),
                isBookmarked
        );
    }
}
