package com.aarves.bluepages.database.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;
import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

import java.util.List;

@Entity(tableName = "accounts")
public class AccountDataEntity {
    @PrimaryKey @NonNull
    @ColumnInfo(name = "username")
    public String username;

    @ColumnInfo(name = "password_hash")
    public String passwordHash;

    @ColumnInfo(name = "bookmarks")
    public List<Integer> bookmarks;

    public AccountDataEntity(@NotNull String username, String passwordHash, List<Integer> bookmarks) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.bookmarks = bookmarks;
    }
}
