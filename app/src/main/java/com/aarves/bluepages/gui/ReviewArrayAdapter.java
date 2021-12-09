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
import com.aarves.bluepages.adapter.presenters.ReviewViewModel;

public class ReviewArrayAdapter extends ArrayAdapter<ReviewViewModel> {

    private final Context context;
    private final int resource;

    /**
     * Construct a new ReviewArrayAdapter.
     * @param context The context of the application.
     * @param resource The resource ID of the layout to use.
     */
    public ReviewArrayAdapter(Context context, int resource) {
        super(context, resource);

        this.context = context;
        this.resource = resource;
    }

    @Override
    @SuppressLint("ViewHolder")
    public View getView(int position, View convertView, ViewGroup parent) {
        int rating = this.getItem(position).getRating();
        String text = this.getItem(position).getBody();
        String username = this.getItem(position).getReviewer();

        LayoutInflater inflater = LayoutInflater.from(this.context);
        convertView = inflater.inflate(this.resource, parent, false);

        TextView usernameText = convertView.findViewById(R.id.reviewUsername);
        usernameText.setText(username);

        TextView reviewText = convertView.findViewById(R.id.reviewText);
        reviewText.setText(text);

        RatingHelper.setRating(convertView, rating);

        return convertView;
    }
}
