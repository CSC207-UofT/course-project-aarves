package com.aarves.bluepages.usecase.data.location;

import java.util.List;
import java.util.Map;

public interface LocationDAO {
    int addLocation(LocationDTO locationDTO);
    void deleteLocation(int locationId);

    LocationDTO getLocationData(int locationId);
    Map<List<Long>, Integer> getCoordinatesMap();
}
