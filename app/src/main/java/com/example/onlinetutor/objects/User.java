package com.example.onlinetutor.objects;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String fullname;
    private String email;
    private String password;

    public User(String u, String fn, String email, String password) {
        this.username = u;
        this.fullname = fn;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
