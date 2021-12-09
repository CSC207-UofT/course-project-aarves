package com.aarves.bluepages.usecase.interactors.location;

import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;

/**
 * Interface for inputting bookmark related information to use cases.
 */
public interface BookmarkInputBoundary extends LocationInputBoundary {
    void addBookmark(int locationId) throws NotLoggedInException;
    void removeBookmark(int locationId) throws NotLoggedInException;
    boolean isBookmarked(int locationId);

    void refreshBookmarks();
}
