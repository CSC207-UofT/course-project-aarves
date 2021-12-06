package com.aarves.bluepages;

import android.content.Context;
import androidx.room.Room;

import com.aarves.bluepages.adapter.AdapterInjector;
import com.aarves.bluepages.database.AppDatabase;
import com.aarves.bluepages.database.AccountDAOAdapter;
import com.aarves.bluepages.database.LocationDAOAdapter;
import com.aarves.bluepages.database.ReviewDAOAdapter;
import com.aarves.bluepages.usecase.data.account.AccountDAO;
import com.aarves.bluepages.usecase.data.location.LocationDAO;
import com.aarves.bluepages.usecase.data.review.ReviewDAO;

import java.security.NoSuchAlgorithmException;

public class AppInjector {
    private final AdapterInjector adapterInjector;

    public AppInjector(Context context) throws NoSuchAlgorithmException {
        AppDatabase database;

        if(!context.getDatabasePath("database.db").exists()) {
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

        AccountDAO accountDAO = new AccountDAOAdapter(database.accountDatabaseDAO());
        LocationDAO locationDAO = new LocationDAOAdapter(database.bookmarkDatabaseDAO(), database.locationDatabaseDAO());
        ReviewDAO reviewDAO = new ReviewDAOAdapter(database.reviewDatabaseDAO());

        this.adapterInjector = new AdapterInjector(accountDAO, locationDAO, reviewDAO);
    }

    public AdapterInjector getAdapterInjector() {
        return this.adapterInjector;
    }
}
