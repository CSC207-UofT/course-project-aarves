package com.aarves.bluepages.database.access;

import androidx.room.Dao;
import androidx.room.Query;

import com.aarves.bluepages.database.models.BookmarksWrapper;

import java.util.List;

@Dao
public interface BookmarkDatabaseDAO {
    @Query("SELECT bookmarks FROM accounts WHERE username = :username LIMIT 1")
    BookmarksWrapper getBookmarks(String username);

    @Query("UPDATE accounts SET bookmarks = :bookmarks WHERE username = :username")
    void updateBookmarks(String username, List<Integer> bookmarks);
}
