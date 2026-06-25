package com.tdd.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AAAPatternTest {

    private Calculator calculator;

    // Runs BEFORE every test — setup
    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        System.out.println("setUp: Calculator instance created");
    }

    // Runs AFTER every test — teardown
    @AfterEach
    public void tearDown() {
        calculator = null;
        System.out.println("tearDown: Calculator instance destroyed");
        System.out.println("---");
    }

    @Test
    public void testAdd() {
        // Arrange
        int a = 5, b = 3;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(8, result);
        System.out.println("testAdd passed: " + a + " + " + b + " = " + result);
    }

    @Test
    public void testSubtract() {
        // Arrange
        int a = 10, b = 4;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(6, result);
        System.out.println("testSubtract passed: " + a + " - " + b + " = " + result);
    }

    @Test
    public void testMultiply() {
        // Arrange
        int a = 3, b = 7;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(21, result);
        System.out.println("testMultiply passed: " + a + " * " + b + " = " + result);
    }

    @Test
    public void testDivide() {
        // Arrange
        int a = 20, b = 4;

        // Act
        double result = calculator.divide(a, b);

        // Assert
        assertEquals(5.0, result);
        System.out.println("testDivide passed: " + a + " / " + b + " = " + result);
    }
}