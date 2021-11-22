package com.aarves.bluepages.adapter.presenters;

import com.aarves.bluepages.usecase.interactors.AccountPresenter;

public class AccountPresenterImpl implements AccountPresenter {
    private final AccountView accountView;

    public AccountPresenterImpl(AccountView accountView) {
        this.accountView = accountView;
    }

    @Override
    public void loginResult(boolean result, String username) {
        String message;
        if(result) {
            message = "Welcome back " + username + "!";
            this.accountView.startMainMenu();
            this.accountView.finishActivity();
        }
        else {
            message = "Incorrect username or password!";
        }
        this.accountView.displayPopUp(message);
    }

    @Override
    public void registerResult(boolean result) {
        String message;
        if(result) {
            message = "Passwords do not match!";
        }
        else {
            message = "Account created successfully.";
            this.accountView.finishActivity();
        }
        this.accountView.displayPopUp(message);
    }
}
