package com.aarves.bluepages.database.models;

import androidx.room.ColumnInfo;

/**
 * A tuple storing basic data about a location, which is used by Room to select only specified columns.
 */
public class LocationBasicDataTuple {
    @ColumnInfo(name = "location_id")
    public int locationId;

    @ColumnInfo(name = "longitude")
    public double longitude;

    @ColumnInfo(name = "latitude")
    public double latitude;
}
