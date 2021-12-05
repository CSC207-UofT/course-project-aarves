package com.aarves.bluepages.adapter;

import com.aarves.bluepages.adapter.controllers.AccountController;
import com.aarves.bluepages.adapter.controllers.ReviewController;
import com.aarves.bluepages.adapter.presenters.AccountPresenter;
import com.aarves.bluepages.adapter.presenters.AccountView;
import com.aarves.bluepages.adapter.presenters.ReviewPresenter;
import com.aarves.bluepages.adapter.presenters.ReviewView;

import com.aarves.bluepages.usecase.data.AccountDAO;
import com.aarves.bluepages.usecase.data.LocationDAO;
import com.aarves.bluepages.usecase.data.ReviewDAO;
import com.aarves.bluepages.usecase.interactors.account.AccountManager;
import com.aarves.bluepages.usecase.interactors.account.AccountUseCaseInjector;
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

        AccountUseCaseInjector accountUseCaseInjector = new AccountUseCaseInjector(accountDAO, this.accountPresenter);
        ReviewUseCaseInjector reviewUseCaseInjector = new ReviewUseCaseInjector(reviewDAO, this.reviewPresenter);

        AccountManager accountManager = accountUseCaseInjector.getAccountManager();
        ReviewManager reviewManager = reviewUseCaseInjector.getReviewManager();
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

    public ReviewController getReviewController() {
        return this.reviewController;
    }

    public void setReviewView(ReviewView reviewView) {
        this.reviewPresenter.setReviewView(reviewView);
    }
}
