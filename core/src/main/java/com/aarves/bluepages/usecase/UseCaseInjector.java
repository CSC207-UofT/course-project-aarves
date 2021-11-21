package com.aarves.bluepages.usecase;

import com.aarves.bluepages.usecase.data.AccountDAO;
import com.aarves.bluepages.usecase.data.AccountDataImpl;
import com.aarves.bluepages.usecase.data.ReviewDAO;
import com.aarves.bluepages.usecase.data.ReviewRepositoryImpl;

import com.aarves.bluepages.usecase.interactors.AccountManager;
import com.aarves.bluepages.usecase.interactors.ReviewManager;

import java.security.NoSuchAlgorithmException;

public class UseCaseInjector {
    private final AccountManager accountManager;
    private final ReviewManager reviewManager;

    public UseCaseInjector(AccountDAO accountDAO, ReviewDAO reviewDAO) throws NoSuchAlgorithmException {
        ReviewRepositoryImpl reviewRepository = new ReviewRepositoryImpl(reviewDAO);
        AccountDataImpl accountData = new AccountDataImpl(accountDAO, reviewRepository);

        this.accountManager = new AccountManager(accountData);
        this.reviewManager = new ReviewManager(reviewRepository, this.accountManager);
    }

    public AccountManager getAccountManager() {
        return this.accountManager;
    }

    public ReviewManager getReviewManager() {
        return this.reviewManager;
    }
}
