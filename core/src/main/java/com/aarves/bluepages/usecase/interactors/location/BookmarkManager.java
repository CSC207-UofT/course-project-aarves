package com.aarves.bluepages.usecase.interactors.location;

import com.aarves.bluepages.usecase.interactors.Observer;
import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.entities.User;

import java.util.ArrayList;
import java.util.List;

public class BookmarkManager implements Observer<User> {
    private List<Location> bookmarks;

    public BookmarkManager() {
        this.bookmarks = new ArrayList<>();
    }

    @Override
    public void update(User arg) {
        if(arg != null) {
            this.bookmarks = arg.getBookmarks();
        }
        else {
            this.bookmarks = new ArrayList<>();
        }
    }
}
