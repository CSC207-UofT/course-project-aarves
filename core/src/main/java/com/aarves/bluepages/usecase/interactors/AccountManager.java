package com.aarves.bluepages.usecase.interactors;

import com.aarves.bluepages.usecase.exceptions.PermissionsFailureException;
import com.aarves.bluepages.entities.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AccountManager {
    private final MessageDigest passwordDigest;
    private final AccountPresenter accountPresenter;
    private final AccountData accountData;

    private User user;

    public AccountManager(AccountData accountData, AccountPresenter accountPresenter) throws NoSuchAlgorithmException {
        this.passwordDigest = MessageDigest.getInstance("SHA-256");
        this.accountPresenter = accountPresenter;
        this.accountData = accountData;
    }

    /**
     * Returns the User associated with the account
     * @return  User associated with the account
     */
    public User getUser() {
        return this.user;
    }

    public boolean isLoggedIn() {
        return this.user != null;
    }

    /**
     * Checks and returns if the account already exists.
     *
     * @param username the username of the user
     * @return true if the account already exists in accounts
     */
    public boolean isExistingAccount(String username){
        return this.accountData.isExistingAccount(username);
    }

    /**
     * Returns whether the login was successful.
     *
     * @param username the user's inputted username
     * @param password the user's inputted password
     */
    public void login(String username, String password){
        String passwordHash = this.hashPassword(password);
        LoginResult result;
        if(this.isExistingAccount(username)) {
            try {
                this.user = this.accountData.getUserAccount(username, passwordHash);
                result = LoginResult.SUCCESS;
            }
            catch (PermissionsFailureException exception) {
                this.user = null;
                result = LoginResult.FAILURE;
            }
        }
        else {
            result = LoginResult.ACCOUNT_NOT_FOUND;
        }
        this.accountPresenter.loginResult(result, username);
    }

    public void logout() {
        this.user = null;
    }

    /**
     * Adds a User to the AccountManager. An existing username will never be passed in.
     *
     * @param username the user's username
     * @param password the user's password
     */
    public void register(String username, String password, String confirmPassword){
        RegisterResult result;
        if(this.isExistingAccount(username)) {
            result = RegisterResult.USERNAME_ALREADY_EXISTS;
        }
        else if(!password.equals(confirmPassword)) {
            result = RegisterResult.PASSWORD_MISMATCH;
        }
        else {
            User user = new User(username, this.hashPassword(password));
            this.accountData.addAccount(user);
            result = RegisterResult.SUCCESS;
        }
        this.accountPresenter.registerResult(result);
    }

    /**
     * Deletes a user from the AccountManager.
     */
    public void deleteUser() {
        this.accountData.deleteAccount(this.user);
        this.user = null;
    }

    private String hashPassword(String password) {
        byte[] hash = this.passwordDigest.digest(password.getBytes(StandardCharsets.UTF_8));
        return new String(hash, StandardCharsets.UTF_8);
    }
}
