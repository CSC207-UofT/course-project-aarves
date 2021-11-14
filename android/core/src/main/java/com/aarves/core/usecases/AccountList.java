package com.aarves.core.usecases;

import com.aarves.core.entities.RegisteredUser;

import java.util.HashMap;
import java.util.Map;

public class AccountList {
    private final Map<String, RegisteredUser> accounts = new HashMap<>();

    /**
     * Adds a registered user account to the accounts list.
     * @param user the RegisteredUser to be added.
     */
    public void addUser(RegisteredUser user) {
        accounts.put(user.getUsername(), user);
    }

    /**
     * Deletes a registered user account from the accounts list.
     * @param user the RegisteredUser to be deleted.
     */
    public void deleteUser(RegisteredUser user) {
        accounts.remove(user.getUsername());
    }

    /**
     * Return the user associated with the username.
     *
     * @param username the username of the user to return
     * @return the RegisteredUser reference
     */
    public RegisteredUser getUser(String username) {
        return accounts.get(username);
    }
}
