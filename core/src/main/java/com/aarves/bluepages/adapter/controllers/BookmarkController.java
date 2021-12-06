package com.aarves.bluepages.adapter.controllers;

import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;
import com.aarves.bluepages.usecase.interactors.location.BookmarkInputBoundary;

public class BookmarkController {
    private final BookmarkInputBoundary bookmarkInput;

    public BookmarkController(BookmarkInputBoundary bookmarkInput) {
        this.bookmarkInput = bookmarkInput;
    }

    public void toggleBookmark(int locationID) {
        try {
            if(!this.bookmarkInput.isBookmarked(locationID)) {
                this.bookmarkInput.addBookmark(locationID);
            }
            else {
                this.bookmarkInput.removeBookmark(locationID);
            }
        }
        catch(NotLoggedInException exception) {
            exception.printStackTrace();
        }
    }
}
