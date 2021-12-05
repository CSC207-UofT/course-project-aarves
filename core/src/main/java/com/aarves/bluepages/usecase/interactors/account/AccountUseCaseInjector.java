package com.aarves.bluepages.usecase.interactors.account;

import com.aarves.bluepages.usecase.data.account.AccountDAO;
import com.aarves.bluepages.usecase.data.account.AccountDataAccess;

import java.security.NoSuchAlgorithmException;

public class AccountUseCaseInjector {
    private final AccountManager accountManager;

    public AccountUseCaseInjector(AccountDAO accountDAO, AccountOutputBoundary accountOutput) throws NoSuchAlgorithmException {
        AccountDataBoundary accountDataAccess = new AccountDataAccess(accountDAO);
        this.accountManager = new AccountManager(accountDataAccess, accountOutput);
    }

    public AccountManager getAccountManager() {
        return this.accountManager;
    }
}
