package com.mycompany.app.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mycompany.app.connection.DBconnection;

public class WithdrawBalance {

    public static boolean withdrawBalance(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw amount must be greater than 0");
            return false;
        }

        double currentBalance = CheckBalance.getBalance();

        if (amount > currentBalance) {
            System.out.println("Insufficient balance!");
            return false;
        }

        double newBalance = currentBalance - amount;

        String withdrawQuery = "INSERT INTO bank_teller (type, money) VALUES (?, ?)";

        Connection conn = DBconnection.getConnection();
        PreparedStatement prepStatement = null;

        try {
            prepStatement = conn.prepareStatement(withdrawQuery);
            prepStatement.setString(1, "withdraw");
            prepStatement.setDouble(2, amount);

            int rowsInsert = prepStatement.executeUpdate();
            if (rowsInsert > 0) {
                System.out.println("Withdraw Success! Amount: " + amount);
                return true;
            } else {
                System.out.println("No Record Found to Update. Deposit Failed");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (prepStatement != null) {
                try {
                    prepStatement.close();
                } catch (SQLException ignored) {
                }
            }
        }
    }
}
