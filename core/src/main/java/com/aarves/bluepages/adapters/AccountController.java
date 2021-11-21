package com.aarves.bluepages.adapters;

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

        boolean result = this.accountManager.login(username, password);

        // TODO: Some presenter stuff
    }

    public void register(String username, String password, String confirmPassword) {
        if(this.accountManager.isLoggedIn()) {
            this.accountManager.logout();
        }

        // TODO: Some presenter stuff
        if(password.equals(confirmPassword)) {
            this.accountManager.register(username, password);
        }
        else {

        }
    }
}
