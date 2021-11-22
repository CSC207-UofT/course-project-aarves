package com.aarves.bluepages.usecase.interactors;

public interface AccountPresenter {
    void loginResult(LoginResult result, String username);
    void registerResult(RegisterResult result);
}
