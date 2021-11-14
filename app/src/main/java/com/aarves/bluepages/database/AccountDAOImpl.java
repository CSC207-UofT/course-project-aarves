package com.aarves.bluepages.database;

import com.aarves.bluepages.usecase.data.AccountDAO;

public class AccountDAOImpl implements AccountDAO {
    @Override
    public void addAccount(String username, String passwordHash) {

    }

    @Override
    public void deleteAccount(String username, String passwordHash) {

    }

    @Override
    public boolean isExistingAccount(String username) {
        return false;
    }

    @Override
    public boolean isPasswordMatch(String username, String passwordHash) {
        return false;
    }
}
