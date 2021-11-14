package com.aarves.bluepages.database.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "accounts")
public class AccountDataEntity {
    @PrimaryKey
    public String username;

    @ColumnInfo(name = "password_hash")
    public String passwordHash;
}
