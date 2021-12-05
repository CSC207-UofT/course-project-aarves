package com.aarves.bluepages.adapter.controllers;

import com.aarves.bluepages.usecase.interactors.account.AccountInputBoundary;
import com.aarves.bluepages.entities.User;

public class AccountInputMockup implements AccountInputBoundary {
    private String username;
    private String password;
    private String confirmPassword;

    private boolean loggedIn;
    private boolean loaded;

    @Override
    public boolean isLoggedIn() {
        return this.loggedIn;
    }

    @Override
    public void login(String username, String password) {
        this.username = username;
        this.password = password;
        this.loggedIn = true;
    }

    @Override
    public void logout() {
        this.loggedIn = false;
    }

    @Override
    public void register(String username, String password, String confirmPassword) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    @Override
    public void loadInformation() {
        this.loaded = true;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public boolean isLoaded() {
        return this.loaded;
    }
}
