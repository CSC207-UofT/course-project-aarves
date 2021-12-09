package com.aarves.bluepages.usecase.interactors.account;

/**
 * Interface for inputting account related data to use cases.
 */
public interface AccountInputBoundary {
    boolean isLoggedIn();
    void login(String username, String password);
    void logout();

    void register(String username, String password, String confirmPassword);
    void loadInformation();
}