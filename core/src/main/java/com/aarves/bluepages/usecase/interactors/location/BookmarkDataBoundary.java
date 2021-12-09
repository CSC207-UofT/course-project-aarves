package com.aarves.bluepages.usecase.interactors.location;

import com.aarves.bluepages.entities.Location;

import java.util.List;

/**
 * Interface which allows bookmark use case interactors to access to bookmark data.
 */
public interface BookmarkDataBoundary {
    /**
     * Adds new bookmark to the bookmark list of given user.
     * @param username the username of the user
     * @param locationId the ID of the location to be bookmarked
     * @param bookmarks the list of the user's current bookmarks
     */
    void addBookmark(String username, int locationId, List<Location> bookmarks);

    /**
     * Removes bookmark from the bookmark list of given user.
     * @param username the username of the user
     * @param locationId the ID of the location to be unbookmarked
     * @param bookmarks the list of the user's current bookmarks
     */
    void removeBookmark(String username, int locationId, List<Location> bookmarks);

    /**
     * Updates bookmarks list of given user in data source.
     * @param username the username of the user
     * @param bookmarks the list of bookmarks to be updated to
     */
    void updateBookmarks(String username, List<Location> bookmarks);

    /**
     * Retrieves all bookmarked location entities for given user.
     * @param username the username of the user
     * @return a list of bookmarked location entities
     */
    List<Location> getUserBookmarks(String username);
}
