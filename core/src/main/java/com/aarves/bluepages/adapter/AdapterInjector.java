package com.aarves.bluepages.adapter;

import com.aarves.bluepages.adapter.controllers.AccountController;
import com.aarves.bluepages.adapter.controllers.ReviewController;
import com.aarves.bluepages.adapter.presenters.*;

import com.aarves.bluepages.usecase.UseCaseInjector;
import com.aarves.bluepages.usecase.data.AccountDAO;
import com.aarves.bluepages.usecase.data.ReviewDAO;

import java.security.NoSuchAlgorithmException;

public class AdapterInjector {
    private final AccountController accountController;
    private final AccountPresenter accountPresenter;
    private final ReviewController reviewController;
    private final ReviewPresenter reviewPresenter;

    public AdapterInjector(AccountDAO accountDAO, ReviewDAO reviewDAO) throws NoSuchAlgorithmException {
        this.accountPresenter = new AccountPresenter();
        this.reviewPresenter = new ReviewPresenter();

        UseCaseInjector useCaseInjector = new UseCaseInjector(accountDAO, reviewDAO, this.accountPresenter, this.reviewPresenter);

        this.accountController = new AccountController(useCaseInjector.getAccountManager());
        this.reviewController = new ReviewController(useCaseInjector.getReviewManager());
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
}
