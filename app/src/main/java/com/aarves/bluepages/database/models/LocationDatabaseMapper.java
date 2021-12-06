package com.aarves.bluepages.database.models;

import com.aarves.bluepages.usecase.data.location.LocationDTO;
import com.aarves.bluepages.usecase.interactors.location.LocationType;

public class LocationDatabaseMapper {
    public static LocationDataEntity mapToDataEntity(LocationDTO locationDTO) {
        double[] coordinates = locationDTO.getCoordinates();
        return new LocationDataEntity(
                locationDTO.getName(),
                coordinates[0],
                coordinates[1],
                locationDTO.getType().name()
        );
    }

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
