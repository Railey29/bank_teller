package com.mycompany.app.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.app.connection.DBconnection;
import com.mycompany.app.implementInterface.ViewTransactionImplement;
import com.mycompany.app.interfaceTransaction.InterfaceTransaction;

public class TransactionViewBalance {

    public static List<InterfaceTransaction> getAllTransaction() {
        String getAllDataQuery = "SELECT time, type, money FROM bank_teller ORDER BY time DESC";
        List<InterfaceTransaction> transactions = new ArrayList<>();

        Connection conn = null;
        PreparedStatement prepStatement = null;
        ResultSet rs = null;

        try {
            conn = DBconnection.getConnection();
            prepStatement = conn.prepareStatement(getAllDataQuery);
            rs = prepStatement.executeQuery();

            while (rs.next()) {
                String time = rs.getString("time");
                String type = rs.getString("type");
                double money = rs.getDouble("money");

                // Create object that implements InterfaceTransaction
                InterfaceTransaction transaction = new ViewTransactionImplement(time, type, money);
                transactions.add(transaction);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException ignored) {
            }
            try {
                if (prepStatement != null)
                    prepStatement.close();
            } catch (SQLException ignored) {
            }
        }

        return transactions;
    }

    // Optional: helper method to print all transactions
    public static void printAllTransactions() {
        List<InterfaceTransaction> transactions = getAllTransaction();

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("Time | Type | Money");
            System.out.println("---------------------");
            for (InterfaceTransaction t : transactions) {
                System.out.println(t.getTime() + " | " + t.getType() + " | " + t.getMoney());
            }
        }
    }
}
