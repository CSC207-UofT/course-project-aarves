package com.aarves.bluepages;

import android.content.Context;
import androidx.room.Room;

import com.aarves.bluepages.adapter.AdapterInjector;
import com.aarves.bluepages.database.AppDatabase;
import com.aarves.bluepages.database.AccountDAOAdapter;
import com.aarves.bluepages.database.ReviewDAOAdapter;

import java.security.NoSuchAlgorithmException;

public class AppInjector {
    private final AdapterInjector adapterInjector;

    public AppInjector(Context context) throws NoSuchAlgorithmException {
        AppDatabase database;
        context.deleteDatabase("database.db"); // TODO: Remove later, currently for testing only
        if(context.getDatabasePath("database.db").exists()) { // TODO: Re-add NOT
            database = Room.databaseBuilder(context, AppDatabase.class, "database.db")
                           .createFromAsset("database/sample.db")
                           .allowMainThreadQueries()
                           .build();
        }
        else {
            database = Room.databaseBuilder(context, AppDatabase.class, "database.db")
                           .allowMainThreadQueries()
                           .build();
        }

        AccountDAOAdapter accountDAO = new AccountDAOAdapter(database.accountDatabaseDAO());
        ReviewDAOAdapter reviewDAO = new ReviewDAOAdapter(database.reviewDatabaseDAO());

        this.adapterInjector = new AdapterInjector(accountDAO, reviewDAO);
    }

    public AdapterInjector getAdapterInjector() {
        return this.adapterInjector;
    }
}
