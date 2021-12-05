package com.aarves.bluepages.usecase.interactors.location;

public interface BookmarkInputBoundary {
    void addBookmark(int locationId);
    void removeBookmark(int locationId);

    void refreshBookmarks();
}
