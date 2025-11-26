package com.mycompany.app.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mycompany.app.connection.DBconnection;

public class CheckBalance {

    public static double getBalance() {
        double balance = 0.0;
        String getMoneyQuery = "SELECT type , money FROM bank_teller   ";

        Connection conn = DBconnection.getConnection();
        PreparedStatement prepStatement = null;
        ResultSet resultSet = null;

        try {
            prepStatement = conn.prepareStatement(getMoneyQuery);
            resultSet = prepStatement.executeQuery();

            while (resultSet.next()) {
                String type = resultSet.getString("type");
                double amount = resultSet.getDouble("money");

                if (type.equalsIgnoreCase("deposit")) {
                    balance += resultSet.getDouble("money");
                } else if (type.equalsIgnoreCase("withdraw")) {
                    balance -= amount;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ignored) {
                }
            }
            if (prepStatement != null) {
                try {
                    prepStatement.close();
                } catch (SQLException ignored) {
                }
            }
        }

        return balance;
    }

}
