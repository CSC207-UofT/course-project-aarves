package com.aarves.bluepages.usecase.interactors.account;

import com.aarves.bluepages.usecase.exceptions.PermissionsFailureException;
import com.aarves.bluepages.entities.User;
import com.aarves.bluepages.usecase.interactors.Observable;
import com.aarves.bluepages.usecase.interactors.Observer;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class AccountManager implements AccountInputBoundary, Observable<User> {
    private final MessageDigest passwordDigest;
    private final AccountOutputBoundary accountOutput;
    private final AccountDataBoundary accountData;

    private final List<Observer<User>> observers;
    private User user;

    public AccountManager(AccountDataBoundary accountData, AccountOutputBoundary accountOutput) throws NoSuchAlgorithmException {
        this.passwordDigest = MessageDigest.getInstance("SHA-256");
        this.accountOutput = accountOutput;
        this.accountData = accountData;

        this.observers = new ArrayList<>();
    }

    @Override
    public boolean isLoggedIn() {
        return this.user != null;
    }

    /**
     * Returns whether the login was successful.
     *
     * @param username the user's inputted username
     * @param password the user's inputted password
     */
    @Override
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
        this.accountOutput.loginResult(result, username);
        this.notifyObservers();
    }

    @Override
    public void logout() {
        this.user = null;
        this.notifyObservers();
    }

    /**
     * Adds a User to the AccountManager. An existing username will never be passed in.
     *
     * @param username the user's username
     * @param password the user's password
     */
    @Override
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
        this.accountOutput.registerResult(result);
    }

    @Override
    public void addObserver(Observer<User> observer) {
        this.observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer<User> observer) {
        this.observers.remove(observer);
    }

    @Override
    public void clearObservers() {
        this.observers.clear();
    }

    @Override
    public void notifyObservers() {
        for(Observer<User> observer : this.observers) {
            observer.update(this.user);
        }
    }

    /**
     * Deletes a user from the AccountManager.
     */
    public void deleteUser() {
        this.accountData.deleteAccount(this.user);
        this.user = null;
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
     * Returns the User associated with the account
     * @return  User associated with the account
     */
    public User getUser() {
        return this.user;
    }

    private String hashPassword(String password) {
        byte[] hash = this.passwordDigest.digest(password.getBytes(StandardCharsets.UTF_8));
        return new String(hash, StandardCharsets.UTF_8);
    }
}
