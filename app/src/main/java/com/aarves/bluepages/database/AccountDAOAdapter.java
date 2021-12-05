package com.aarves.bluepages.database;

import com.aarves.bluepages.database.access.AccountDatabaseDAO;
import com.aarves.bluepages.database.models.AccountDataEntity;
import com.aarves.bluepages.usecase.data.account.AccountDAO;

public class AccountDAOAdapter implements AccountDAO {
    private final AccountDatabaseDAO accountDatabaseDAO;

    public AccountDAOAdapter(AccountDatabaseDAO accountDatabaseDAO) {
        this.accountDatabaseDAO = accountDatabaseDAO;
    }

    @Override
    public void addAccount(String username, String passwordHash) {
        AccountDataEntity accountDataEntity = new AccountDataEntity(username, passwordHash);
        this.accountDatabaseDAO.insert(accountDataEntity);
    }

    @Override
    public void deleteAccount(String username, String passwordHash) {
        AccountDataEntity accountDataEntity = accountDatabaseDAO.getByUsername(username);

        if(accountDataEntity != null && accountDataEntity.passwordHash.equals(passwordHash)){
            this.accountDatabaseDAO.delete(accountDataEntity);
        }
    }

    @Override
    public boolean isExistingAccount(String username) {
        AccountDataEntity accountDataEntity = accountDatabaseDAO.getByUsername(username);
        return accountDataEntity != null;
    }

    @Override
    public boolean isPasswordMatch(String username, String passwordHash) {
        String accountPasswordHash = accountDatabaseDAO.getPasswordHash(username);
        return passwordHash.equals(accountPasswordHash);
    }
}
