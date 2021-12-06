package com.aarves.bluepages.usecase.interactors.location;

import com.aarves.bluepages.entities.FoodLocation;
import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.entities.StudyLocation;

import java.util.ArrayList;
import java.util.List;

public class LocationOutputMapper {
    public static List<LocationOutputModel> mapToOutputModels(List<Location> locations, List<Float> ratings) {
        List<LocationOutputModel> locationOutputModels = new ArrayList<>();
        for(int i = 0; i < locations.size(); i++) {
            locationOutputModels.add(LocationOutputMapper.mapToOutputModel(locations.get(i), ratings.get(i)));
        }

        return locationOutputModels;
    }

    public static LocationOutputModel mapToOutputModel(Location location, float rating) {
        if(location instanceof FoodLocation) {
            return new LocationOutputModel(
                    location.getLocationId(),
                    location.getName(),
                    LocationType.FOOD,
                    rating
            );
        }
        else if(location instanceof StudyLocation) {
            return new LocationOutputModel(
                    location.getLocationId(),
                    location.getName(),
                    LocationType.STUDY,
                    rating
            );
        }
        else {
            throw new IllegalStateException("Unexpected class: " + location.getClass().getName());
        }
    }
}
