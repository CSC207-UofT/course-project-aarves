package com.aarves.bluepages.usecase.data.location;

import com.aarves.bluepages.entities.FoodLocation;
import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.entities.StudyLocation;
import com.aarves.bluepages.usecase.interactors.location.LocationType;

/**
 * A helper class for mapping between location entities and data transfer objects.
 */
public class LocationDataMapper {
    /**
     * Converts location entity into location data transfer object.
     * @param location the location entity to be converted
     * @return the converted location data transfer object
     */
    public static LocationDTO mapToDTO(Location location) {
        // Sets type based on which subclass of location the entity is
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
            // There should be no other type of location entities
            throw new IllegalStateException("Unexpected class: " + location.getClass().getName());
        }
    }

    /**
     * Converts location data transfer object to location entity.
     * @param locationDTO the location transfer object to be converted
     * @param locationId the ID of the location to be created
     * @return the converted location entity
     */
    public static Location locationFactory(LocationDTO locationDTO, int locationId) {
        // Creates certain subclasses based on what type of location it is, using the simple factory design pattern
        switch(locationDTO.getType()) {
            case FOOD:
                return new FoodLocation(
                        locationId,
                        locationDTO.getName(),
                        locationDTO.getCoordinates()
                );
            case STUDY:
                return new StudyLocation(
                        locationId,
                        locationDTO.getName(),
                        locationDTO.getCoordinates()
                );
            default:
                // There should be no other type of locations
                throw new IllegalStateException("Unexpected value: " + locationDTO.getType());
        }
    }
}
