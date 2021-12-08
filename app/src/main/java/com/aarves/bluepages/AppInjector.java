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

/**
 * The injector class for all app dependencies on the frameworks layer.
 */
public class AppInjector {
    private final AdapterInjector adapterInjector;

    /**
     * Injects all app dependencies on the framework layer.
     * @param context The application context to be initialized within
     * @throws NoSuchAlgorithmException if the hashing algorithm used does not exist
     */
    public AppInjector(Context context) throws NoSuchAlgorithmException {
        AppDatabase database;

        // Initialize database from sample database class if it does not exist already
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

        // Initialize data access adapters from the Room data access object dependencies
        AccountDAO accountDAO = new AccountDAOAdapter(database.accountDatabaseDAO());
        LocationDAO locationDAO = new LocationDAOAdapter(database.bookmarkDatabaseDAO(), database.locationDatabaseDAO());
        ReviewDAO reviewDAO = new ReviewDAOAdapter(database.reviewDatabaseDAO());

        // Injects data access adapters into the interface adapters layer
        this.adapterInjector = new AdapterInjector(accountDAO, locationDAO, reviewDAO);
    }

    /**
     * Returns the injector for the interface adapters layer
     * @return the injector for the interface adapters layer
     */
    public AdapterInjector getAdapterInjector() {
        return this.adapterInjector;
    }
}
