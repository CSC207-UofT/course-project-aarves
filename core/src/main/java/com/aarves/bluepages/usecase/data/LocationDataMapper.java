package com.aarves.bluepages.usecase.data;

import com.aarves.bluepages.entities.FoodLocation;
import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.entities.StudyLocation;

public class LocationDataMapper {
    public static LocationDTO mapToDTO(Location location) {
        if(location instanceof FoodLocation) {
            return new LocationDTO(
                    location.getName(),
                    location.getCoordinates(),
                    LocationType.FOOD
            );
        }
        else if(location instanceof StudyLocation) {
            return new LocationDTO(
                    location.getName(),
                    location.getCoordinates(),
                    LocationType.STUDY
            );
        }
        else {
            throw new IllegalStateException("Unexpected class: " + location.getClass().getName());
        }
    }

    public static Location locationFactory(LocationDTO locationDTO) {
        switch(locationDTO.getType()) {
            case FOOD:
                return new FoodLocation(
                        locationDTO.getName(),
                        locationDTO.getCoordinates()
                );
            case STUDY:
                return new StudyLocation(
                        locationDTO.getName(),
                        locationDTO.getCoordinates()
                );
            default:
                throw new IllegalStateException("Unexpected value: " + locationDTO.getType());
        }
    }
}
