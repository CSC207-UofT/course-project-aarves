package com.aarves.bluepages.database.access;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.OnConflictStrategy;

import com.aarves.bluepages.database.models.LocationDataEntity;

@Dao
public interface LocationDatabaseDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(LocationDataEntity locationDataEntity);

    @Delete
    void delete(LocationDataEntity locationDataEntity);

    @Query("SELECT * FROM locations WHERE location_id = :locationId LIMIT 1")
    LocationDataEntity getByID(int locationId);
}
