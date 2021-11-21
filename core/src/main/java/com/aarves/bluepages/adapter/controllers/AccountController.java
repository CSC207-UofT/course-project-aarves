package com.aarves.bluepages.adapter.controllers;

import com.aarves.bluepages.usecase.interactors.AccountManager;

public class AccountController {
    private final AccountManager accountManager;

    public AccountController(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void login(String username, String password) {
        if(this.accountManager.isLoggedIn()) {
            this.accountManager.logout();
        }

        this.accountManager.login(username, password);
    }

    public void register(String username, String password, String confirmPassword) {
        if(this.accountManager.isLoggedIn()) {
            this.accountManager.logout();
        }

        this.accountManager.register(username, password, confirmPassword);
    }
}
