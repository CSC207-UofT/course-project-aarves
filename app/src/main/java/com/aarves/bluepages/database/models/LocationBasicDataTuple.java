package com.aarves.bluepages.database.models;

import androidx.room.ColumnInfo;

public class LocationBasicDataTuple {
    @ColumnInfo(name = "location_id")
    public int locationId;

    @ColumnInfo(name = "longitude")
    public double longitude;

    @ColumnInfo(name = "latitude")
    public double latitude;
}
