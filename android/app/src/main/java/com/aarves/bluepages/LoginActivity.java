package com.aarves.bluepages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.aarves.core.usecases.AccountManager;

public class LoginActivity extends AppCompatActivity {
    private static final AccountManager am = new AccountManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        am.addUser("rickastley", "getrolled");
        am.addUser("billy123", "iambilly");
        am.addUser("javalover", "neverevercpp");
        am.addUser("billiam", "gates123");
    }

    /**
     * Return the user back to the main access menu.
     * @param view View object containing context on what's currently being shown.
     */
    public void returnToAccessMenu(View view) {
        finish();
    }

    /**
     * Login the user into Bluenotes, should the username and password combination match.
     * @param view View object containing context on what's currently being shown.
     */
    public void loginUser(View view) {
        // Get EditText objects for the username/password inputs
        EditText usernameInput = findViewById(R.id.loginUsername);
        EditText passwordInput = findViewById(R.id.loginPassword);

        // Get inputted text
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        // Check if correct login
        boolean loginResult = am.correctLogin(username, password);

        if (loginResult) {
            CharSequence result = "Welcome back " + username + "!";
            Toast loginSuccess = Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT);
            loginSuccess.show();
            Intent intent = new Intent(this, MainMenuActivity.class);
            startActivity(intent);
        } else {
            CharSequence result = "Incorrect username/password!";
            Toast loginFailure = Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT);
            loginFailure.show();
        }
    }
}
