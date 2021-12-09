package com.aarves.bluepages.database.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Data entity for a record in the locations table, used by Room.
 */
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

    /**
     * Constructs a data entity corresponding to a location with given name, coordinates, and type.
     * @param name the name of the location
     * @param longitude the longitude coordinate of the location
     * @param latitude the latitude coordinate of the location
     * @param type the type of location, either "FOOD" or "STUDY"
     */
    public LocationDataEntity(String name, double longitude, double latitude, String type) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.type = type;
    }
}
