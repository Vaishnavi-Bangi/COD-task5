package com.codtech;

import java.util.ArrayList;
import java.util.List;

class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private List<String> transactionHistory;

    public Account(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: $" + amount);
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + amount);
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Invalid or insufficient amount for withdrawal.");
        }
    }

    public void transfer(Account toAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            toAccount.deposit(amount);
            transactionHistory.add("Transferred: $" + amount + " to " + toAccount.getAccountNumber());
            toAccount.transactionHistory.add("Received: $" + amount + " from " + this.accountNumber);
            System.out.println("Transferred: $" + amount + " to " + toAccount.getAccountNumber());
        } else {
            System.out.println("Invalid or insufficient amount for transfer.");
        }
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void updateAccountHolderName(String newName) {
        this.accountHolderName = newName;
        System.out.println("Account holder name updated to: " + newName);
    }
}
