package com.aarves.bluepages.database.access;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.OnConflictStrategy;

import com.aarves.bluepages.database.models.ReviewDataEntity;

import java.util.List;

/**
 * Data access object for the reviews table, which gets automatically implemented by Room.
 */
@Dao
public interface ReviewDatabaseDAO {
    /**
     * Inserts the data entity as a record into the reviews table.
     * Replaces existing record if there is a conflict.
     * @param reviewDataEntity the data entity corresponding to the review to be inserted
     * @return the automatically generated ID corresponding to the inserted review
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(ReviewDataEntity reviewDataEntity);

    /**
     * Deletes the record corresponding to the data entity from the reviews table.
     * @param reviewDataEntity the data entity corresponding to the review to be deleted
     */
    @Delete
    void delete(ReviewDataEntity reviewDataEntity);

    /**
     * Retrieves review data corresponding to the given review ID.
     * @param reviewId the ID of the review to be retrieved
     * @return the review data entity corresponding to the ID, or null if review does not exist
     */
    @Query("SELECT * FROM reviews WHERE review_id = :reviewId LIMIT 1")
    ReviewDataEntity getByID(int reviewId);

    /**
     * Retrieves review data of all reviews corresponding to account with given username.
     * @param username the username of the reviews to be retrieved
     * @return the list of review data entities corresponding to the username
     */
    @Query("SELECT * FROM reviews WHERE username = :username")
    List<ReviewDataEntity> getByUser(String username);

    /**
     * Retrieves review data of all reviews corresponding to location with given ID.
     * @param locationId the ID of the location for the reviews to be retrieved
     * @return the list of review data entities corresponding to the location ID
     */
    @Query("SELECT * FROM reviews WHERE location_id = :locationId")
    List<ReviewDataEntity> getByLocation(int locationId);
}
