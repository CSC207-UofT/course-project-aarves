package com.aarves.bluepages.adapter.presenters;

import com.aarves.bluepages.usecase.interactors.location.LocationOutputModel;

import java.util.ArrayList;
import java.util.List;

public class LocationModelMapper {
    public static List<LocationViewModel> mapToViewModels(List<LocationOutputModel> locationOutputModels) {
        List<LocationViewModel> locationViewModels = new ArrayList<>();
        for(LocationOutputModel locationOutputModel : locationOutputModels) {
            locationViewModels.add(LocationModelMapper.mapToViewModel(locationOutputModel));
        }

        return locationViewModels;
    }

    public static LocationViewModel mapToViewModel(LocationOutputModel locationOutputModel) {
        return new LocationViewModel(
                locationOutputModel.getLocationName(),
                locationOutputModel.getLocationType().name(),
                Math.round(locationOutputModel.getRating())
        );
    }
}
