package com.aarves.bluepages.database.models;

import androidx.room.ColumnInfo;

import java.util.List;

/**
 * A wrapper class to allow for Room to retrieve lists.
 */
public class BookmarksWrapper {
    @ColumnInfo(name = "bookmarks")
    public List<Integer> bookmarks;
}
