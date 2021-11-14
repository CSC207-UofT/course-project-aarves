import android.app.Application;
import database.DatabaseInjector;

import java.security.NoSuchAlgorithmException;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        try {
            DatabaseInjector databaseInjector = new DatabaseInjector();
        } catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        }
    }
}
