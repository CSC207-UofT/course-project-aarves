package com.aarves.bluepages.usecase.data.location;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LocationDAOMockup implements LocationDAO {

    List<LocationDTO> locations = new ArrayList<>();

    public int addLocation(LocationDTO locationDTO) {

        locations.add(locationDTO);
        return locations.indexOf(locationDTO);

    }
    public void deleteLocation(int locationId) {
        for (LocationDTO l: locations) {
            if (locations.indexOf(l) == locationId) {
                locations.remove(l);
            }
        }
    }

    public void updateBookmarks(String username, List<Integer> bookmarkIds) {

    }

    public LocationDTO getLocationData(int locationId) {
        for (LocationDTO l: locations) {
            if (locations.indexOf(l) == locationId) {
                return l;
            }
        }
        return null;
    }


    public Map<Integer, LocationDTO> getBookmarksData(String username) {
        return null;
    }

    public Map<List<Long>, Integer> getCoordinatesMap() {
        return null;
    }
}
