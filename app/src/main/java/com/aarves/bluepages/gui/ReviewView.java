package com.aarves.bluepages.gui;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.aarves.bluepages.R;
import com.aarves.bluepages.entities.Review;

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
        reviewList.add(new Review("user 1", 0, 1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ullamcorper tristique neque sed auctor. In consectetur tortor in diam luctus, eget tempus diam finibus. Sed purus lorem, scelerisque et urna quis, imperdiet faucibus purus. Cras consequat purus dolor, tincidunt pulvinar orci tristique non. Pellentesque quis odio lacinia, accumsan felis a."));
        reviewList.add(new Review("user 2", 0, 3,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ullamcorper tristique neque sed auctor. In consectetur tortor in diam luctus, eget tempus diam finibus. Sed purus lorem, scelerisque et urna quis, imperdiet faucibus purus. Cras consequat purus dolor, tincidunt pulvinar orci tristique non. Pellentesque quis odio lacinia, accumsan felis a."));
        reviewList.add(new Review("user 3", 0, 5,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ullamcorper tristique neque sed auctor. In consectetur tortor in diam luctus, eget tempus diam finibus. Sed purus lorem, scelerisque et urna quis, imperdiet faucibus purus. Cras consequat purus dolor, tincidunt pulvinar orci tristique non. Pellentesque quis odio lacinia, accumsan felis a."));
        reviewList.add(new Review("user 4", 0, 4,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ullamcorper tristique neque sed auctor. In consectetur tortor in diam luctus, eget tempus diam finibus. Sed purus lorem, scelerisque et urna quis, imperdiet faucibus purus. Cras consequat purus dolor, tincidunt pulvinar orci tristique non. Pellentesque quis odio lacinia, accumsan felis a."));

        ReviewViewAdapter adapter = new ReviewViewAdapter(this, R.layout.activity_review, reviewList);
        reviewView.setAdapter(adapter);
    }
}
