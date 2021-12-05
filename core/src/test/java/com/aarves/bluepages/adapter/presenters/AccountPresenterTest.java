package com.aarves.bluepages.adapter.presenters;

import com.aarves.bluepages.usecase.interactors.LoginResult;
import com.aarves.bluepages.usecase.interactors.RegisterResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountPresenterTest {


    AccountPresenter accountPresenter;
    AccountViewMockup accountView;

    @BeforeEach
    void setUp() {
        accountView = new AccountViewMockup();
        accountPresenter = new AccountPresenter();
        accountPresenter.setAccountView(accountView);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void loginResultSuccessDisplay() {
        accountPresenter.loginResult(LoginResult.SUCCESS, "username");
        assertEquals("Welcome back username!", accountView.getPopUpDisplay());

    }

    @Test
    void loginResultSuccessActivity() {
        accountPresenter.loginResult(LoginResult.SUCCESS, "username");
        assertTrue(accountView.startActivity);
        assertTrue(accountView.finishActivity);
    }

    @Test
    void loginResultFailureDisplay() {
        accountPresenter.loginResult(LoginResult.FAILURE, "username");
        assertEquals("Incorrect password!", accountView.getPopUpDisplay());
    }

    @Test
    void loginResultFailureActivity() {
        accountPresenter.loginResult(LoginResult.FAILURE, "username");
        assertFalse(accountView.startActivity);
        assertFalse(accountView.finishActivity);
    }

    @Test
    void loginResultAccNotFoundDisplay() {
        accountPresenter.loginResult(LoginResult.ACCOUNT_NOT_FOUND, "username");
        assertEquals("Incorrect username!", accountView.getPopUpDisplay());
    }

    @Test
    void loginResultAccNotFoundActivity() {
        accountPresenter.loginResult(LoginResult.ACCOUNT_NOT_FOUND, "username");
        assertFalse(accountView.startActivity);
        assertFalse(accountView.finishActivity);
    }

    @Test
    void registerResultSuccessDisplay() {
        accountPresenter.registerResult(RegisterResult.SUCCESS);
        assertTrue(accountView.finishActivity);
        assertEquals("Account created successfully.", accountView.getPopUpDisplay());
    }

    @Test
    void registerResultSuccessActivity() {
        accountPresenter.registerResult(RegisterResult.SUCCESS);
        assertTrue(accountView.finishActivity);
    }

    @Test
    void registerResultUserTakenDisplay() {
        accountPresenter.registerResult(RegisterResult.USERNAME_ALREADY_EXISTS);
        assertEquals("Username has already been taken!", accountView.getPopUpDisplay());
    }

    @Test
    void registerResultPassMismatchDisplay() {
        accountPresenter.registerResult(RegisterResult.PASSWORD_MISMATCH);
        assertEquals("Passwords do not match!", accountView.getPopUpDisplay());
    }

}