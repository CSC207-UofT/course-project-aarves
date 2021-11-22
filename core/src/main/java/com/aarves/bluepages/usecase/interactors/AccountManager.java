package com.aarves.bluepages.usecase.interactors;

import com.aarves.bluepages.entities.User;
import com.aarves.bluepages.usecase.exceptions.PermissionsFailureException;

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
        try {
            this.user = this.accountData.getUserAccount(username, passwordHash);

            if(this.user != null) {
                result = LoginResult.SUCCESS;
            }
            else {
                result = LoginResult.ACCOUNT_NOT_FOUND;
            }
        }
        catch(PermissionsFailureException exception) {
            this.user = null;
            result = LoginResult.FAILURE;
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
        boolean result;
        if(password.equals(confirmPassword)) {
            User user = new User(username, this.hashPassword(password)); // TODO: Doesn't check if username already exists lol
            this.accountData.addAccount(user);
            result = true;
        }
        else {
            result = false;
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
