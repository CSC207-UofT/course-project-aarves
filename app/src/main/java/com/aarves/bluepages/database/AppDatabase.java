package com.aarves.bluepages.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import androidx.room.TypeConverters;
import com.aarves.bluepages.database.access.AccountDatabaseDAO;
import com.aarves.bluepages.database.access.BookmarkDatabaseDAO;
import com.aarves.bluepages.database.access.LocationDatabaseDAO;
import com.aarves.bluepages.database.models.AccountDataEntity;
import com.aarves.bluepages.database.access.ReviewDatabaseDAO;
import com.aarves.bluepages.database.models.BookmarksListConverter;
import com.aarves.bluepages.database.models.LocationDataEntity;
import com.aarves.bluepages.database.models.ReviewDataEntity;

@Database(version = 3, entities = {AccountDataEntity.class, LocationDataEntity.class, ReviewDataEntity.class}, exportSchema = false)
@TypeConverters({BookmarksListConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract AccountDatabaseDAO accountDatabaseDAO();
    public abstract BookmarkDatabaseDAO bookmarkDatabaseDAO();
    public abstract LocationDatabaseDAO locationDatabaseDAO();
    public abstract ReviewDatabaseDAO reviewDatabaseDAO();
}
