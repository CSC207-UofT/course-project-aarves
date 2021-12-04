package com.aarves.bluepages.adapter.presenters;

import com.aarves.bluepages.usecase.interactors.account.LoginResult;
import com.aarves.bluepages.usecase.interactors.account.RegisterResult;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class AccountPresenterTest {

    AccountOutputMockup accountOutput;

    @BeforeEach
    void setUp() {
        this.accountOutput = new AccountOutputMockup();
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void testLoginResultSuccess() {
        String username = "JohnDoe";
        accountOutput.loginResult(LoginResult.SUCCESS, username);
        assertEquals("Welcome back JohnDoe!", accountOutput.getLogInResult() );
    }

    @Test
    void testLoginResultFailure() {
        String username = "JohnDoe";
        accountOutput.loginResult(LoginResult.FAILURE, username);
        assertEquals("Incorrect password!", accountOutput.getLogInResult());
    }

    @Test
    void testLoginResultAccNotFound() {
        String username = "JohnDoe";
        accountOutput.loginResult(LoginResult.ACCOUNT_NOT_FOUND, username);
        assertEquals("Incorrect username!", accountOutput.getLogInResult());
    }


    @Test
    void testSuccessRegisterResult() {
        accountOutput.registerResult(RegisterResult.SUCCESS);
        assertEquals("Account created successfully.", accountOutput.getRegisterResult());
    }

    @Test
    void testUserTakenRegisterResult() {
        accountOutput.registerResult(RegisterResult.USERNAME_ALREADY_EXISTS);
        assertEquals("Username has already been taken!", accountOutput.getRegisterResult());
    }

    @Test
    void testMismatchRegisterResult() {
        accountOutput.registerResult(RegisterResult.PASSWORD_MISMATCH);
        assertEquals("Passwords do not match!", accountOutput.getRegisterResult());
    }
}