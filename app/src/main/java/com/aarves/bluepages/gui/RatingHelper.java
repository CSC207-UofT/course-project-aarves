package com.aarves.bluepages.gui;

import android.view.View;
import android.widget.ImageView;

import com.aarves.bluepages.R;

public class RatingHelper {

    /**
     * Sets the rating image based on the rating value.
     * @param convertView The view to set the rating image on.
     * @param rating The rating value.
     */
    public static void setRating(View convertView, int rating) {
        int[] starIds = {R.id.review_star1, R.id.review_star2, R.id.review_star3, R.id.review_star4, R.id.review_star5};

        for(int i = 0; i < rating; i++) {
            ImageView star = convertView.findViewById(starIds[i]);
            star.setImageResource(R.drawable.ic_baseline_star_24);
        }
    }
}
