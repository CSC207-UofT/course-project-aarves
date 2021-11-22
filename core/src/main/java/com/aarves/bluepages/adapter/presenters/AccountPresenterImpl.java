package com.aarves.bluepages.adapter.presenters;

import com.aarves.bluepages.usecase.interactors.AccountPresenter;

public class AccountPresenterImpl implements AccountPresenter {
    private AccountView accountView;

    public void setAccountView(AccountView accountView) {
        this.accountView = accountView;
    }

    @Override
    public void loginResult(boolean result, String username) {
        if(this.verifyDependencies()) {
            String message;
            if (result) {
                message = "Welcome back " + username + "!";
                this.accountView.startMainMenu();
                this.accountView.finishActivity();
            } else {
                message = "Incorrect username or password!";
            }
            this.accountView.displayPopUp(message);
        }
    }

    @Override
    public void registerResult(boolean result) {
        if(this.verifyDependencies()) {
            String message;
            if (result) {
                message = "Account created successfully.";
                this.accountView.finishActivity();
            } else {
                message = "Passwords do not match!";
            }
            this.accountView.displayPopUp(message);
        }
    }

    private boolean verifyDependencies() {
        return this.accountView != null;
    }
}
