package com.aarves.bluepages.database;

import com.aarves.bluepages.database.access.BookmarkDatabaseDAO;
import com.aarves.bluepages.database.access.LocationDatabaseDAO;
import com.aarves.bluepages.database.models.LocationBasicDataTuple;
import com.aarves.bluepages.database.models.LocationDataEntity;
import com.aarves.bluepages.database.models.LocationDatabaseMapper;

import com.aarves.bluepages.usecase.data.location.LocationDAO;
import com.aarves.bluepages.usecase.data.location.LocationDTO;

import java.util.*;

public class LocationDAOAdapter implements LocationDAO {
    private static final int PRECISION = 14;

    private final BookmarkDatabaseDAO bookmarkDatabaseDAO;
    private final LocationDatabaseDAO locationDatabaseDAO;

    public LocationDAOAdapter(BookmarkDatabaseDAO bookmarkDatabaseDAO, LocationDatabaseDAO locationDatabaseDAO) {
        this.bookmarkDatabaseDAO = bookmarkDatabaseDAO;
        this.locationDatabaseDAO = locationDatabaseDAO;
    }

    @Override
    public int addLocation(LocationDTO locationDTO) {
        LocationDataEntity locationDataEntity = LocationDatabaseMapper.mapToDataEntity(locationDTO);
        return (int) this.locationDatabaseDAO.insert(locationDataEntity);
    }

    @Override
    public void deleteLocation(int locationId) {
        LocationDataEntity locationDataEntity = this.locationDatabaseDAO.getByID(locationId);
        this.locationDatabaseDAO.delete(locationDataEntity);
    }

    @Override
    public void updateBookmarks(String username, List<Integer> bookmarkIds) {
        this.bookmarkDatabaseDAO.updateBookmarks(username, bookmarkIds);
    }

    @Override
    public LocationDTO getLocationData(int locationId) {
        LocationDataEntity locationDataEntity = this.locationDatabaseDAO.getByID(locationId);

        if(locationDataEntity != null) {
            return LocationDatabaseMapper.mapToDTO(locationDataEntity);
        }
        else {
            return null;
        }
    }

    @Override
    public Map<Integer, LocationDTO> getBookmarksData(String username) {
        List<Integer> bookmarkIds = this.bookmarkDatabaseDAO.getBookmarks(username).bookmarks;
        Map<Integer, LocationDTO> bookmarksData = new HashMap<>();

        for(int bookmarkId : bookmarkIds) {
            LocationDTO bookmarkData = this.getLocationData(bookmarkId);

            if(bookmarkData != null) {
                bookmarksData.put(bookmarkId, bookmarkData);
            }
        }

        return bookmarksData;
    }


    @Override
    public Map<List<Long>, Integer> getCoordinatesMap() {
        Map<List<Long>, Integer> coordinatesMap = new HashMap<>();
        List<LocationBasicDataTuple> basicDataTuple = this.locationDatabaseDAO.getAllBasicData();

        for(LocationBasicDataTuple basicData : basicDataTuple) {
            List<Long> coordinates = Arrays.asList(this.doubleToLong(basicData.longitude), this.doubleToLong(basicData.latitude));
            coordinatesMap.put(coordinates, basicData.locationId);
        }

        return coordinatesMap;
    }

    private long doubleToLong(double num) {
        return (long) (num * Math.pow(10, LocationDAOAdapter.PRECISION));
    }
}
