package com.tdd.junit;

public class ExceptionThrower {

    public void throwException(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number cannot be negative: " + number);
        }
        if (number == 0) {
            throw new ArithmeticException("Number cannot be zero");
        }
        System.out.println("Valid number: " + number);
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}