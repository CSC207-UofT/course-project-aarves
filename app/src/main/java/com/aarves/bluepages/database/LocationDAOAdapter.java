package com.aarves.bluepages.database;

import com.aarves.bluepages.database.access.LocationDatabaseDAO;
import com.aarves.bluepages.database.models.LocationDataEntity;
import com.aarves.bluepages.database.models.LocationDatabaseMapper;
import com.aarves.bluepages.usecase.data.LocationDAO;
import com.aarves.bluepages.usecase.data.LocationDTO;

public class LocationDAOAdapter implements LocationDAO {
    private final LocationDatabaseDAO locationDatabaseDAO;

    public LocationDAOAdapter(LocationDatabaseDAO locationDatabaseDAO) {
        this.locationDatabaseDAO = locationDatabaseDAO;
    }

    @Override
    public void addLocation(LocationDTO locationDTO) {
        LocationDataEntity locationDataEntity = LocationDatabaseMapper.mapToDataEntity(locationDTO);
        this.locationDatabaseDAO.insert(locationDataEntity);
    }

    @Override
    public void deleteLocation(int locationId) {
        LocationDataEntity locationDataEntity = this.locationDatabaseDAO.getByID(locationId);
        this.locationDatabaseDAO.delete(locationDataEntity);
    }

    @Override
    public LocationDTO getLocationData(int locationId) {
        LocationDataEntity locationDataEntity = this.locationDatabaseDAO.getByID(locationId);
        return LocationDatabaseMapper.mapToDTO(locationDataEntity);
    }
}
