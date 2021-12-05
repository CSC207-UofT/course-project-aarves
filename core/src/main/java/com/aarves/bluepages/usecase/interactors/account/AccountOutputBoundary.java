package com.aarves.bluepages.usecase.interactors.account;

public interface AccountOutputBoundary {
    void loginResult(LoginResult result, String username);
    void registerResult(RegisterResult result);
    void displayLogout();

    void displayInformation(String username);
}
