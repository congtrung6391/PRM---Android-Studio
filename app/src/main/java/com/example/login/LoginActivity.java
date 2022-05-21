package com.example.login;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private static final String LOG_TAG = "LoginActivity";
    Button loginButton;
    Button registerLinkButton;
    TextView usernameTextView;
    TextView passwordTextView;
    Intent homeIntent;
    Intent registerIntent;

    void onSetupController() {
        loginButton = findViewById(R.id.login_button);
        registerLinkButton = findViewById(R.id.button2);
        usernameTextView = findViewById(R.id.editTextTextUsername);
        passwordTextView = findViewById(R.id.editTextTextPassword);
    }

    void onSetupIntent() {
        homeIntent = new Intent(LoginActivity.this, HomeActivity.class);
        registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
    }
    
    boolean verifyUser(String username, String password) {
        return username.equals("admin") && password.equals("123456");
    }

    void onSetupListener() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameTextView.getText().toString();
                String password = passwordTextView.getText().toString();
                if (verifyUser(username, password)) {
                    homeIntent.putExtra("username", username);
                    startActivity(homeIntent);
                } else {
                    Toast.makeText(LoginActivity.this, "Unsuccessful login", Toast.LENGTH_LONG).show();
                }
            }
        });
        registerLinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(registerIntent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_login);
        onSetupController();
        onSetupIntent();
        onSetupListener();
    }
}