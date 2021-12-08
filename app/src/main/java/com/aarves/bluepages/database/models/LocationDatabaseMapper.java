package com.aarves.bluepages.database.models;

import com.aarves.bluepages.usecase.data.location.LocationDTO;
import com.aarves.bluepages.usecase.interactors.location.LocationType;

/**
 * A helper class for mapping between location data transfer objects and Room's data entities.
 */
public class LocationDatabaseMapper {
    /**
     * Converts given location data transfer object to a Room data entity.
     * @param locationDTO the location data transfer object to be converted
     * @return the converted Room location data entity
     */
    public static LocationDataEntity mapToDataEntity(LocationDTO locationDTO) {
        double[] coordinates = locationDTO.getCoordinates();
        return new LocationDataEntity(
                locationDTO.getName(),
                coordinates[0],
                coordinates[1],
                locationDTO.getType().name()
        );
    }

    /**
     * Converts the given Room location data entity to a data transfer object.
     * @param locationDataEntity the Room location data entity to be converted
     * @return the converted location data transfer object
     */
    public static LocationDTO mapToDTO(LocationDataEntity locationDataEntity) {
        double[] coordinates = {locationDataEntity.latitude, locationDataEntity.latitude};
        LocationType type = LocationType.valueOf(locationDataEntity.type);
        return new LocationDTO(
                locationDataEntity.name,
                coordinates,
                type
        );
    }
}
