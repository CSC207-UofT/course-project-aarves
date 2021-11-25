package com.aarves.bluepages.usecase.interactors;

public interface AccountInputBoundary {
    boolean isLoggedIn();
    void login(String username, String password);
    void logout();

    void register(String username, String password, String confirmPassword);
}