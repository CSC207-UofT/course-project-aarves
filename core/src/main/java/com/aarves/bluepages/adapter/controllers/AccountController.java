package com.aarves.bluepages.adapter.controllers;

import com.aarves.bluepages.usecase.interactors.AccountInputBoundary;

public class AccountController {
    private final AccountInputBoundary accountInputBoundary;

    public AccountController(AccountInputBoundary accountInputBoundary) {
        this.accountInputBoundary = accountInputBoundary;
    }

    public void login(String username, String password) {
        if(this.accountInputBoundary.isLoggedIn()) {
            this.accountInputBoundary.logout();
        }

        this.accountInputBoundary.login(username, password);
    }

    public void register(String username, String password, String confirmPassword) {
        if(this.accountInputBoundary.isLoggedIn()) {
            this.accountInputBoundary.logout();
        }

        this.accountInputBoundary.register(username, password, confirmPassword);
    }
}
