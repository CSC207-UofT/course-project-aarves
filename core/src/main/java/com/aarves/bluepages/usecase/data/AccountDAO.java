package com.aarves.bluepages.usecase.data;

public interface AccountDAO {
    void addAccount(String username, String passwordHash);
    void deleteAccount(String username, String passwordHash);

    boolean isExistingAccount(String username);
    boolean isPasswordMatch(String username, String passwordHash);
}
