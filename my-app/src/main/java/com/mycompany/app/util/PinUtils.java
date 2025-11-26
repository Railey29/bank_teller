package com.mycompany.app.util;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class PinUtils {

    private static final String CORRECT_PIN = "123456";

    public static boolean verifyPin() {
        try {
            Terminal terminal = TerminalBuilder.builder().system(true).build();
            LineReader reader = LineReaderBuilder.builder().terminal(terminal).build();

            int attempts = 0;
            final int MAX = 3;

            while (attempts < MAX) {
                String pin = reader.readLine("Enter 6-digit PIN: ", '*');
                if (isCorrectPin(pin)) {
                    System.out.println("PIN accepted.");
                    return true;
                } else {
                    System.out.println("Incorrect PIN. Try again.");
                }
                attempts++;
            }

            System.out.println("Maximum attempts reached. Access denied.");
            return false;

        } catch (Exception e) {
            throw new RuntimeException("Cannot read PIN", e);
        }
    }

    public static boolean isCorrectPin(String pin) {
        return pin.matches("\\d{6}") && pin.equals(CORRECT_PIN);
    }
}
