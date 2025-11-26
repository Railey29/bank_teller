package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.mycompany.app.interfaceTransaction.InterfaceTransaction;
import com.mycompany.app.logic.TransactionViewBalance;

public class TransactionViewBalanceTest {

    @Test
    void testGetAllTransaction() {
        List<InterfaceTransaction> transactions = TransactionViewBalance.getAllTransaction();

        // Check that the list is not empty
        assertFalse(transactions.isEmpty(), "Transaction list should not be empty");

        // Check the first transaction's properties
        InterfaceTransaction firstTransaction = transactions.get(0);
        System.out.println("Type: " + firstTransaction.getType());
        System.out.println("Money: " + firstTransaction.getMoney());
        System.out.println("Time: " + firstTransaction.getTime());

    }

}
