package com.aarves.bluepages.usecase.data.account;

import com.aarves.bluepages.usecase.interactors.account.AccountDataBoundary;
import com.aarves.bluepages.usecase.exceptions.PermissionsFailureException;
import com.aarves.bluepages.entities.User;

/**
 * Class for accessing account data through user entities, used by account use case interactors.
 */
public class AccountDataAccess implements AccountDataBoundary {
    private final AccountDAO accountDAO;

    /**
     * Constructs account data access with account data source adapter dependency.
     * @param accountDAO the account data adapter dependency
     */
    public AccountDataAccess(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    /**
     * Adds given user to data source using the data source adapter dependency.
     * @param user the user to be added
     */
    @Override
    public void addAccount(User user) {
        this.accountDAO.addAccount(user.getUsername(), user.getPasswordHash());
    }

    /**
     * Deletes given user from data source using the data source adapter dependency.
     * @param user the user to be deleted
     */
    @Override
    public void deleteAccount(User user) {
        this.accountDAO.deleteAccount(user.getUsername(), user.getPasswordHash());
    }

    /**
     * Retrieves user with given username if password hash matches using the data source adapter dependency.
     * @param username the username of user to be retrieved
     * @param passwordHash the password hash of the user to be retrieved
     * @return the user with given username and password hash
     * @throws PermissionsFailureException if given password hash does not match with that of the account
     */
    @Override
    public User getUserAccount(String username, String passwordHash) throws PermissionsFailureException {
        // Checks if account exists first
        if(!this.isExistingAccount(username)) {
            return null;
        }

        // If passwords match, then return user, otherwise throw permissions exception
        if(this.isPasswordMatch(username, passwordHash)) {
            return new User(username, passwordHash);
        }
        else {
            throw new PermissionsFailureException();
        }
    }

    /**
     * Returns whether account with given username exists using the data source adapter dependency.
     * @param username the username to be checked
     * @return whether account with given username exists
     */
    @Override
    public boolean isExistingAccount(String username) {
        return this.accountDAO.isExistingAccount(username);
    }

    /**
     * Returns whether given password hash matches with that of account with given username
     * using the data source adapter dependency.
     * @param username the username of account with password hash to be compared to
     * @param passwordHash the password hash to be checked
     * @return whether password hash matches with that of account with username, or false if account does not exist
     */
    @Override
    public boolean isPasswordMatch(String username, String passwordHash) {
        return this.accountDAO.isPasswordMatch(username, passwordHash);
    }
}
