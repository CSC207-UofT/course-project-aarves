package com.aarves.bluepages.usecase.interactors.review;

import com.aarves.bluepages.entities.Review;
import com.aarves.bluepages.usecase.interactors.review.ReviewOutputBoundary;
import com.aarves.bluepages.usecase.interactors.review.ReviewOutputModel;

import java.util.ArrayList;
import java.util.List;

class ReviewOutputBoundaryMockup implements ReviewOutputBoundary {

    List<ReviewOutputModel> allReviews = new ArrayList<>();
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

    @Override
    public void createResult(boolean success) {

    }
}
