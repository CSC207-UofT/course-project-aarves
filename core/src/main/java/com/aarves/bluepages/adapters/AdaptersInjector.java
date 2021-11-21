package com.aarves.bluepages.adapters;

import com.aarves.bluepages.usecase.UseCaseInjector;
import com.aarves.bluepages.usecase.data.AccountDAO;
import com.aarves.bluepages.usecase.data.ReviewDAO;

import java.security.NoSuchAlgorithmException;

public class AdaptersInjector {
    private final AccountController accountController;
    private final ReviewController reviewController;

    public AdaptersInjector(AccountDAO accountDAO, ReviewDAO reviewDAO) throws NoSuchAlgorithmException {
        AccountPresenterImpl accountPresenter = new AccountPresenterImpl();

        UseCaseInjector useCaseInjector = new UseCaseInjector(accountDAO, reviewDAO, accountPresenter);

        this.accountController = new AccountController(useCaseInjector.getAccountManager());
        this.reviewController = new ReviewController(useCaseInjector.getReviewManager());
    }

    public AccountController getAccountController() {
        return this.accountController;
    }

    public ReviewController getReviewController() {
        return this.reviewController;
    }
}
