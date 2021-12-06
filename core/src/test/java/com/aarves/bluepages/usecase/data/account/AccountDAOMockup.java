package com.aarves.bluepages.usecase.data.account;

import com.aarves.bluepages.entities.User;


import java.util.ArrayList;
import java.util.List;

public class AccountDAOMockup implements AccountDAO{

    List<User> users = new ArrayList<>();

    public void addAccount(String username, String passwordHash) {
        User u1 = new User(username, passwordHash);
        users.add(u1);

    }
    public void deleteAccount(String username, String passwordHash) {
        users.removeIf(u -> (u.getUsername().equals(username)) & (u.getPasswordHash().equals(passwordHash)));
    }

    public boolean isExistingAccount(String username) {

        if (users.isEmpty()) {
            return false;
        } else for (User u : users) {
            return ((u.getUsername()).equals(username));
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
