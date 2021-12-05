package com.aarves.bluepages.usecase.interactors.location;

import com.aarves.bluepages.entities.Location;

import java.util.List;

public interface BookmarkDataBoundary {
    void addBookmark(String username, int locationId, List<Location> bookmarks);
    void removeBookmark(String username, int locationId, List<Location> bookmarks);
    void updateBookmarks(String username, List<Location> bookmarks);
    List<Location> getUserBookmarks(String username);
}
