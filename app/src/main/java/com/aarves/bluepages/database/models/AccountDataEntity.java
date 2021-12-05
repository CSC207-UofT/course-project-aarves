package com.aarves.bluepages.database.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;
import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "accounts")
public class AccountDataEntity {
    @PrimaryKey @NonNull
    @ColumnInfo(name = "username")
    public String username;

    @ColumnInfo(name = "password_hash")
    public String passwordHash;

    public AccountDataEntity(@NotNull String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }
}
