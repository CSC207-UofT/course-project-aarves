package com.aarves.bluepages;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
        Integer rating = getItem(position).getRating();
        String text = getItem(position).getReview();
        String username = getItem(position).getReviewer();

        LayoutInflater inflater = LayoutInflater.from(context);
        reviewView = inflater.inflate(resource, parent, false);

        TextView usernameText = reviewView.findViewById(R.id.reviewUsername);
        TextView reviewText = reviewView.findViewById(R.id.reviewText);

        ImageView reviewStar1 = reviewView.findViewById(R.id.review_star1);
        ImageView reviewStar2 = reviewView.findViewById(R.id.review_star2);
        ImageView reviewStar3 = reviewView.findViewById(R.id.review_star3);
        ImageView reviewStar4 = reviewView.findViewById(R.id.review_star4);
        ImageView reviewStar5 = reviewView.findViewById(R.id.review_star5);

        setRating(reviewStar1, reviewStar2, reviewStar3, reviewStar4, reviewStar5, rating);

        usernameText.setText(username);
        reviewText.setText(text);

        return reviewView;
    }

    public void setRating(ImageView reviewStar1, ImageView reviewStar2, ImageView reviewStar3, ImageView reviewStar4, ImageView reviewStar5, int rating) {
        if (rating >= 1) {
            reviewStar1.setImageResource(R.drawable.ic_baseline_star_24);
        }
        if (rating >= 2) {
            reviewStar2.setImageResource(R.drawable.ic_baseline_star_24);
        }
        if (rating >= 3) {
            reviewStar3.setImageResource(R.drawable.ic_baseline_star_24);
        }
        if (rating >= 4) {
            reviewStar4.setImageResource(R.drawable.ic_baseline_star_24);
        }
        if (rating >= 5) {
            reviewStar5.setImageResource(R.drawable.ic_baseline_star_24);
        }
    }

}
