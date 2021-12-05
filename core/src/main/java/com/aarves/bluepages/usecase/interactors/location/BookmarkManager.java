package com.aarves.bluepages.usecase.interactors.location;

import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;
import com.aarves.bluepages.usecase.interactors.Observer;
import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.entities.User;

import java.util.ArrayList;
import java.util.List;

public class BookmarkManager implements BookmarkInputBoundary, Observer<User> {
    private final BookmarkDataBoundary bookmarkData;

    private List<Location> bookmarks;
    private String username;

    public BookmarkManager(BookmarkDataBoundary bookmarkData) {
        this.bookmarkData = bookmarkData;

        this.bookmarks = new ArrayList<>();
        this.username = "";
    }

    @Override
    public void addBookmark(int locationId) {

    }

    @Override
    public void removeBookmark(int locationId) {

    }

    @Override
    public void refreshBookmarks() {
        this.bookmarks.clear();

        List<Location> bookmarks = this.bookmarkData.getUserBookmarks(this.username);
        this.bookmarks.addAll(bookmarks);
    }

    @Override
    public void update(User arg) {
        if(arg != null) {
            this.bookmarks = arg.getBookmarks();
            this.username = arg.getUsername();

            this.refreshBookmarks();
        }
        else {
            this.bookmarks = new ArrayList<>();
            this.username = "";
        }
    }

    private void checkLoggedIn() throws NotLoggedInException {
        if(this.username.isEmpty()) {
            throw new NotLoggedInException();
        }
    }
}
