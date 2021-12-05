package com.aarves.bluepages.adapter.presenters;

import com.aarves.bluepages.usecase.interactors.account.AccountOutputBoundary;
import com.aarves.bluepages.usecase.interactors.account.LoginResult;
import com.aarves.bluepages.usecase.interactors.account.RegisterResult;

public class AccountPresenter implements AccountOutputBoundary {
    private AccountView accountView;
    private AccountMenuView accountMenuView;

    @Override
    public void loginResult(LoginResult result, String username) {
        if(this.verifyDependencies()) {
            String message;
            switch(result) {
                case SUCCESS:
                    message = "Welcome back " + username + "!";
                    this.accountView.startMainMenu();
                    this.accountView.finishActivity();
                    break;
                case FAILURE:
                    message = "Incorrect password!";
                    break;
                case ACCOUNT_NOT_FOUND:
                    message = "Incorrect username!";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + result);
            }
            this.accountView.displayPopUp(message);
        }
    }

    @Override
    public void registerResult(RegisterResult result) {
        if(this.verifyDependencies()) {
            String message;
            switch(result) {
                case SUCCESS:
                    message = "Account created successfully.";
                    this.accountView.finishActivity();
                    break;
                case USERNAME_ALREADY_EXISTS:
                    message = "Username has already been taken!";
                    break;
                case PASSWORD_MISMATCH:
                    message = "Passwords do not match!";
                    break;
                case BAD_USERNAME_FORMAT:
                    message = "Bad username format!";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + result);
            }
            this.accountView.displayPopUp(message);
        }
    }

    public void displayLogout() {
        if(this.verifyDependencies()) {
            this.accountView.displayPopUp("Account logged out successfully.");

            this.accountView.returnToAccessMenu();
            this.accountView.finishActivity();
        }
    }

    @Override
    public void displayInformation(String username) {
        if(this.verifyMenuDependencies()) {
            if(!username.isEmpty()) {
                this.accountMenuView.displayAccountInformation(username);
            }
            else {
                this.accountMenuView.displayAccountInformation("Guest User");
            }
        }
    }

    public void setAccountView(AccountView accountView) {
        this.accountView = accountView;
    }

    public void setAccountMenuView(AccountMenuView accountMenuView) {
        this.accountMenuView = accountMenuView;
    }

    private boolean verifyDependencies() {
        return this.accountView != null;
    }

    private boolean verifyMenuDependencies() {
        return this.accountMenuView != null;
    }
}
