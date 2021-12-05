package com.aarves.bluepages.usecase.data.location;

public interface LocationDAO {
    void addLocation(LocationDTO locationDTO);
    void deleteLocation(int locationId);

    LocationDTO getLocationData(int locationId);
}
