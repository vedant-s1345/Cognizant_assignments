package com.tdd.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {

        System.out.println("=== SLF4J Logging Demo ===\n");

        // Different log levels
        logger.trace("This is a TRACE message — finest level");
        logger.debug("This is a DEBUG message — debugging info");
        logger.info("This is an INFO message — general info");
        logger.warn("This is a WARN message — potential issue");
        logger.error("This is an ERROR message — something went wrong");

        System.out.println("\n=== Parameterized Logging ===\n");

        // Parameterized logging — more efficient than string concatenation
        String username = "VedantSarode";
        int userId = 42;
        logger.info("User logged in: {} with ID: {}", username, userId);
        logger.warn("User {} has exceeded login attempts", username);
        logger.error("Failed to load user with ID: {}", userId);

        System.out.println("\n=== Exception Logging ===\n");

        // Logging exceptions
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("Arithmetic error occurred: {}", e.getMessage(), e);
        }

        try {
            String str = null;
            str.length();
        } catch (NullPointerException e) {
            logger.error("Null pointer error: {}", e.getMessage(), e);
        }

        System.out.println("\n=== Conditional Logging ===\n");

        // Check log level before logging — good practice for performance
        if (logger.isDebugEnabled()) {
            logger.debug("Debug is enabled — logging detailed info");
        }

        if (logger.isInfoEnabled()) {
            logger.info("Application running successfully");
        }
    }
}