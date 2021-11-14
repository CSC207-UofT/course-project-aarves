package com.aarves.bluepages.database.access;

import androidx.room.*;
import com.aarves.bluepages.database.models.ReviewDataEntity;

import java.util.List;

@Dao
public interface ReviewDatabaseDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(ReviewDataEntity reviewDataEntity);

    @Delete
    void delete(ReviewDataEntity reviewDataEntity);

    @Query("SELECT * FROM reviews WHERE reviewId = :reviewId LIMIT 1")
    ReviewDataEntity getByID(int reviewId);

    @Query("SELECT * FROM reviews WHERE username = :username")
    List<ReviewDataEntity> getByUser(String username);

    @Query("SELECT * FROM reviews WHERE location_id = :locationId")
    List<ReviewDataEntity> getByLocation(int locationId);
}
