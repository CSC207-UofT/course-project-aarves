package com.aarves.bluepages.adapter.presenters;

import com.aarves.bluepages.usecase.interactors.review.ReviewOutputBoundary;
import com.aarves.bluepages.usecase.interactors.review.ReviewOutputModel;

import java.util.List;

public class ReviewPresenter implements ReviewOutputBoundary {
    private ReviewView reviewView;

    @Override
    public void presentReviews(List<ReviewOutputModel> reviews) {
        if(this.verifyDependencies()) {
            List<ReviewViewModel> reviewViewModels = ReviewModelMapper.mapToViewModels(reviews);
            this.reviewView.displayReviews(reviewViewModels);
        }
    }

    public void setReviewView(ReviewView reviewView) {
        this.reviewView = reviewView;
    }

    private boolean verifyDependencies() {
        return this.reviewView != null;
    }
}
