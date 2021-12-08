package com.aarves.bluepages.database.access;

import androidx.room.Dao;
import androidx.room.Query;

import com.aarves.bluepages.database.models.BookmarksWrapper;

import java.util.List;

/**
 * Data access object for bookmarks in the accounts table, which gets automatically implemented by Room.
 */
@Dao
public interface BookmarkDatabaseDAO {
    /**
     * Retrieves the bookmarks of the account corresponding to the given username.
     * @param username the username of the bookmarks to be retrieved
     * @return the bookmarks corresponding to the username, or null if account does not exist
     */
    @Query("SELECT bookmarks FROM accounts WHERE username = :username LIMIT 1")
    BookmarksWrapper getBookmarks(String username);

    /**
     * Updates the bookmarks of the account corresponding to the given username to the given list of bookmarks.
     * @param username the username of the bookmarks to be updated
     * @param bookmarks the IDs of the bookmarked locations to be updated to
     */
    @Query("UPDATE accounts SET bookmarks = :bookmarks WHERE username = :username")
    void updateBookmarks(String username, List<Integer> bookmarks);
}
