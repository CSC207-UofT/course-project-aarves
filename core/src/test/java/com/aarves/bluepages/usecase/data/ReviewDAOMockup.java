package com.aarves.bluepages.usecase.data;

import com.aarves.bluepages.entities.User;
import com.aarves.bluepages.usecase.data.account.AccountDAO;


import java.util.ArrayList;
import java.util.List;

class AccountDAOMockup implements AccountDAO {

    List<User> users = new ArrayList<>();

    public void addAccount(String username, String passwordHash) {
        User u1 = new User(username, passwordHash);
        users.add(u1);

    }
    public void deleteAccount(String username, String passwordHash) {
        User u1 = new User(username, passwordHash);
        users.removeIf(u -> u1 == u);
    }

    public boolean isExistingAccount(String username) {
        for (User u: users) {
            if (users.contains(u)) {
                return true;
            }
        }
        return false;
    }
    public boolean isPasswordMatch(String username, String passwordHash) {
        User u1 = new User(username, passwordHash);
        for (User u: users) {
            if ((u1.getPasswordHash()).equals(u.getPasswordHash())){
                return true;
            }
        }
        return false;
    }
}