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

/**
 * The database class, automatically subclassed by Room. Contains the accounts, locations, and reviews tables.
 */
@Database(version = 3, entities = {AccountDataEntity.class, LocationDataEntity.class, ReviewDataEntity.class}, exportSchema = false)
@TypeConverters({BookmarksListConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    /**
     * Returns the Room data access object for the accounts table.
     * @return the Room data access object for accounts
     */
    public abstract AccountDatabaseDAO accountDatabaseDAO();

    /**
     * Returns the Room data access object for bookmarks in the accounts table.
     * @return the Room data access object for bookmarks
     */
    public abstract BookmarkDatabaseDAO bookmarkDatabaseDAO();

    /**
     * Returns the Room data access object for the locations table.
     * @return the Room data access object for locations
     */
    public abstract LocationDatabaseDAO locationDatabaseDAO();

    /**
     * Returns the Room data access object for the reviews table.
     * @return the Room data access object for reviews
     */
    public abstract ReviewDatabaseDAO reviewDatabaseDAO();
}
