package com.aarves.bluepages.usecase.interactors.account;

public class AccountOutputBoundaryMockup implements AccountOutputBoundary {

    boolean isDisplayInformation;
    boolean logout;
    private LoginResult loginResult;
    private String username;
    private RegisterResult registerResult;

    public void loginResult(LoginResult result, String username) {
        this.loginResult = result;
        this.username = username;
    }

    public void registerResult(RegisterResult result) {
        this.registerResult = result;
    }

    public void displayLogout() {
        this.logout = true;
    }

    public void displayInformation(String username) {
        this.isDisplayInformation = true;
    }

    public LoginResult getLoginResult() {
        return this.loginResult;
    }

    public String getUsername() {
        return this.username;
    }

    public RegisterResult getRegisterResult() {
        return this.registerResult;
    }

}
