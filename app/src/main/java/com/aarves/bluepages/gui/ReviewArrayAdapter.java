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

import java.util.ArrayList;

public class ReviewArrayAdapter extends ArrayAdapter<ReviewViewModel> {
    private final Context context;
    private final int resource;

    public ReviewArrayAdapter(Context context, int resource, ArrayList<ReviewViewModel> reviews) {
        super(context, resource, reviews);

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

        this.setRating(convertView, rating);

        return convertView;
    }

    private void setRating(View convertView, int rating) {
        int[] starIds = {R.id.review_star1, R.id.review_star2, R.id.review_star3, R.id.review_star4, R.id.review_star5};

        for(int i = 0; i < rating; i++) {
            ImageView star = convertView.findViewById(starIds[i]);
            star.setImageResource(R.drawable.ic_baseline_star_24);
        }
    }

}
