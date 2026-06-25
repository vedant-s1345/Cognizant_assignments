package com.tdd.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    public void testAssertEquals() {
        assertEquals(5, 2 + 3);
        System.out.println("assertEquals passed: 2 + 3 = 5");
    }

    @Test
    public void testAssertTrue() {
        assertTrue(5 > 3);
        System.out.println("assertTrue passed: 5 > 3 is true");
    }

    @Test
    public void testAssertFalse() {
        assertFalse(5 < 3);
        System.out.println("assertFalse passed: 5 < 3 is false");
    }

    @Test
    public void testAssertNull() {
        assertNull(null);
        System.out.println("assertNull passed: value is null");
    }

    @Test
    public void testAssertNotNull() {
        assertNotNull(new Object());
        System.out.println("assertNotNull passed: value is not null");
    }

    @Test
    public void testAssertArrayEquals() {
        int[] expected = {1, 2, 3};
        int[] actual   = {1, 2, 3};
        assertArrayEquals(expected, actual);
        System.out.println("assertArrayEquals passed: arrays are equal");
    }

    @Test
    public void testAssertThrows() {
        Calculator calculator = new Calculator();
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
        System.out.println("assertThrows passed: divide by zero throws ArithmeticException");
    }
}