package com.mycompany.app.userManagment;

import java.util.Scanner;

import com.mycompany.app.interfaceTransaction.InterfaceTransaction;
import com.mycompany.app.logic.CheckBalance;
import com.mycompany.app.logic.DepositBalance;
import com.mycompany.app.logic.TransactionViewBalance;
import com.mycompany.app.logic.WithdrawBalance;
import com.mycompany.app.util.PinUtils;

public class Dashboard {
    Scanner scanner = new Scanner(System.in);
    PinUtils pinUtils = new PinUtils();
    CheckBalance checkBalance = new CheckBalance();
    DepositBalance depositBalance = new DepositBalance();
    WithdrawBalance withdrawBalance = new WithdrawBalance();
    TransactionViewBalance transactionBalance = new TransactionViewBalance();

    public void start() {
        // start the logic
        if (pinUtils.verifyPin()) {
            clearConsole();
            DisplayChoice();
        }
    }

    public void DisplayChoice() {
        boolean continueLoop = true;

        do {
            clearConsole();
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Transaction");
            System.out.println("5. Exit");
            System.out.print("Please Select Your Transaction: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // logic for Check Balance
                    System.out.println("========== WELCOME TO CURRENT BALANCE =============");
                    double balance = checkBalance.getBalance();
                    System.out.println("Your current Balance: " + balance);
                    break;
                case 2:
                    // logic for Deposit
                    System.out.println("========== WELCOME TO DEPOSIT BALANCE =============");
                    System.out.print("Enter Amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    depositBalance.depositBalance(depositAmount);
                    break;
                case 3:
                    // logic for Withdraw
                    System.out.println("========== WELCOME TO WITHDRAW BALANCE =============");
                    System.out.print("Enter Amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();
                    withdrawBalance.withdrawBalance(withdrawAmount);
                    break;
                case 4:
                    // logic for View Transaction
                    System.out.println("==========VIEW YOUR RECENT TRANSACTION ==========");
                    for (InterfaceTransaction t : transactionBalance.getAllTransaction()) {
                        System.out.println(t.getTime() + " | " + t.getType() + " | " + t.getMoney());
                    }
                    break;
                case 5:
                    // logic for Exit
                    System.out.println("Thank you for using our system. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    // Logic for Default
                    System.out.println("Out of The choices . Goodbye!");
                    System.exit(0);
                    break;
            }
            if (choice != 5) {
                System.out.print("Do you want to Continue(Y/N): ");
                String answer = scanner.nextLine();
                if (!answer.equalsIgnoreCase("Y")) {
                    continueLoop = false;
                }
                clearConsole();
            }
        } while (continueLoop);

    }

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                // Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Linux, macOS, etc.
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error clearing console: " + e.getMessage());
        }
    }

}
