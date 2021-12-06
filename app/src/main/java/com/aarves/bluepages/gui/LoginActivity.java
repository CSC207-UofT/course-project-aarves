package com.aarves.bluepages.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.aarves.bluepages.R;

public class LoginActivity extends AccountViewImpl {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_login);
    }

    /**
     * Login the user into Bluenotes, should the username and password combination match.
     * @param view View object containing context on what's currently being shown.
     */
    public void loginUser(View view) {
        // Get EditText objects for the username and password inputs
        EditText usernameInput = this.findViewById(R.id.loginUsername);
        EditText passwordInput = this.findViewById(R.id.loginPassword);

        // Get inputted text
        String username = usernameInput.getText().toString().toLowerCase();
        String password = passwordInput.getText().toString();

        // Check if correct login
        this.accountController.login(username, password);

        // Pass data to AccountMenuActivity to allow sign-out functionality
        Intent i = new Intent(LoginActivity.this, AccountMenuActivity.class);
        i.putExtra("password", password);
        i.putExtra("username", username);

    }

    /**
     * Return the user back to the main access menu.
     * @param view View object containing context on what's currently being shown.
     */
    public void returnToAccessMenu(View view) {
        this.finishActivity();
    }
}
