package com.aarves.bluepages.usecase.interactors.location;

import com.aarves.bluepages.entities.Location;

import java.util.List;
import java.util.Map;

public interface LocationDataBoundary {
    int addLocation(Location location);
    void deleteLocation(int locationId);

    Location getLocation(int locationId);
    Map<List<Long>, Integer> getCoordinatesMap();
}
