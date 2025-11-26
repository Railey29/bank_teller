package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.mycompany.app.logic.CheckBalance;
import com.mycompany.app.logic.DepositBalance;

public class DepositBalanceTest {

    @Test
    void testDepositBalance() {
        double depositAmount = 50.0;
        double oldBalance = CheckBalance.getBalance();

        boolean result = DepositBalance.depositBalance(depositAmount);
        assertTrue(result, "Deposit Should succeed");

        double newBalance = CheckBalance.getBalance();
        assertEquals(oldBalance + depositAmount, newBalance, 0.001);
    }
}
