package com.aarves.bluepages.gui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.aarves.bluepages.R;
import com.aarves.bluepages.adapter.controllers.LocationController;
import com.aarves.bluepages.adapter.presenters.LocationViewModel;

public class LocationArrayAdapter extends ArrayAdapter<LocationViewModel> {
    private final LocationController locationController;
    private final Context context;
    private final int resource;

    public LocationArrayAdapter(Context context, int resource, LocationController locationController) {
        super(context, resource);

        this.context = context;
        this.resource = resource;

        this.locationController = locationController;
    }

    @Override
    @SuppressLint("ViewHolder")
    public View getView(int position, View convertView, ViewGroup parent) {
        String locationType = this.getItem(position).getLocationType();
        String locationName = this.getItem(position).getLocationName();

        LayoutInflater inflater = LayoutInflater.from(this.context);
        convertView = inflater.inflate(this.resource, parent, false);

        // set the location name
        TextView locationNameText = convertView.findViewById(R.id.locationName);
        locationNameText.setText(locationName);

        // Set the location image - food/study
        ImageView locationImage = convertView.findViewById(R.id.locationImage);
        if (locationType.equals("STUDY")) {
            locationImage.setImageResource(R.drawable.ic_baseline_menu_book_24);
        }
        else {
            locationImage.setImageResource(R.drawable.ic_baseline_restaurant_24);
        }

        // Set a listener for the review button
        Button locationReviewButton = convertView.findViewById(R.id.locationLeaveReview);
        locationReviewButton.setOnClickListener(v -> {
            // Start activity CreateReviewActivity and pass in the locationID, needed to create the review
            Intent intent = new Intent(context, CreateReviewActivity.class);
            // TODO: Currently using hardcoded location ID
            intent.putExtra("locationID", 1);
            context.startActivity(intent);
        });

        // Set a listener for the bookmark button
        Button locationBookmarkButton = convertView.findViewById(R.id.locationBookmark);
        locationBookmarkButton.setOnClickListener(v -> this.locationController.toggleBookmark(1));

        return convertView;
    }

}
