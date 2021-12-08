package com.aarves.bluepages.database.access;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.OnConflictStrategy;

import com.aarves.bluepages.database.models.AccountDataEntity;

/**
 * Data access object for the accounts table, which gets automatically implemented by Room.
 */
@Dao
public interface AccountDatabaseDAO {
    /**
     * Inserts the data entity as a record into the accounts table.
     * Replaces existing record if there is a conflict.
     * @param accountDataEntity the data entity corresponding to the account to be inserted
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(AccountDataEntity accountDataEntity);

    /**
     * Deletes the record corresponding to the data entity from the accounts table.
     * @param accountDataEntity the data entity corresponding to the account to be deleted
     */
    @Delete
    void delete(AccountDataEntity accountDataEntity);

    /**
     * Retrieves account data corresponding to given username.
     * @param username the username of the account to be retrieved
     * @return the account data entity corresponding to the username, or null if account does not exist
     */
    @Query("SELECT * FROM accounts WHERE username = :username LIMIT 1")
    AccountDataEntity getByUsername(String username);

    /**
     * Retrieves the hashed password corresponding to given username.
     * @param username the username of the password hash to be retrieved
     * @return the hashed password corresponding to the username, or null if account does not exist
     */
    @Query("SELECT password_hash FROM accounts WHERE username = :username LIMIT 1")
    String getPasswordHash(String username);
}
