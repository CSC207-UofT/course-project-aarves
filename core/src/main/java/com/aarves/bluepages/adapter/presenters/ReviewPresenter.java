package com.aarves.bluepages.adapter.presenters;

import com.aarves.bluepages.usecase.interactors.review.ReviewOutputBoundary;
import com.aarves.bluepages.usecase.interactors.review.ReviewOutputModel;

import java.util.List;

public class ReviewPresenter implements ReviewOutputBoundary {
    private ReviewView reviewView;
    private BasicView baseView;

    /**
     * Converts the reviews from their ReviewOutputModels to ReviewViewModels to present.
     * @param reviews the ReviewOutputModels of the reviews to present.
     */
    @Override
    public void presentReviews(List<ReviewOutputModel> reviews) {
        if(this.reviewView != null) {
            List<ReviewViewModel> reviewViewModels = ReviewModelMapper.mapToViewModels(reviews);
            this.reviewView.displayReviews(reviewViewModels);
        }
    }

    /**
     * Creates the result of the review creation to display.
     * @param success whether the review creation process was successful or not.
     */
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

    /**
     * Sets the ReviewView interface.
     * @param reviewView the ReviewView interface to set.
     */
    public void setReviewView(ReviewView reviewView) {
        this.reviewView = reviewView;
    }

    /**
     * Sets the BasicView interface.
     * @param baseView the BasicView interface to set.
     */
    public void setBaseView(BasicView baseView) {
        this.baseView = baseView;
    }
}
