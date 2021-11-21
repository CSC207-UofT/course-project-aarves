package com.aarves.bluepages.adapters;

import com.aarves.bluepages.usecase.UseCaseInjector;
import com.aarves.bluepages.usecase.data.AccountDAO;
import com.aarves.bluepages.usecase.data.ReviewDAO;

import java.security.NoSuchAlgorithmException;

public class AdaptersInjector {
    private final AccountController accountController;

    public AdaptersInjector(AccountDAO accountDAO, ReviewDAO reviewDAO) throws NoSuchAlgorithmException {
        UseCaseInjector useCaseInjector = new UseCaseInjector(accountDAO, reviewDAO);

        this.accountController = new AccountController(useCaseInjector.getAccountManager());
    }

    public AccountController getAccountController() {
        return this.accountController;
    }
}
