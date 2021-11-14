package com.aarves.bluepages.usecase.data;

import com.aarves.bluepages.usecase.interactors.AccountManager;
import com.aarves.bluepages.usecase.interactors.ReviewManager;

import java.security.NoSuchAlgorithmException;

public class DataInjector {
    private final AccountManager accountManager;
    private final ReviewManager reviewManager;

    public DataInjector(AccountDAO accountDAO, ReviewDAO reviewDAO) throws NoSuchAlgorithmException {
        ReviewRepositoryImpl reviewRepository = new ReviewRepositoryImpl(reviewDAO);
        AccountDataImpl accountData = new AccountDataImpl(accountDAO, reviewRepository);

        this.accountManager = new AccountManager(accountData);
        this.reviewManager = new ReviewManager(reviewRepository, accountManager);
    }

    public AccountManager getAccountManager() {
        return this.accountManager;
    }

    public ReviewManager getReviewManager() {
        return this.reviewManager;
    }
}
