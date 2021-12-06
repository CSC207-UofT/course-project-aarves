package com.aarves.bluepages.adapter;

import com.aarves.bluepages.adapter.controllers.AccountController;
import com.aarves.bluepages.adapter.controllers.ReviewController;
import com.aarves.bluepages.adapter.presenters.*;

import com.aarves.bluepages.usecase.data.account.AccountDAO;
import com.aarves.bluepages.usecase.data.location.LocationDAO;
import com.aarves.bluepages.usecase.data.review.ReviewDAO;

import com.aarves.bluepages.usecase.interactors.account.AccountManager;
import com.aarves.bluepages.usecase.interactors.account.AccountUseCaseInjector;
import com.aarves.bluepages.usecase.interactors.location.LocationUseCaseInjector;
import com.aarves.bluepages.usecase.interactors.review.ReviewManager;
import com.aarves.bluepages.usecase.interactors.review.ReviewUseCaseInjector;

import java.security.NoSuchAlgorithmException;

public class AdapterInjector {
    private final AccountController accountController;
    private final AccountPresenter accountPresenter;
    private final ReviewController reviewController;
    private final ReviewPresenter reviewPresenter;

    public AdapterInjector(AccountDAO accountDAO, LocationDAO locationDAO, ReviewDAO reviewDAO) throws NoSuchAlgorithmException {
        this.accountPresenter = new AccountPresenter();
        this.reviewPresenter = new ReviewPresenter();

        AccountUseCaseInjector accountInjector = new AccountUseCaseInjector(accountDAO, this.accountPresenter);
        LocationUseCaseInjector locationInjector = new LocationUseCaseInjector(locationDAO);
        ReviewUseCaseInjector reviewInjector = new ReviewUseCaseInjector(reviewDAO, this.reviewPresenter);

        AccountManager accountManager = accountInjector.getAccountManager();
        ReviewManager reviewManager = reviewInjector.getReviewManager();
        accountManager.addObserver(reviewManager);

        this.accountController = new AccountController(accountManager);
        this.reviewController = new ReviewController(reviewManager);
    }

    public AccountController getAccountController() {
        return this.accountController;
    }

    public void setAccountView(AccountView accountView) {
        this.accountPresenter.setAccountView(accountView);
    }

    public void setAccountMenuView(AccountMenuView accountMenuView) {
        this.accountPresenter.setAccountMenuView(accountMenuView);
    }

    public ReviewController getReviewController() {
        return this.reviewController;
    }

    public void setReviewView(ReviewView reviewView) {
        this.reviewPresenter.setReviewView(reviewView);
    }

    public void setReviewBaseView(BasicView baseView) {
        this.reviewPresenter.setBaseView(baseView);
    }
}
