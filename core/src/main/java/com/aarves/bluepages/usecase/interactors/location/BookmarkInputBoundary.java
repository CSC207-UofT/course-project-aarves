package com.aarves.bluepages.usecase.interactors.location;

import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;

public interface BookmarkInputBoundary {
    void addBookmark(int locationId) throws NotLoggedInException;
    void removeBookmark(int locationId) throws NotLoggedInException;

    void refreshBookmarks();
}
