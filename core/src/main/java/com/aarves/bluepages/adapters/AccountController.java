package com.aarves.bluepages.adapters;

import com.aarves.bluepages.usecase.interactors.AccountManager;

public class AccountController {
    private final AccountManager accountManager;

    public AccountController(AccountManager accountManager) {
        this.accountManager = accountManager;
    }
}
