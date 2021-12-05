package com.aarves.bluepages.usecase.data;

import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.usecase.interactors.location.LocationDataBoundary;

public class LocationDataAccess implements LocationDataBoundary {
    private final LocationDAO locationDAO;

    public LocationDataAccess(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
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
}
