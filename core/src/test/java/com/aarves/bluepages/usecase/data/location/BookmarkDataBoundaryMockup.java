package com.aarves.bluepages.usecase.data.location;

import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.usecase.interactors.location.BookmarkDataBoundary;

import java.util.ArrayList;
import java.util.List;

public class BookmarkDataBoundaryMockup implements BookmarkDataBoundary {

    List<Location> locations = new ArrayList<>();
    List<Integer> locationBookmarks = new ArrayList<>();

    public void addBookmark(String username, int locationId, List<Location> bookmarks) {

        List<Integer> bookmarkIds = new ArrayList<>();

        for (Location l: bookmarks) {
            for (Location l2: locations) {
                if (l2.getLocationId() == locationId) {
                    bookmarkIds.add(l.getLocationId());
                }
            }
        }
        locationBookmarks = bookmarkIds;
    }

    public void removeBookmark(String username, int locationId, List<Location> bookmarks) {

        // Not sure if this works

        locations.removeIf(l -> l.getLocationId() == locationId);

    }

    public void updateBookmarks(String username, List<Location> bookmarks) {


    }
    public List<Location> getUserBookmarks(String username) {

        // stopping intelliJ warning, still have to implement this
        return null;

    }
}
