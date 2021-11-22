package com.aarves.bluepages.usecase.interactors;

public interface AccountPresenter {
    void loginResult(boolean result, String username);
    void registerResult(boolean result);
}
