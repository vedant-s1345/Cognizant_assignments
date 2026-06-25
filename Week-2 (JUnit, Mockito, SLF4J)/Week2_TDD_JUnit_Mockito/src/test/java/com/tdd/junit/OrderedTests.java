package com.tdd.junit;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    private static int counter = 0;

    @Test
    @Order(1)
    public void testFirst() {
        counter++;
        assertEquals(1, counter);
        System.out.println("Test 1 executed — counter: " + counter);
    }

    @Test
    @Order(2)
    public void testSecond() {
        counter++;
        assertEquals(2, counter);
        System.out.println("Test 2 executed — counter: " + counter);
    }

    @Test
    @Order(3)
    public void testThird() {
        counter++;
        assertEquals(3, counter);
        System.out.println("Test 3 executed — counter: " + counter);
    }

    @Test
    @Order(4)
    public void testFourth() {
        counter++;
        assertEquals(4, counter);
        System.out.println("Test 4 executed — counter: " + counter);
    }
}