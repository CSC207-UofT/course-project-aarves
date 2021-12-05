package com.aarves.bluepages.usecase.data.location;

import java.util.List;
import java.util.Map;

public interface LocationDAO {
    int addLocation(LocationDTO locationDTO);
    void deleteLocation(int locationId);

    void updateBookmarks(String username, List<Integer> bookmarkIds);

    LocationDTO getLocationData(int locationId);
    Map<Integer, LocationDTO> getBookmarksData(String username);
    Map<List<Long>, Integer> getCoordinatesMap();
}
