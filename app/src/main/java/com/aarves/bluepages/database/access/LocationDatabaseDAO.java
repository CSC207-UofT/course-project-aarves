package com.aarves.bluepages.database.access;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.OnConflictStrategy;

import com.aarves.bluepages.database.models.LocationDataEntity;
import com.aarves.bluepages.database.models.LocationBasicDataTuple;

import java.util.List;

/**
 * Data access object for the locations table, which gets automatically implemented by Room.
 */
@Dao
public interface LocationDatabaseDAO {
    /**
     * Inserts the data entity as a record into the locations table.
     * Replaces existing record if there is a conflict.
     * @param locationDataEntity the data entity corresponding to the location to be inserted
     * @return the automatically generated ID corresponding to the inserted location
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(LocationDataEntity locationDataEntity);

    /**
     * Deletes the record corresponding to the data entity from the locations table.
     * @param locationDataEntity the data entity corresponding to the location to be deleted
     */
    @Delete
    void delete(LocationDataEntity locationDataEntity);

    /**
     * Retrieves location data corresponding to given location ID.
     * @param locationId the ID of the location to be retrieved
     * @return the location data entity corresponding to the ID, or null if location does not exist
     */
    @Query("SELECT * FROM locations WHERE location_id = :locationId LIMIT 1")
    LocationDataEntity getByID(int locationId);

    /**
     * Retrieves the basic data of all locations stored in the locations table.
     * @return a list of basic location data for each location
     */
    @Query("SELECT location_id, longitude, latitude FROM locations")
    List<LocationBasicDataTuple> getAllBasicData();
}
