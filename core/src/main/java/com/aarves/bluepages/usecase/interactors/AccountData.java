package com.aarves.bluepages.usecase.interactors;

import com.aarves.bluepages.entities.User;

public interface AccountData {
    void addAccount(User user);
    void deleteAccount(User user);

    User getAccount(String username, String passwordHash) throws LoginFailureException;
    boolean isExistingAccount(String username);
    boolean isPasswordMatch(String username, String passwordHash);
}
