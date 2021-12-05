package com.aarves.bluepages.adapter.presenters;

public interface AccountView {
    void displayPopUp(String message);

    void startMainMenu();
    void returnToAccessMenu();

    void finishActivity();
}
