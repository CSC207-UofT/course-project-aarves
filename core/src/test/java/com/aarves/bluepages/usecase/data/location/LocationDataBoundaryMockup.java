package com.aarves.bluepages.usecase.data.location;

import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.usecase.interactors.location.LocationDataBoundary;

import java.util.List;
import java.util.Map;

public class LocationDataBoundaryMockup implements LocationDataBoundary {

    List<Location> locationList;

    @Override
    public Location addLocation(Location location) {
        return null;
    }

    @Override
    public void deleteLocation(int locationId) {

    }

    @Override
    public Location getLocation(int locationId) {
        return null;
    }

    @Override
    public Map<List<Long>, Integer> getCoordinatesMap() {
        return null;
    }
}
