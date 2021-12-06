package com.aarves.bluepages.database.models;

import androidx.room.ColumnInfo;

import java.util.List;

public class BookmarksWrapper {
    @ColumnInfo(name = "bookmarks")
    public List<Integer> bookmarks;
}
