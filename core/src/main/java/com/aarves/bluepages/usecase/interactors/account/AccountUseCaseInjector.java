package com.aarves.bluepages.usecase.interactors.account;

import com.aarves.bluepages.usecase.data.account.AccountDAO;
import com.aarves.bluepages.usecase.data.account.AccountDataAccess;

import java.security.NoSuchAlgorithmException;

/**
 * The injector class for all account dependencies on the use cases layer.
 */
public class AccountUseCaseInjector {
    private final AccountManager accountManager;

    public AccountUseCaseInjector(AccountDAO accountDAO, AccountOutputBoundary accountOutput) throws NoSuchAlgorithmException {
        // Creates new data access class with adapter dependency
        AccountDataBoundary accountDataAccess = new AccountDataAccess(accountDAO);
        // Injects data access and output boundary into use case
        this.accountManager = new AccountManager(accountDataAccess, accountOutput);
    }

    public AccountManager getAccountManager() {
        return this.accountManager;
    }
}
