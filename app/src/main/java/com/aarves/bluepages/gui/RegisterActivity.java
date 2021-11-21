package com.aarves.bluepages.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.aarves.bluepages.R;
import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity {
    // private static final AccountManager am = new AccountManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    /**
     * Return the user back to the main access menu.
     * @param view View object containing context on what's currently being shown.
     */
    public void returnToAccessMenu(View view) {
        finish();
    }

    /**
     * Register the user for Bluenotes, given a combination of username and password.
     * @param view View object containing context on what's currently being shown.
     */
    public void registerUser(View view) {
        // Get EditText objects for the username/password inputs
        EditText usernameInput = findViewById(R.id.registerUsername);
        EditText passwordInput = findViewById(R.id.registerPassword);
        EditText confPassInput = findViewById(R.id.registerConfirm);

        // Get inputted text
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();
        String confPass = confPassInput.getText().toString();

        // Confirm both passwords are the same
        if (!password.equals(confPass)) {
            CharSequence result = "Passwords do not match!";
            Toast passwordMismatch = Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT);
            passwordMismatch.show();
        } else {
            // am.addUser(username, password);
            Handler handler = new Handler();
            Snackbar.make(view, "Account created successfully. Returning to the login menu in 5 seconds.", 5000).show();
            handler.postDelayed(() -> finish(), 5000);
        }
    }
}
