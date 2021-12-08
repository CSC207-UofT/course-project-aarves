package com.aarves.bluepages.usecase.interactors.location;

import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.usecase.interactors.location.LocationDataBoundary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationDataBoundaryMockup implements LocationDataBoundary {

    List<Location> locationList;

    public LocationDataBoundaryMockup(List<Location> locations){
        this.locationList = locations;
    }

    @Override
    public Location addLocation(Location location) {
        locationList.add(location);
        // TODO: correct return statement??
        return location;
    }

    @Override
    public void deleteLocation(int locationId) {
        Location toDelete = null;
        for (Location l:locationList){
            Integer id = l.getLocationId();
            if (id.equals(locationId)){
                toDelete = l;
            }
        }
        locationList.remove(toDelete);
    }

    @Override
    public Location getLocation(int locationId) {
        for (Location l:locationList){
            Integer id = l.getLocationId();
            if (id.equals(locationId)){
                return l;
            }
        }
        return null;
    }

    @Override
    public Map<List<Long>, Integer> getCoordinatesMap() {
        // TODO: finish implementing
        Map<List<Long>, Integer> coordinatesMap = new HashMap<>();
        return coordinatesMap;
    }
}
