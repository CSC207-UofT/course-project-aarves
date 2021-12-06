package com.aarves.bluepages.usecase.data.account;

import com.aarves.bluepages.entities.User;
import com.aarves.bluepages.usecase.interactors.review.ReviewRepositoryMockup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountDataAccessTest {


    /// AccountDataAccess ada;
    /// AccountDAO ao;
    ReviewRepositoryMockup rpm;

    @BeforeEach
    void setUp() {
    ///    ada = new AccountDataAccess(ao, rpm);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addAccount() {
        User new_user = new User("Natsyy", "M$a%tB1rya*i");
        ///ada.addAccount(new_user);

        ///assertEquals();
    }

    @Test
    void deleteAccount() {
    }

    @Test
    void getUserAccount() {
    }

    @Test
    void isExistingAccount() {
    }

    @Test
    void isPasswordMatch() {
    }
}