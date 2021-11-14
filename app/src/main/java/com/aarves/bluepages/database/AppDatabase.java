package com.aarves.bluepages.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.aarves.bluepages.database.access.ReviewDatabaseDAO;
import com.aarves.bluepages.database.models.ReviewDataEntity;

@Database(entities = {ReviewDataEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ReviewDatabaseDAO reviewDatabaseDAO();
}
