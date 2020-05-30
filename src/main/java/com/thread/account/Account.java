package com.thread.account;

public class Account {
    private double balance;

    public void deposit(double money) {
        double newBalance = balance + money;
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        balance = newBalance;
    }

    public double getBalance() {
        return balance;
    }

}
