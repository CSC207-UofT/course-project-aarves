package com.aarves.bluepages.usecase.interactors.location;

import com.aarves.bluepages.entities.Location;

import java.util.List;

public interface BookmarkDataBoundary {
    void updateBookmarks(String username, List<Location> bookmarks);
    List<Location> getUserBookmarks(String username);
}
