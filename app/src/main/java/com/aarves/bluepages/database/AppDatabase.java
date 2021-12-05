package com.aarves.bluepages.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.aarves.bluepages.database.access.AccountDatabaseDAO;
import com.aarves.bluepages.database.access.LocationDatabaseDAO;
import com.aarves.bluepages.database.models.AccountDataEntity;
import com.aarves.bluepages.database.access.ReviewDatabaseDAO;
import com.aarves.bluepages.database.models.LocationDataEntity;
import com.aarves.bluepages.database.models.ReviewDataEntity;

@Database(entities = {AccountDataEntity.class, LocationDataEntity.class, ReviewDataEntity.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AccountDatabaseDAO accountDatabaseDAO();
    public abstract LocationDatabaseDAO locationDatabaseDAO();
    public abstract ReviewDatabaseDAO reviewDatabaseDAO();
}
