package com.aarves.bluepages.database.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "locations")
public class LocationDataEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "location_id")
    public int locationId;

    @ColumnInfo(name = "location_name")
    public String name;

    @ColumnInfo(name = "longitude")
    public double longitude;

    @ColumnInfo(name = "latitude")
    public double latitude;

    @ColumnInfo(name = "location_type")
    public String type;

    public LocationDataEntity(String name, double longitude, double latitude, String type) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.type = type;
    }
}
