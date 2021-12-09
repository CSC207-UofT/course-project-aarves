package com.aarves.bluepages.usecase.interactors.location;

import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;

/**
 * Interface for inputting bookmark related information to use cases.
 */
public interface BookmarkInputBoundary extends LocationInputBoundary {

    /**
     * Adds a location to a user's bookmarks.
     * @param locationId the ID of the location to be bookmarked
     * @throws NotLoggedInException
     */
    void addBookmark(int locationId) throws NotLoggedInException;

    /**
     * Removes a location from a user's bookmarks.
     * @param locationId the ID of the location to be removed.
     * @throws NotLoggedInException
     */
    void removeBookmark(int locationId) throws NotLoggedInException;

    /**
     * Returns whether the location with locationID is bookmarked or not
     * @param locationId the ID of the location
     * @return true if the location is bookmarked, false otherwise
     */
    boolean isBookmarked(int locationId);

    /**
     * Gets the current state of the user's bookmarks.
     */
    void refreshBookmarks();
}
