package com.hupeng.lab2;

public class Login {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Login() {
    }
}
