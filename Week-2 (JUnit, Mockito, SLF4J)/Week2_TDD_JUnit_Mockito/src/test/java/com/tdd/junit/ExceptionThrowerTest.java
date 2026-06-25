package com.tdd.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    ExceptionThrower thrower = new ExceptionThrower();

    @Test
    public void testThrowsIllegalArgumentException() {
        // Assert that negative number throws IllegalArgumentException
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> thrower.throwException(-1)
        );
        assertEquals("Number cannot be negative: -1", ex.getMessage());
        System.out.println("testThrowsIllegalArgumentException passed: " + ex.getMessage());
    }

    @Test
    public void testThrowsArithmeticException() {
        // Assert that zero throws ArithmeticException
        ArithmeticException ex = assertThrows(
            ArithmeticException.class,
            () -> thrower.throwException(0)
        );
        assertEquals("Number cannot be zero", ex.getMessage());
        System.out.println("testThrowsArithmeticException passed: " + ex.getMessage());
    }

    @Test
    public void testDivideByZeroThrowsException() {
        // Assert that divide by zero throws ArithmeticException
        ArithmeticException ex = assertThrows(
            ArithmeticException.class,
            () -> thrower.divide(10, 0)
        );
        assertEquals("Cannot divide by zero", ex.getMessage());
        System.out.println("testDivideByZeroThrowsException passed: " + ex.getMessage());
    }

    @Test
    public void testValidNumberDoesNotThrow() {
        // Assert that valid number does NOT throw any exception
        assertDoesNotThrow(() -> thrower.throwException(5));
        System.out.println("testValidNumberDoesNotThrow passed: no exception thrown");
    }
}