package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.mycompany.app.logic.CheckBalance;

public class CheckBalanceTest {

    @Test
    void testGetBalance() {
        double balance = CheckBalance.getBalance();

        assertTrue(balance >= 0.0, "Balance should be non-negative");
    }
}
