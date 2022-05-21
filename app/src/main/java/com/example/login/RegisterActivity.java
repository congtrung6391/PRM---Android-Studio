package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private static final String LOG_TAG = "RegisterActivity";
    Button registerButton;
    Button loginLinkButton;
    TextView usernameTextView;
    TextView passwordTextView;
    TextView confirmPasswordTextView;
    TextView emailTextView;
    TextView fullnameTextView;
    Intent loginIntent;

    void onSetupController() {
        registerButton = findViewById(R.id.register_button);
        loginLinkButton = findViewById(R.id.login_link_button);
        usernameTextView = findViewById(R.id.editTextTextUsername);
        passwordTextView = findViewById(R.id.editTextTextPassword);
        confirmPasswordTextView = findViewById(R.id.confirm_password_textview);
        emailTextView = findViewById(R.id.email_textview);
        fullnameTextView = findViewById(R.id.fullname_textview);
    }

    void onSetupIntent() {
        loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
    }

    boolean verifyData(String username, String email, String fullname, String password, String confirmPassword) {
        return true;
    }

    void onSetupListener() {
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameTextView.getText().toString();
                String password = passwordTextView.getText().toString();
                String confirmPassword = confirmPasswordTextView.getText().toString();
                String fullname = fullnameTextView.getText().toString();
                String email = emailTextView.getText().toString();
                if (verifyData(
                        username,
                        email,
                        fullname,
                        password,
                        confirmPassword
                )) {
                    startActivity(loginIntent);
                } else {
                    Toast.makeText(RegisterActivity.this, "Unvalid form", Toast.LENGTH_LONG).show();
                }
            }
        });
        loginLinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(loginIntent);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_register);
        onSetupController();
        onSetupIntent();
        onSetupListener();
    }
}