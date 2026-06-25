package com.tdd.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        int result = calculator.add(3, 2);
        assertEquals(5, result);
        System.out.println("testAdd passed: 3 + 2 = " + result);
    }

    @Test
    public void testSubtract() {
        int result = calculator.subtract(10, 4);
        assertEquals(6, result);
        System.out.println("testSubtract passed: 10 - 4 = " + result);
    }

    @Test
    public void testMultiply() {
        int result = calculator.multiply(3, 4);
        assertEquals(12, result);
        System.out.println("testMultiply passed: 3 * 4 = " + result);
    }

    @Test
    public void testDivide() {
        double result = calculator.divide(10, 2);
        assertEquals(5.0, result);
        System.out.println("testDivide passed: 10 / 2 = " + result);
    }
}