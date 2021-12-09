package com.aarves.bluepages.adapter.presenters;

import com.aarves.bluepages.usecase.interactors.location.LocationOutputModel;

import java.util.ArrayList;
import java.util.List;

public class LocationModelMapper {
    /**
     * Maps the locations from LocationOutputModels to LocationViewModels, for presenting.
     * @param locationOutputModels the LocationOutputModels to be mapped.
     * @param bookmarked the bookmark status of each location (bookmarked/not bookmarked)
     * @return a list of LocationOutputModels mapped to LocationViewModels.
     */
    public static List<LocationViewModel> mapToViewModels(List<LocationOutputModel> locationOutputModels, List<Boolean> bookmarked) {
        List<LocationViewModel> locationViewModels = new ArrayList<>();
        for(int i = 0; i < locationOutputModels.size(); i++) {
            locationViewModels.add(LocationModelMapper.mapToViewModel(locationOutputModels.get(i), bookmarked.get(i)));
        }

        return locationViewModels;
    }

    /**
     * Maps a location from a LocationOutputModel to a LocationViewModel
     * @param locationOutputModel the LocationOutputModel for the location
     * @param isBookmarked whether the location is bookmarked or not
     * @return the mapped LocationViewModel
     */
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
