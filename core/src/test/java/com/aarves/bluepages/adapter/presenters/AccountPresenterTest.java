package com.aarves.bluepages.adapter.presenters;

import com.aarves.bluepages.usecase.interactors.LoginResult;
import com.aarves.bluepages.usecase.interactors.RegisterResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountPresenterTest {

    AccountPresenter ap = new AccountPresenter();
    private AccountView accountView;

    @BeforeEach
    void setUp() {
        ap.setAccountView(accountView);
    }

    @AfterEach
    void tearDown() {
    }

    // shouldnt need to test this correct?
    @Test
    void testSetAccountView() {

    }


    // how do I test this
    @Test
    void testLoginResultSuccess() {
        String username = new String("JohnDoe");
        ap.loginResult(LoginResult.SUCCESS, username);
        //assertEquals(accountView, );
    }

    @Test
    void testLoginResultFailure() {
        String username = new String("JohnDoe");
        ap.loginResult(LoginResult.FAILURE, username);
        //assertEquals("Incorrect password!", accountView);
    }

    @Test
    void testLoginResultAccNotFound() {
        String username = new String("JohnDoe");
        ap.loginResult(LoginResult.ACCOUNT_NOT_FOUND, username);
    }


    @Test
    void testRegisterResult() {
        RegisterResult rr = RegisterResult.SUCCESS;
        ap.registerResult(rr);

        RegisterResult rr2 = RegisterResult.PASSWORD_MISMATCH;
        RegisterResult rr3 = RegisterResult.SUCCESS.USERNAME_ALREADY_EXISTS;
    }
}