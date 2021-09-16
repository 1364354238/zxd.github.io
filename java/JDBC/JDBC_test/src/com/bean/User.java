package com.bean;

/**
 * @author dzx
 * @date 2021/9/15 -15:07
 */
public class User {
    private String user;
    private String password;
    private int balance;

    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public int getBalance() {
        return balance;
    }

    public User() {
    }

    public User(String user, String password, int balance) {
        this.user = user;
        this.password = password;
        this.balance = balance;
    }
}
