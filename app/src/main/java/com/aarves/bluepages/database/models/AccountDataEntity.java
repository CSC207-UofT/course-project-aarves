package com.aarves.bluepages.database.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;
import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Data entity for a record in the accounts table, used by Room.
 */
@Entity(tableName = "accounts")
public class AccountDataEntity {
    @PrimaryKey @NonNull
    @ColumnInfo(name = "username")
    public String username;

    @ColumnInfo(name = "password_hash")
    public String passwordHash;

    @ColumnInfo(name = "bookmarks")
    public List<Integer> bookmarks;

    /**
     * Constructs a data entity corresponding to an account with given username, password hash, and bookmarks.
     * @param username the username of the account
     * @param passwordHash the hashed password of the account
     * @param bookmarks the list of bookmarked location IDs of the account
     */
    public AccountDataEntity(@NotNull String username, String passwordHash, List<Integer> bookmarks) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.bookmarks = bookmarks;
    }
}
