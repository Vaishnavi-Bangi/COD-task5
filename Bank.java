package com.codtech;

import java.util.HashMap;
import java.util.Map;

class Bank {
    private Map<String, Account> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public Account createAccount(String accountNumber, String accountHolderName) {
        if (!accounts.containsKey(accountNumber)) {
            Account newAccount = new Account(accountNumber, accountHolderName);
            accounts.put(accountNumber, newAccount);
            System.out.println("Account created: " + accountNumber);
            return newAccount;
        } else {
            System.out.println("Account number already exists.");
            return null;
        }
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}
