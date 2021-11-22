package com.aarves.bluepages;

import android.content.Context;
import androidx.room.Room;

import com.aarves.bluepages.adapter.AdapterInjector;
import com.aarves.bluepages.database.AccountDAOImpl;
import com.aarves.bluepages.database.AppDatabase;
import com.aarves.bluepages.database.ReviewDAOImpl;

import java.security.NoSuchAlgorithmException;

public class AppInjector {
    private final AdapterInjector adapterInjector;

    public AppInjector(Context context) throws NoSuchAlgorithmException {
        AppDatabase database = Room.databaseBuilder(context, AppDatabase.class, "database.db")
                .allowMainThreadQueries()
                .build();

        AccountDAOImpl accountDAO = new AccountDAOImpl(database.accountDatabaseDAO());
        ReviewDAOImpl reviewDAO = new ReviewDAOImpl(database.reviewDatabaseDAO());

        this.adapterInjector = new AdapterInjector(accountDAO, reviewDAO);
    }

    public AdapterInjector getAdapterInjector() {
        return this.adapterInjector;
    }
}