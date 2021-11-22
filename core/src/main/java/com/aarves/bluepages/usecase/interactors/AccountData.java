package com.aarves.bluepages.usecase.interactors;

import com.aarves.bluepages.entities.User;
import com.aarves.bluepages.usecase.exceptions.PermissionsFailureException;

public interface AccountData {
    void addAccount(User user);
    void deleteAccount(User user);

    User getUserAccount(String username, String passwordHash) throws PermissionsFailureException;
    boolean isExistingAccount(String username);
    boolean isPasswordMatch(String username, String passwordHash);
}