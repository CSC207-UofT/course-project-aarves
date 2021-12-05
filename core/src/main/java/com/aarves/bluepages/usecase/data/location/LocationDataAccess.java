package com.aarves.bluepages.usecase.data.location;

import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.usecase.interactors.location.LocationDataBoundary;

import java.util.List;
import java.util.Map;

public class LocationDataAccess implements LocationDataBoundary {
    private final LocationDAO locationDAO;

    public LocationDataAccess(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }

    @Override
    public int addLocation(Location location) {
        LocationDTO locationDTO = LocationDataMapper.mapToDTO(location);
        return this.locationDAO.addLocation(locationDTO);
    }

    @Override
    public void deleteLocation(int locationId) {
        this.locationDAO.deleteLocation(locationId);
    }

    @Override
    public Location getLocation(int locationId) {
        LocationDTO locationDTO = this.locationDAO.getLocationData(locationId);

        if(locationDTO != null) {
            return LocationDataMapper.locationFactory(locationDTO);
        }
        else {
            return null;
        }
    }

    @Override
    public Map<List<Long>, Integer> getCoordinatesMap() {
        return this.locationDAO.getCoordinatesMap();
    }
}