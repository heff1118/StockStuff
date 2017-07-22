package com.aheffernan.stockstuff.model;

/**
 * A user for the stock ticker system.
 */
public class User {

    private String userName;

    /**
     * @param userName set username
     */
    public User(String userName) {
        this.userName = userName;
    }

    /**
     * @return username
     */
    public String getUserName() {
        return userName;
    }
}
