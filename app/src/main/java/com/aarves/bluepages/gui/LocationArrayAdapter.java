package com.aarves.bluepages.gui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aarves.bluepages.R;
import com.aarves.bluepages.adapter.presenters.LocationViewModel;
import com.aarves.bluepages.usecase.data.location.LocationType;

import java.util.ArrayList;

public class LocationArrayAdapter extends ArrayAdapter<LocationViewModel> {
    private final Context context;
    private final int resource;

    // Temp LocationViewModel call as we don't have a controller yet
    public LocationArrayAdapter(Context context, int resource, ArrayList<LocationViewModel> locations) {
        super(context, resource, locations);

        this.context = context;
        this.resource = resource;
    }

    @Override
    @SuppressLint("ViewHolder")
    public View getView(int position, View convertView, ViewGroup parent) {
        LocationType locationType = this.getItem(position).getLocationType();
        String locationName = this.getItem(position).getLocationName();

        LayoutInflater inflater = LayoutInflater.from(this.context);
        convertView = inflater.inflate(this.resource, parent, false);

        // set the location name
        TextView locationNameText = convertView.findViewById(R.id.locationName);
        locationNameText.setText(locationName);

        // Set the location image - food/study
        ImageView locationImage = convertView.findViewById(R.id.locationImage);
        if (locationType==LocationType.STUDY) {
            locationImage.setImageResource(R.drawable.ic_baseline_menu_book_24);
        } else {
            locationImage.setImageResource(R.drawable.ic_baseline_restaurant_24);
        }

        return convertView;

    }

}
