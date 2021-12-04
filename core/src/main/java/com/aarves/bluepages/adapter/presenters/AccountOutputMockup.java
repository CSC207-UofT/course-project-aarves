package com.aarves.bluepages.adapter.presenters;

import com.aarves.bluepages.usecase.interactors.AccountOutputBoundary;
import com.aarves.bluepages.usecase.interactors.LoginResult;
import com.aarves.bluepages.usecase.interactors.RegisterResult;

public class AccountOutputMockup implements AccountOutputBoundary {

    private String logInResult;
    private String registerResult;


    public String getLogInResult(){
        return this.logInResult;
    }

    public String getRegisterResult(){
        return this.registerResult;
    }

    @Override
    public void loginResult(LoginResult result, String username) {
        if (result.equals(LoginResult.SUCCESS)) {
            this.logInResult = "Welcome back " + username + "!";

        } else if (result.equals(LoginResult.FAILURE)) {
            this.logInResult = "Incorrect password!";
        } else{
            this.logInResult = "Incorrect username!";
        }
    }


    @Override
    public void registerResult(RegisterResult result) {
        if (result.equals(RegisterResult.SUCCESS)) {
            this.registerResult = "Account created successfully.";

        } else if (result.equals(RegisterResult.USERNAME_ALREADY_EXISTS)) {
            this.registerResult = "Username has already been taken!";
        } else{
            this.registerResult = "Passwords do not match!";
        }

    }
}
