package com.aarves.bluepages.adapter.presenters;

import com.aarves.bluepages.usecase.interactors.account.LoginResult;
import com.aarves.bluepages.usecase.interactors.account.RegisterResult;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class AccountPresenterTest {
    private AccountPresenter accountPresenter;
    private AccountViewMockup accountView;
    private AccountMenuViewMockup accountMenuViewMockup;

    @BeforeEach
    void setUp() {
        this.accountView = new AccountViewMockup();
        this.accountPresenter = new AccountPresenter();
        this.accountMenuViewMockup = new AccountMenuViewMockup();
        this.accountPresenter.setAccountMenuView(accountMenuViewMockup);
        this.accountPresenter.setAccountView(accountView);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void loginResultSuccessDisplay() {
        this.accountPresenter.loginResult(LoginResult.SUCCESS, "username");
        Assertions.assertEquals("Welcome back username!", this.accountView.getPopUpDisplay());

    }

    @Test
    void loginResultSuccessActivity() {
        this.accountPresenter.loginResult(LoginResult.SUCCESS, "username");
        Assertions.assertTrue(this.accountView.isStartActivity());
        Assertions.assertTrue(this.accountView.isFinishActivity());
    }

    @Test
    void loginResultFailureDisplay() {
        this.accountPresenter.loginResult(LoginResult.FAILURE, "username");
        Assertions.assertEquals("Incorrect password!", this.accountView.getPopUpDisplay());
    }

    @Test
    void loginResultFailureActivity() {
        this.accountPresenter.loginResult(LoginResult.FAILURE, "username");
        Assertions.assertFalse(this.accountView.isStartActivity());
        Assertions.assertFalse(this.accountView.isFinishActivity());
    }

    @Test
    void loginResultAccNotFoundDisplay() {
        this.accountPresenter.loginResult(LoginResult.ACCOUNT_NOT_FOUND, "username");
        Assertions.assertEquals("Incorrect username!", this.accountView.getPopUpDisplay());
    }

    @Test
    void loginResultAccNotFoundActivity() {
        this.accountPresenter.loginResult(LoginResult.ACCOUNT_NOT_FOUND, "username");
        Assertions.assertFalse(this.accountView.isStartActivity());
        Assertions.assertFalse(this.accountView.isFinishActivity());
    }

    @Test
    void registerResultSuccessDisplay() {
        this.accountPresenter.registerResult(RegisterResult.SUCCESS);
        Assertions.assertTrue(this.accountView.isFinishActivity());
        Assertions.assertEquals("Account created successfully.", this.accountView.getPopUpDisplay());
    }

    @Test
    void registerResultSuccessActivity() {
        this.accountPresenter.registerResult(RegisterResult.SUCCESS);
        Assertions.assertTrue(this.accountView.isFinishActivity());
    }

    @Test
    void registerResultUserTakenDisplay() {
        this.accountPresenter.registerResult(RegisterResult.USERNAME_ALREADY_EXISTS);
        Assertions.assertEquals("Username has already been taken!", this.accountView.getPopUpDisplay());
    }

    @Test
    void registerResultPassMismatchDisplay() {
        this.accountPresenter.registerResult(RegisterResult.PASSWORD_MISMATCH);
        Assertions.assertEquals("Passwords do not match!", this.accountView.getPopUpDisplay());
    }

    @Test
    void testDisplayLogoutDisplay() {
        this.accountPresenter.displayLogout();
        Assertions.assertEquals(this.accountView.getPopUpDisplay(), "Account logged out successfully.");
    }


    @Test
    void testDisplayLogoutActivity() {
        this.accountPresenter.displayLogout();
        Assertions.assertTrue(this.accountView.isReturnedToAccessMenu());
        Assertions.assertTrue(this.accountView.isFinishActivity());
    }

    @Test
    void testDisplayLogoutDisplayNoAccMenu() {
        this.accountPresenter.setAccountView(null);
        this.accountPresenter.displayLogout();
        Assertions.assertEquals(this.accountMenuViewMockup.popUpDisplay, "Account logged out successfully.");
    }


    @Test
    void testDisplayLogoutActivityNoAccMenu() {
        this.accountPresenter.setAccountView(null);
        this.accountPresenter.displayLogout();
        Assertions.assertTrue(this.accountMenuViewMockup.activityFinished);
    }

    @Test
    void testDisplayInfo() {
        this.accountPresenter.displayInformation("username");
        Assertions.assertEquals(this.accountMenuViewMockup.accountInfoDisplay, "username");
    }

}