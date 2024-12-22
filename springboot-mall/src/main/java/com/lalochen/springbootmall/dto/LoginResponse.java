package com.lalochen.springbootmall.dto;

import com.lalochen.springbootmall.model.User;

public class LoginResponse {
    private boolean loggedIn;
    private User user;

    public LoginResponse(boolean loggedIn, User user) {
        this.loggedIn = loggedIn;
        this.user = user;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
