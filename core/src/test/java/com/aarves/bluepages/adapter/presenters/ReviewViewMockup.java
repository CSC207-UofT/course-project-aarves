package com.aarves.bluepages.adapter.presenters;

import java.util.List;

public class ReviewViewMockup implements ReviewView{

    boolean reviewDisplayed;

    @Override
    public void displayReviews(List<ReviewViewModel> reviews) {
        reviewDisplayed = true;
    }

    @Override
    public void displayPopUp(String message) {

    }

    @Override
    public void finishActivity() {

    }
}