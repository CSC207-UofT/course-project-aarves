package com.aarves.bluepages.database;

import android.content.Context;
import androidx.room.Room;
import com.aarves.bluepages.usecase.data.DataInjector;

import java.security.NoSuchAlgorithmException;

public class DatabaseInjector {
    private final AppDatabase database;
    private final DataInjector dataInjector;

    public DatabaseInjector(Context context) throws NoSuchAlgorithmException {
        this.database = Room.databaseBuilder(context, AppDatabase.class, "database.db").build();

        AccountDAOImpl accountDAO = new AccountDAOImpl(this.database.accountDatabaseDAO());
        ReviewDAOImpl reviewDAO = new ReviewDAOImpl(this.database.reviewDatabaseDAO());

        this.dataInjector = new DataInjector(accountDAO, reviewDAO);
    }

    public AppDatabase getDatabase() {
        return this.database;
    }

    public DataInjector getDataInjector() {
        return this.dataInjector;
    }
}
