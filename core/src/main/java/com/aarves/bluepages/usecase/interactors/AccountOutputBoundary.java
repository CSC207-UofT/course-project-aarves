package com.aarves.bluepages.usecase.interactors;

public interface AccountOutputBoundary {
    void loginResult(LoginResult result, String username);
    void registerResult(RegisterResult result);
}
