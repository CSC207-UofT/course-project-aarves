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
import com.aarves.bluepages.adapter.controllers.AccountController;
import com.aarves.bluepages.adapter.controllers.LocationController;
import com.aarves.bluepages.adapter.presenters.LocationViewModel;

public class LocationArrayAdapter extends ArrayAdapter<LocationViewModel> {
    private final AccountController accountController;
    private final LocationController locationController;
    private final Context context;
    private final int resource;

    /**
     * Construct a new LocationArrayAdapter.
     * @param context The current context.
     * @param resource The view resource ID.
     * @param accountController The account controller.
     * @param locationController The location controller.
     */
    public LocationArrayAdapter(Context context, int resource, AccountController accountController, LocationController locationController) {
        super(context, resource);

        this.context = context;
        this.resource = resource;

        this.accountController = accountController;
        this.locationController = locationController;
    }

    /**
     * Toggle the bookmark button.
     * @param button The button to toggle.
     * @param isBookmarked Whether the location is bookmarked.
     */
    private void toggleBookmark(Button button, boolean isBookmarked) {
        if(isBookmarked) {
            button.setText(R.string.unbookmark);
        }
        else {
            button.setText(R.string.bookmark);
        }
    }

    @Override
    @SuppressLint("ViewHolder")
    public View getView(int position, View convertView, ViewGroup parent) {
        LocationViewModel location = this.getItem(position);

        LayoutInflater inflater = LayoutInflater.from(this.context);
        convertView = inflater.inflate(this.resource, parent, false);

        // set the location name
        TextView locationNameText = convertView.findViewById(R.id.locationName);
        locationNameText.setText(location.getLocationName());

        // Set the location image - food/study
        ImageView locationImage = convertView.findViewById(R.id.locationImage);
        if (location.getLocationType().equals("STUDY")) {
            locationImage.setImageResource(R.drawable.ic_baseline_menu_book_24);
        }
        else {
            locationImage.setImageResource(R.drawable.ic_baseline_restaurant_24);
        }

        RatingHelper.setRating(convertView, location.getRating());

        // Set a listener for the review button
        Button locationReviewsButton = convertView.findViewById(R.id.locationReviews);
        locationReviewsButton.setOnClickListener(v -> {
            // Start activity CreateReviewActivity and pass in the locationID, needed to create the review
            Intent intent = new Intent(context, ReviewActivity.class);
            intent.putExtra(ReviewActivity.LOCATION_ID, location.getLocationId());
            context.startActivity(intent);
        });

        // Set a listener for the create review button
        Button locationLeaveReviewButton = convertView.findViewById(R.id.locationLeaveReview);
        locationLeaveReviewButton.setOnClickListener(v -> {
            // Start activity CreateReviewActivity and pass in the locationID, needed to create the review
            Intent intent = new Intent(context, CreateReviewActivity.class);
            intent.putExtra(LocationActivity.LOCATION_ID, location.getLocationId());
            intent.putExtra(ReviewActivity.LOCATION_NAME, location.getLocationName());
            context.startActivity(intent);
        });

        // Set a listener for the bookmark button
        Button locationBookmarkButton = convertView.findViewById(R.id.locationBookmark);
        this.toggleBookmark(locationBookmarkButton, location.isBookmarked());
        locationBookmarkButton.setOnClickListener(v -> {
            this.locationController.toggleBookmark(location.getLocationId());
            location.toggleBookmarked();

            this.toggleBookmark(locationBookmarkButton, location.isBookmarked());
        });

        // Set the button visibility - guest/not guest
        if (accountController.isLoggedIn()) {
            locationBookmarkButton.setVisibility(View.VISIBLE);
            locationLeaveReviewButton.setVisibility(View.VISIBLE);
        }
        else {
            locationBookmarkButton.setVisibility(View.GONE);
            locationLeaveReviewButton.setVisibility(View.GONE);
        }

        return convertView;
    }

}
