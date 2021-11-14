package database;

import com.aarves.bluepages.usecase.data.DataInjector;

import java.security.NoSuchAlgorithmException;

public class DatabaseInjector {
    private DataInjector dataInjector;

    public DatabaseInjector() throws NoSuchAlgorithmException {
        AccountDAOImpl accountDAO = new AccountDAOImpl();
        ReviewDAOImpl reviewDAO = new ReviewDAOImpl();

        this.dataInjector = new DataInjector(accountDAO, reviewDAO);
    }

    public DataInjector getDataInjector() {
        return dataInjector;
    }
}
