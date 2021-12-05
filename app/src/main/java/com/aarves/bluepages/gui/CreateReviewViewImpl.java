package com.aarves.bluepages.gui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.aarves.bluepages.MainApplication;
import com.aarves.bluepages.adapter.controllers.ReviewController;

public class CreateReviewViewImpl extends AppCompatActivity {
    protected ReviewController reviewController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainApplication application = (MainApplication) this.getApplication();
        this.reviewController = application.getAdapters().getReviewController();
    }
}
