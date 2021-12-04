package com.aarves.bluepages.usecase;

import com.aarves.bluepages.usecase.data.AccountDAO;
import com.aarves.bluepages.usecase.data.AccountDataAccess;
import com.aarves.bluepages.usecase.data.ReviewDAO;
import com.aarves.bluepages.usecase.data.ReviewRepositoryImpl;

import com.aarves.bluepages.usecase.interactors.account.AccountManager;
import com.aarves.bluepages.usecase.interactors.account.AccountOutputBoundary;
import com.aarves.bluepages.usecase.interactors.ReviewManager;

import java.security.NoSuchAlgorithmException;

public class UseCaseInjector {
    private final AccountManager accountManager;
    private final ReviewManager reviewManager;

    public UseCaseInjector(AccountDAO accountDAO, ReviewDAO reviewDAO, AccountOutputBoundary accountOutput) throws NoSuchAlgorithmException {
        // TODO: May need to eventually refactor into UseCaseInjectors for each aggregate.
        ReviewRepositoryImpl reviewRepository = new ReviewRepositoryImpl(reviewDAO);
        AccountDataAccess accountDataAccess = new AccountDataAccess(accountDAO, reviewRepository);

        this.accountManager = new AccountManager(accountDataAccess, accountOutput);
        this.reviewManager = new ReviewManager(reviewRepository);
    }

    public AccountManager getAccountManager() {
        return this.accountManager;
    }

    public ReviewManager getReviewManager() {
        return this.reviewManager;
    }
}
