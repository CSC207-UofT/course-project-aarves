package com.aarves.bluepages.usecase.interactors.account;

import com.aarves.bluepages.usecase.exceptions.PermissionsFailureException;
import com.aarves.bluepages.entities.User;

public interface AccountDataBoundary {
    void addAccount(User user);
    void deleteAccount(User user);

    User getUserAccount(String username, String passwordHash) throws PermissionsFailureException;
    boolean isExistingAccount(String username);
    boolean isPasswordMatch(String username, String passwordHash);
}
