package com.aarves.bluepages.database.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "accounts")
public class AccountDataEntity {
    @PrimaryKey
    @NonNull
    public String username;

    @ColumnInfo(name = "password_hash")
    public String passwordHash;

    public AccountDataEntity(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }
}
