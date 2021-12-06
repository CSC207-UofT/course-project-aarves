package com.aarves.bluepages.usecase.interactors.location;

import com.aarves.bluepages.entities.FoodLocation;
import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.entities.StudyLocation;

import java.util.ArrayList;
import java.util.List;

public class LocationOutputMapper {
    public static List<LocationOutputModel> mapToOutputModels(List<Location> locations) {
        List<LocationOutputModel> locationOutputModels = new ArrayList<>();
        for(Location location : locations) {
            locationOutputModels.add(LocationOutputMapper.mapToOutputModel(location));
        }

        return locationOutputModels;
    }

    public static LocationOutputModel mapToOutputModel(Location location) {
        if(location instanceof FoodLocation) {
            return new LocationOutputModel(
                    location.getName(),
                    LocationType.FOOD
            );
        }
        else if(location instanceof StudyLocation) {
            return new LocationOutputModel(
                    location.getName(),
                    LocationType.STUDY
            );
        }
        else {
            throw new IllegalStateException("Unexpected class: " + location.getClass().getName());
        }
    }
}
