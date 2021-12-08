package com.aarves.bluepages.usecase.interactors.account;

import com.aarves.bluepages.entities.User;
import com.aarves.bluepages.usecase.exceptions.PermissionsFailureException;

import java.util.ArrayList;
import java.util.List;

public class AccountDataBoundaryMockup implements AccountDataBoundary{

    List<User> users = new ArrayList<>();

    public void addAccount(User user) {
        users.add(user);
    }

    public void deleteAccount(User user) {
        users.remove(user);
    }

    public User getUserAccount(String username, String passwordHash) throws PermissionsFailureException {
        for (User u: users) {
            if ((u.getUsername().equals(username))) {
                return u;
            }
        }
        throw new PermissionsFailureException();
    }

    public boolean isExistingAccount(String username) {
        for (User u: users) {
            if (u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPasswordMatch(String username, String passwordHash) {
        for (User u: users) {
            if (u.getPasswordHash().equals(passwordHash)) {
                return true;
            }
        }
        return false;
    }
}
