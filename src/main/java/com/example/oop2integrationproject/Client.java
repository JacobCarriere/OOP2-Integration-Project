package com.example.oop2integrationproject;

import java.util.Objects;

public class Client {
    private final String userID;
    private final String name;
    private final String email;
    private final String password;

    public Client(String userID, String name, String email, String password) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getClientID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}
