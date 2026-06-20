package com.finance;

public class Main {
    public static void main(String[] args) {

        double presentValue = 1000.0;   // starting amount
        double growthRate   = 0.05;     // 5% annual growth
        int    years        = 10;       // forecast period

        System.out.println("=== Financial Forecasting Tool ===");
        System.out.println("Present Value : Rs." + presentValue);
        System.out.println("Growth Rate   : " + (growthRate * 100) + "%");
        System.out.println("Years         : " + years);

        // Simple recursion
        double result1 = ForecastUtil.calculateFutureValue(presentValue, growthRate, years);
        System.out.printf("%nRecursive Result     : Rs.%.2f%n", result1);

        // Memoized recursion
        double[] memo = new double[years + 1];
        double result2 = ForecastUtil.calculateFutureValueMemo(presentValue, growthRate, years, memo);
        System.out.printf("Memoized Result      : Rs.%.2f%n", result2);

        // Show year by year breakdown
        System.out.println("\n=== Year-by-Year Forecast ===");
        for (int i = 1; i <= years; i++) {
            double value = ForecastUtil.calculateFutureValue(presentValue, growthRate, i);
            System.out.printf("Year %2d : Rs.%.2f%n", i, value);
        }

        // Analysis
        System.out.println("\n=== Algorithm Analysis ===");
        System.out.println("Simple Recursion : O(n) time, O(n) space (call stack)");
        System.out.println("Memoization      : O(n) time, avoids redundant calculations");
        System.out.println("Both give same result — memoization is better for large year ranges");
    }
}