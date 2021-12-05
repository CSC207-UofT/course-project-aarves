package com.aarves.bluepages.usecase.interactors.review;

import com.aarves.bluepages.usecase.interactors.review.ReviewOutputBoundary;
import com.aarves.bluepages.usecase.interactors.review.ReviewOutputModel;

import java.util.List;

class ReviewOutputBoundaryMockup implements ReviewOutputBoundary {

    List<ReviewOutputModel> allReviews;
    boolean presentedReviews;

    public void setAllReviews(List<ReviewOutputModel> newReviews){
        allReviews.clear();
        this.allReviews = newReviews;
    }
    public List<ReviewOutputModel> getReviews(){
        return this.allReviews;
    }

    @Override
    public void presentReviews(List<ReviewOutputModel> reviews) {
        this.presentedReviews = true;
        allReviews.addAll(reviews);
    }
}
