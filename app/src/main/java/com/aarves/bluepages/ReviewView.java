package com.aarves.bluepages;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.aarves.core.entities.FoodLocation;
import com.aarves.core.entities.Review;

import java.util.ArrayList;

public class ReviewView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_view);
        ListView reviewView = findViewById(R.id.listView);

        ArrayList<Review> reviewList = new ArrayList<>();
        FoodLocation food = new FoodLocation("1", "Location", "area", "test", true, true, "1");
        reviewList.add(new Review("user 1",food, "Good", 1));
        reviewList.add(new Review("user 2,", food,"wow", 5));

        ReviewViewAdapter adapter = new ReviewViewAdapter(this, R.layout.activity_review, reviewList);
        reviewView.setAdapter(adapter);
    }
}
