package com.aarves.bluepages.adapter.presenters;

import com.aarves.bluepages.usecase.interactors.account.AccountOutputBoundary;
import com.aarves.bluepages.usecase.interactors.account.LoginResult;
import com.aarves.bluepages.usecase.interactors.account.RegisterResult;

public class AccountPresenter implements AccountOutputBoundary {
    private AccountView accountView;
    private AccountMenuView accountMenuView;


    /**
     * Provides the AccountView with the display message based on the result of the user's login.
     * @param result the result of the login based on the information for username/password submitted by the user
     * @param username the username of the user
     */
    @Override
    public void loginResult(LoginResult result, String username) {
        if(this.accountView != null) {
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

    /**
     * Provides the AccountView with the display message based on the result of the user's registration.
     * @param result the result of the registration based on the user's inputted username/password
     */
    @Override
    public void registerResult(RegisterResult result) {
        if(this.accountView != null) {
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

    /**
     * Displays the logout message to the user.
     */
    public void displayLogout() {
        if(this.accountView != null) {
            this.accountView.displayPopUp("Account logged out successfully.");
            this.accountView.returnToAccessMenu();
            this.accountView.finishActivity();
        }
        else if(this.accountMenuView != null) {
            this.accountMenuView.displayPopUp("Account logged out successfully.");
            this.accountMenuView.finishActivity();
        }
    }

    /**
     * Gives the accountMenuView the user's information to display - their username, if they are a registered user,
     * and "Guest User", if they are not.
     * @param username the username of the user
     */
    @Override
    public void displayInformation(String username) {
        if(this.accountMenuView != null) {
            if(!username.isEmpty()) {
                this.accountMenuView.displayAccountInformation(username);
            }
            else {
                this.accountMenuView.displayAccountInformation("Guest User");
            }
        }
    }

    /**
     * Sets the AccountView interface.
     * @param accountView the AccountView interface to set.
     */
    public void setAccountView(AccountView accountView) {
        this.accountView = accountView;
    }

    /**
     * Sets the AccountMenuView interface for this AccountPresenter.
     * @param accountMenuView the AccountMenuView interface to set.
     */
    public void setAccountMenuView(AccountMenuView accountMenuView) {
        this.accountMenuView = accountMenuView;
    }
}
