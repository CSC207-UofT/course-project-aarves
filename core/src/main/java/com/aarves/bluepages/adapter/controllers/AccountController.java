package com.aarves.bluepages.adapter.controllers;

import com.aarves.bluepages.usecase.interactors.account.AccountInputBoundary;

public class AccountController {
    private final AccountInputBoundary accountInput;

    /**
     * Constructs a new AccountController object
     * @param accountInput the AccountInputBoundary interface to inject
     */
    public AccountController(AccountInputBoundary accountInput) {
        this.accountInput = accountInput;
    }

    /** Logs the user into the account if they are not already logged in. If they are already logged in, log the
     * user out.
     *
     * @param username the username of the user
     * @param password the password of the user
     */
    public void login(String username, String password) {
        if(this.accountInput.isLoggedIn()) {
            this.accountInput.logout();
        }

        this.accountInput.login(username, password);
    }

    /**
     *
     * @return returns whether the user is currently logged in.
     */
    public boolean isLoggedIn() {
        return this.accountInput.isLoggedIn();
    }

    /**
     * Logs the user out of the program.
     */
    public void logout() {
        this.accountInput.logout();
    }

    /**
     * Registers the new user's username and password into Bluepages.
     *
     * @param username the username of the user
     * @param password the password to be associated with the username
     * @param confirmPassword the password again, to ensure that both password fields match
     */
    public void register(String username, String password, String confirmPassword) {
        if(this.accountInput.isLoggedIn()) {
            this.accountInput.logout();
        }

        this.accountInput.register(username, password, confirmPassword);
    }

    /**
     * Loads the account information associated with the user for the presenter to present.
     */
    public void loadAccountInformation() {
        this.accountInput.loadInformation();
    }
}
