package com.aarves.bluepages.adapter.presenters;

import com.aarves.bluepages.usecase.interactors.review.ReviewOutputBoundary;
import com.aarves.bluepages.usecase.interactors.review.ReviewOutputModel;

import java.util.List;

public class ReviewPresenter implements ReviewOutputBoundary {
    private ReviewView reviewView;
    private BasicView baseView;

    @Override
    public void presentReviews(List<ReviewOutputModel> reviews) {
        if(this.reviewView != null) {
            List<ReviewViewModel> reviewViewModels = ReviewModelMapper.mapToViewModels(reviews);
            this.reviewView.displayReviews(reviewViewModels);
        }
    }

    @Override
    public void createResult(boolean success) {
        if(this.baseView != null) {
            if(success) {
                this.baseView.displayPopUp("Review successfully created!");
                this.baseView.finishActivity();
            }
            else {
                this.baseView.displayPopUp("Review creation failed. Please try again!");
            }
        }
    }

    public void setReviewView(ReviewView reviewView) {
        this.reviewView = reviewView;
    }

    public void setBaseView(BasicView baseView) {
        this.baseView = baseView;
    }
}
