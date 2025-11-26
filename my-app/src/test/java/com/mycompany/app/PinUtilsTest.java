package com.mycompany.app;

import com.mycompany.app.util.PinUtils;
import org.junit.jupiter.api.Test; // JUnit 5 import
import static org.junit.jupiter.api.Assertions.*; // assertions

public class PinUtilsTest {

    @Test
    public void testIsCorrectPin_valid() {
        assertTrue(PinUtils.isCorrectPin("123456"));
    }

    @Test
    public void testIsCorrectPin_wrongPin() {
        assertFalse(PinUtils.isCorrectPin("0000"));
        assertFalse(PinUtils.isCorrectPin("abcd"));
        assertFalse(PinUtils.isCorrectPin("12"));
    }
}
