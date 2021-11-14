package com.aarves.bluepages.database.access;

import androidx.room.*;
import com.aarves.bluepages.database.models.ReviewDataEntity;

@Dao
public interface ReviewDatabaseDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(ReviewDataEntity reviewDataEntity);

    @Delete
    void delete(ReviewDataEntity reviewDataEntity);

    @Query("SELECT * FROM reviews WHERE reviewId = :reviewId")
    ReviewDataEntity getByID(int reviewId);
}
