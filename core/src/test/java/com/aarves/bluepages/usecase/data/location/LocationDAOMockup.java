package com.aarves.bluepages.usecase.data.location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationDAOMockup implements LocationDAO {

    private int id = 0;
    private final Map<Integer, LocationDTO> dtoMap = new HashMap<>();
    private List<Integer> bookmark = new ArrayList<>();

    public int addLocation(LocationDTO locationDTO) {

        dtoMap.put(this.id, locationDTO);
        int currentId = this.id;
        this.id += 1;
        return currentId;
    }
    public void deleteLocation(int locationId) {
        dtoMap.remove(locationId);
    }

    public void updateBookmarks(String username, List<Integer> bookmarkIds) {

        List<Integer> idList = new ArrayList<>();

        for (int i: bookmarkIds) {
            if (i == this.id) {
                idList.add(i);
            }
        }
        this.bookmark = idList;
    }

    public LocationDTO getLocationData(int locationId) {
        return dtoMap.get(locationId);
    }

    public Map<Integer, LocationDTO> getBookmarksData(String username) {
        return this.dtoMap;
    }


    public Map<List<Long>, Integer> getCoordinatesMap() {

        List<Long> longList = new ArrayList<>();

        for (LocationDTO ld: dtoMap.values()) {
            double[] longCo = ld.getCoordinates();

            //TODO: add longitude to longList and then create map
        }
        // this is a place holder to fix errors
        return null;
    }
}
