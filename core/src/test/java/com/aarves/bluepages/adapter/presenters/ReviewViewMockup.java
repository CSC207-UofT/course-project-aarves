package com.aarves.bluepages.adapter.presenters;

import java.util.List;

public class ReviewViewMockup implements ReviewView{

    private boolean reviewDisplayed;
    private boolean finishActivity;
    private String popUpDisplay;

    @Override
    public void displayReviews(List<ReviewViewModel> reviews) {
        this.reviewDisplayed = true;
    }

    @Override
    public void displayPopUp(String message) {
        this.popUpDisplay = message;
    }

    @Override
    public void finishActivity() {
        this.finishActivity = true;
    }

    public boolean isReviewDisplayed() {
        return this.reviewDisplayed;
    }

    public String getPopUpDisplay(){
        return this.popUpDisplay;
    }

    public boolean isFinishActivity() {
        return this.finishActivity;
    }
}