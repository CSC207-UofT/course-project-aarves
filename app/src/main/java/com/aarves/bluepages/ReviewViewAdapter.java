package com.aarves.bluepages;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.aarves.core.entities.Review;

import java.util.ArrayList;

public class ReviewViewAdapter extends ArrayAdapter<Review> {

    Context context;
    int resource;

    public ReviewViewAdapter(Context context, int resource, ArrayList<Review> reviews) {
        super(context, resource, reviews);
        this.context = context;
        this.resource = resource;
    }

    @SuppressLint("ViewHolder")
    public View getView(int position, View reviewView, ViewGroup parent) {
        String rating = "Rating: " + String.valueOf(getItem(position).getRating());
        String text = getItem(position).getReview();
        String username = "Username: " + getItem(position).getReviewer();

        LayoutInflater inflater = LayoutInflater.from(context);
        reviewView = inflater.inflate(resource, parent, false);

        TextView ratingText = (TextView) reviewView.findViewById(R.id.reviewRating);
        TextView usernameText = (TextView) reviewView.findViewById(R.id.reviewUsername);
        TextView reviewText = (TextView) reviewView.findViewById(R.id.reviewText);

        ratingText.setText(rating);
        usernameText.setText(username);
        reviewText.setText(text);

        return reviewView;
    }

}
