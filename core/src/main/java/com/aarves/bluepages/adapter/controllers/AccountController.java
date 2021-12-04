package com.aarves.bluepages.adapter.controllers;

import com.aarves.bluepages.usecase.interactors.account.AccountInputBoundary;

public class AccountController {
    private final AccountInputBoundary accountInput;

    public AccountController(AccountInputBoundary accountInput) {
        this.accountInput = accountInput;
    }

    public void login(String username, String password) {
        if(this.accountInput.isLoggedIn()) {
            this.accountInput.logout();
        }

        this.accountInput.login(username, password);
    }

    public void register(String username, String password, String confirmPassword) {
        if(this.accountInput.isLoggedIn()) {
            this.accountInput.logout();
        }

        this.accountInput.register(username, password, confirmPassword);
    }
}
