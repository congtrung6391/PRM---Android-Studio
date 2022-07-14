package com.example.onlinetutor;

import android.content.Intent;
import android.content.SharedPreferences;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlinetutor.dao.UserDao;

public class LoginActivity extends AppCompatActivity {
    private static final String LOG_TAG = "LoginActivity";
    Button loginButton;
    Button registerLinkButton;
    EditText usernameTextView;
    EditText passwordTextView;
    CheckBox checkBox;
    Intent homeIntent;
    Intent registerIntent;
    UserDao userDao;

    void onSetupController() {
        loginButton = findViewById(R.id.login_button);
        registerLinkButton = findViewById(R.id.button2);
        usernameTextView = findViewById(R.id.editTextTextUsername);
        passwordTextView = findViewById(R.id.editTextTextPassword);
        checkBox = findViewById(R.id.rememberMe);
        userDao = new UserDao(LoginActivity.this);
    }

    void onSetupIntent() {
        homeIntent = new Intent(LoginActivity.this, HomeActivity.class);
        registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
    }
    
    boolean verifyUser(String username, String password) {
        return userDao.isExist(username, password);
    }

    void login() {
        String username = usernameTextView.getText().toString();
        String password = passwordTextView.getText().toString();
        boolean check = checkBox.isChecked();
        if (verifyUser(username, password)) {
            homeIntent.putExtra("username", username);
            saveInfo(username, password, check);
            Toast.makeText(LoginActivity.this, "Successful login", Toast.LENGTH_LONG).show();
            startActivity(homeIntent);
        } else {
            Toast.makeText(LoginActivity.this, "Unsuccessful login", Toast.LENGTH_LONG).show();
        }
    }

    void onSetupListener() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
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
        loadData();
    }

    private void saveInfo(String un, String pw, boolean check){
        SharedPreferences pref = getSharedPreferences("info.save",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        if(check){
            editor.putString("username", un);
            editor.putString("password", pw);
            editor.putBoolean("check",check);
        }
        else {
            editor.clear();
        }
        editor.commit();
    }

    private  void loadData(){
        SharedPreferences pref = getSharedPreferences("info.save",MODE_PRIVATE);
        boolean check = pref.getBoolean("check",false);
        if(check){
            usernameTextView.setText(pref.getString("username",""));
            passwordTextView.setText(pref.getString("password",""));
            checkBox.setChecked(true);
        }
        login();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            String lgMessage = data.getStringExtra("logout");
            Toast.makeText(LoginActivity.this, lgMessage, Toast.LENGTH_LONG).show();
        }
    }
}