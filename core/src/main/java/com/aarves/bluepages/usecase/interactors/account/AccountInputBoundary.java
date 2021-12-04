package com.aarves.bluepages.usecase.interactors.account;

import com.aarves.bluepages.adapter.controllers.AccountController;
import com.aarves.bluepages.entities.User;

public interface AccountInputBoundary {
    boolean isLoggedIn();
    void login(String username, String password);
    void logout();

    void register(String username, String password, String confirmPassword);

    // TODO: Fix Later
    User getUser();
}