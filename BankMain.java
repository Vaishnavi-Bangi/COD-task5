package com.codtech;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        String accountNumber, accountHolderName;
        double amount;

        while (true) {
            System.out.println("\nOnline Banking System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Transfer Funds");
            System.out.println("5. View Transaction History");
            System.out.println("6. Update Personal Information");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter account holder name: ");
                    accountHolderName = scanner.nextLine();
                    bank.createAccount(accountNumber, accountHolderName);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    Account account = bank.getAccount(accountNumber);
                    if (account != null) {
                        System.out.print("Enter deposit amount: ");
                        amount = scanner.nextDouble();
                        account.deposit(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    account = bank.getAccount(accountNumber);
                    if (account != null) {
                        System.out.print("Enter withdrawal amount: ");
                        amount = scanner.nextDouble();
                        account.withdraw(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter your account number: ");
                    accountNumber = scanner.nextLine();
                    account = bank.getAccount(accountNumber);
                    if (account != null) {
                        System.out.print("Enter recipient's account number: ");
                        String recipientAccountNumber = scanner.nextLine();
                        Account recipientAccount = bank.getAccount(recipientAccountNumber);
                        if (recipientAccount != null) {
                            System.out.print("Enter transfer amount: ");
                            amount = scanner.nextDouble();
                            account.transfer(recipientAccount, amount);
                        } else {
                            System.out.println("Recipient account not found.");
                        }
                    } else {
                        System.out.println("Your account not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    account = bank.getAccount(accountNumber);
                    if (account != null) {
                        System.out.println("Transaction History:");
                        for (String transaction : account.getTransactionHistory()) {
                            System.out.println(transaction);
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    account = bank.getAccount(accountNumber);
                    if (account != null) {
                        System.out.print("Enter new account holder name: ");
                        accountHolderName = scanner.nextLine();
                        account.updateAccountHolderName(accountHolderName);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
