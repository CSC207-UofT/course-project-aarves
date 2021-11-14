package com.aarves.bluepages.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.aarves.bluepages.database.access.AccountDatabaseDAO;
import com.aarves.bluepages.database.access.ReviewDatabaseDAO;
import com.aarves.bluepages.database.models.AccountDataEntity;
import com.aarves.bluepages.database.models.ReviewDataEntity;

@Database(entities = {AccountDataEntity.class, ReviewDataEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AccountDatabaseDAO accountDatabaseDAO();
    public abstract ReviewDatabaseDAO reviewDatabaseDAO();
}
