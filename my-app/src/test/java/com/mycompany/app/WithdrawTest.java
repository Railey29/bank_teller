package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.mycompany.app.logic.CheckBalance;
import com.mycompany.app.logic.WithdrawBalance;

public class WithdrawTest {

    @Test
    void testWithdraw() {
        double initialBalance = CheckBalance.getBalance();
        boolean result = WithdrawBalance.withdrawBalance(50);
        double finalBalance = CheckBalance.getBalance();

        assertTrue(result, "The Withdraw Balance is Success!");
        assertEquals(initialBalance - 50, finalBalance, 0.001, "Balance should decrease by 50");

    }
}
