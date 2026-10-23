/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.week1_data_types_and_variables;

import java.util.Scanner;

/**
 *
 * @author kathe
 */
public class Week3_Control_Flow_Part1 {

        public static void main(String[] args) {
        simpleGradeClassifier();
        System.out.println();
        multiTierDiscountSystem();
        System.out.println();
        
    }

    public static void simpleGradeClassifier() {
        System.out.println("==========Simple_Grade_Classifier==========");
        
        int score = 75;
        
        System.out.println("Score: " + score);
        if (score >= 60) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        
        System.out.println();

        score = 45;
        
        System.out.println("Score: " + score);
        if (score >= 60) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
    }

    public static void multiTierDiscountSystem() {
        System.out.println("==========MultiTier_Discount_System==========");
        
        double purchaseAmount = 250.00;
        double discountPercentage;
        double finalPrice;

        if (purchaseAmount < 100) {
            discountPercentage = 0;
        } else if (purchaseAmount < 200) {
            discountPercentage = 5;
        } else if (purchaseAmount < 300) {
            discountPercentage = 10;
        } else {
            discountPercentage = 15;
        }

        finalPrice = purchaseAmount - (purchaseAmount * discountPercentage / 100);

        System.out.println("Purchase Amount: " + purchaseAmount);
        System.out.println("Discount Percentage: " + discountPercentage + "%");
        System.out.println("Final Price after Discount: " + finalPrice);
    }

    public static void nestedLoginValidator() {
        System.out.println("==========Nested_Login_Validator==========");
        
        Scanner scanner = new Scanner(System.in);

        String correctUsername = "Kaeley";
        String correctPassword = "K@3l3y";
        boolean isAccountLocked = false;
        
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (username.equals(correctUsername)) {
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (password.equals(correctPassword)) {

                if (!isAccountLocked) {
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Login failed: Your account is locked.");
                }
            } else {
                System.out.println("Login failed: Incorrect password.");
            }
        } else {
            System.out.println("Login failed: Username not found.");
        }

        scanner.close();
    }

    public static void atmTransactionAuthorizer() {
        System.out.println("==========ATM_Transaction_Autjorizer==========");
        
        Scanner scanner = new Scanner(System.in);

        String correctUsername = "Kaeley07";
        String correctPin = "0710";

        double accountBalance = 2000.00;
        String accountTier = "";

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        if (username.equals(correctUsername) && pin.equals(correctPin)) {
        
            if (accountBalance < 2000) {
                accountTier = "Bronze";
            } else if (accountBalance < 5000) {
                accountTier = "Silver";
            } else if (accountBalance < 10000) {
                accountTier = "Gold";
            } else {
                accountTier = "Platinum";
            }

            System.out.print("Enter withdrawal amount: ");
            double withdrawalAmount = scanner.nextDouble();
            double dailyLimit;

            switch (accountTier) {
                case "Bronze" : dailyLimit = 200.00; break;
                case "Silver" : dailyLimit = 300.00; break;
                case "Gold" : dailyLimit = 500.00; break;
                case "Platinum" : dailyLimit = 1000.00; break;
                default : dailyLimit = 0; break;
            }

            if (withdrawalAmount <= accountBalance) {
                if (withdrawalAmount <= dailyLimit) {
                    accountBalance -= withdrawalAmount;
                    System.out.println("Transaction Approved. New balance: " + accountBalance);
                } else {
                    System.out.println("Transaction Denied: Exceeds daily limit for " + accountTier + " tier.");
                }
            } else {
                System.out.println("Transaction Denied: Insufficient balance.");
            }
        } else {
            System.out.println("Transaction Denied: Invalid username or PIN.");
        }

        scanner.close();
    }
}