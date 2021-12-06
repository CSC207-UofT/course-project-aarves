package com.aarves.bluepages.adapter.presenters;

import com.aarves.bluepages.usecase.interactors.review.ReviewOutputModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReviewPresenterTest {

    ReviewPresenter reviewPresenter;
    ReviewViewMockup reviewView;

    @BeforeEach
    void setUp() {
        reviewView = new ReviewViewMockup();
        reviewPresenter = new ReviewPresenter();
        reviewPresenter.setReviewView(reviewView);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void presentReviews() {
        ReviewOutputModel r1 = new ReviewOutputModel("reviewer", 4, "good food");
        ReviewOutputModel r2 = new ReviewOutputModel("reviewer", 3, "good pasta");
        List<ReviewOutputModel> reviewOutputModelList = new ArrayList<>();
        reviewOutputModelList.add(r1);
        reviewOutputModelList.add(r2);
        reviewPresenter.presentReviews(reviewOutputModelList);
        Assertions.assertTrue(reviewView.reviewDisplayed);
    }

}