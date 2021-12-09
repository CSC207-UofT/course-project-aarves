package com.aarves.bluepages.gui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.aarves.bluepages.R;

public class RegisterActivity extends AccountViewImpl {

    /**
     * Register the user for Bluenotes, given a combination of username and password.
     * @param view View object containing context on what's currently being shown.
     */
    public void registerUser(View view) {
        // Get EditText objects for the username/password inputs
        EditText usernameInput = this.findViewById(R.id.registerUsername);
        EditText passwordInput = this.findViewById(R.id.registerPassword);
        EditText confirmPasswordInput = this.findViewById(R.id.registerConfirm);

        // Get inputted text
        String username = usernameInput.getText().toString().toLowerCase();
        String password = passwordInput.getText().toString();
        String confirmPassword = confirmPasswordInput.getText().toString();

        // Confirm both passwords are the same
        this.accountController.register(username, password, confirmPassword);
    }

    /**
     * Return the user back to the main access menu.
     * @param view View object containing context on what's currently being shown.
     */
    public void returnToAccessMenu(View view) {
        this.finishActivity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_register);
    }
}
