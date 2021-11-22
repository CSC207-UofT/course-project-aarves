package com.aarves.bluepages.database.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

@Entity(tableName = "reviews")
public class ReviewDataEntity {
    @PrimaryKey(autoGenerate = true)
    public int reviewId;

    @ColumnInfo(name = "username")
    public String reviewer;

    @ColumnInfo(name = "location_id")
    public int locationId;

    @ColumnInfo(name = "rating")
    public int rating;

    @ColumnInfo(name = "review_body")
    public String body;

    public ReviewDataEntity(String reviewer, int locationId, int rating, String body) {
        this.reviewer = reviewer;
        this.locationId = locationId;
        this.rating = rating;
        this.body = body;
    }
}
