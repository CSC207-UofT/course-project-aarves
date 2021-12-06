package com.aarves.bluepages.adapter.controllers;

import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;
import com.aarves.bluepages.usecase.interactors.location.BookmarkInputBoundary;

public class BookmarkController {
    private final BookmarkInputBoundary bookmarkInput;

    public BookmarkController(BookmarkInputBoundary bookmarkInput) {
        this.bookmarkInput = bookmarkInput;
    }

    public void addBookmark(int locationID) throws NotLoggedInException {
        this.bookmarkInput.addBookmark(locationID);
    }


}
