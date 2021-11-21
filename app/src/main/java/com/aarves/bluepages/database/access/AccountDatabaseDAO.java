package com.aarves.bluepages.database.access;

import androidx.room.*;
import com.aarves.bluepages.database.models.AccountDataEntity;

@Dao
public interface AccountDatabaseDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(AccountDataEntity accountDataEntity);

    @Delete
    void delete(AccountDataEntity accountDataEntity);

    @Query("SELECT * FROM accounts WHERE username = :username LIMIT 1")
    AccountDataEntity getByUsername(String username);
}
