package com.aarves.bluepages.database.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

/**
 * Data entity for a record in the reviews table, used by Room.
 */
@Entity(tableName = "reviews")
public class ReviewDataEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "review_id")
    public int reviewId;

    @ColumnInfo(name = "username")
    public String reviewer;

    @ColumnInfo(name = "location_id")
    public int locationId;

    @ColumnInfo(name = "rating")
    public int rating;

    @ColumnInfo(name = "review_body")
    public String body;

    /**
     * Constructs a data entity corresponding to a review with given reviewer username, location ID, rating, and body.
     * @param reviewer the username of the reviewer of the review
     * @param locationId the ID of the location of the review
     * @param rating the rating of the review
     * @param body the body of the review
     */
    public ReviewDataEntity(String reviewer, int locationId, int rating, String body) {
        this.reviewer = reviewer;
        this.locationId = locationId;
        this.rating = rating;
        this.body = body;
    }
}
