package com.aarves.bluepages.usecase.interactors.account;

import com.aarves.bluepages.usecase.exceptions.PermissionsFailureException;
import com.aarves.bluepages.entities.User;

/**
 * Interface which allows account use case interactors to access to account data.
 */
public interface AccountDataBoundary {
    /**
     * Adds given user to data source.
     * @param user the user to be added
     */
    void addAccount(User user);

    /**
     * Deletes given user from data source.
     * @param user the user to be deleted
     */
    void deleteAccount(User user);

    /**
     * Retrieves user with given username if password hash matches.
     * @param username the username of user to be retrieved
     * @param passwordHash the password hash of the user to be retrieved
     * @return the user with given username and password hash
     * @throws PermissionsFailureException if given password hash does not match with that of the account
     */
    User getUserAccount(String username, String passwordHash) throws PermissionsFailureException;

    /**
     * Returns whether account with given username exists.
     * @param username the username to be checked
     * @return whether account with given username exists
     */
    boolean isExistingAccount(String username);

    /**
     * Returns whether given password hash matches with that of account with given username.
     * @param username the username of account with password hash to be compared to
     * @param passwordHash the password hash to be checked
     * @return whether password hash matches with that of account with username, or false if account does not exist
     */
    boolean isPasswordMatch(String username, String passwordHash);
}
