package com.aarves.bluepages.adapter.controllers;

import com.aarves.bluepages.usecase.interactors.ReviewManager;

public class ReviewController {
    private final ReviewManager reviewManager;

    public ReviewController(ReviewManager reviewManager) {
        this.reviewManager = reviewManager;
    }
}
