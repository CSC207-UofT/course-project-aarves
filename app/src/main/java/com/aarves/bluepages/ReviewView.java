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

        // TODO: When Location UI is done, all that is needed to be done is to pass the location's array list of reviews into this class, and then into the ReviewViewAdapter
        // TODO: Same for RegisteredUser.

        ArrayList<Review> reviewList = new ArrayList<>();
        FoodLocation food = new FoodLocation("1", "Location", "area", "test", true, true, "1");
        reviewList.add(new Review("user 1",food, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ullamcorper tristique neque sed auctor. In consectetur tortor in diam luctus, eget tempus diam finibus. Sed purus lorem, scelerisque et urna quis, imperdiet faucibus purus. Cras consequat purus dolor, tincidunt pulvinar orci tristique non. Pellentesque quis odio lacinia, accumsan felis a.", 1));
        reviewList.add(new Review("user 2", food,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ullamcorper tristique neque sed auctor. In consectetur tortor in diam luctus, eget tempus diam finibus. Sed purus lorem, scelerisque et urna quis, imperdiet faucibus purus. Cras consequat purus dolor, tincidunt pulvinar orci tristique non. Pellentesque quis odio lacinia, accumsan felis a.", 3));
        reviewList.add(new Review("user 3", food,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ullamcorper tristique neque sed auctor. In consectetur tortor in diam luctus, eget tempus diam finibus. Sed purus lorem, scelerisque et urna quis, imperdiet faucibus purus. Cras consequat purus dolor, tincidunt pulvinar orci tristique non. Pellentesque quis odio lacinia, accumsan felis a.", 5));
        reviewList.add(new Review("user 4", food,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ullamcorper tristique neque sed auctor. In consectetur tortor in diam luctus, eget tempus diam finibus. Sed purus lorem, scelerisque et urna quis, imperdiet faucibus purus. Cras consequat purus dolor, tincidunt pulvinar orci tristique non. Pellentesque quis odio lacinia, accumsan felis a.", 4));

        ReviewViewAdapter adapter = new ReviewViewAdapter(this, R.layout.activity_review, reviewList);
        reviewView.setAdapter(adapter);
    }
}
