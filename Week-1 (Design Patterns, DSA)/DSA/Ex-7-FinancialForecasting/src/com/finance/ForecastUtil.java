package com.finance;

public class ForecastUtil {

    // Simple recursive approach
    // Each call multiplies value by (1 + growthRate) and reduces years by 1
    // Base case: when years hits 0, return the current value
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    // Optimized with memoization — stores already computed results
    // Avoids recalculating the same year multiple times
    public static double calculateFutureValueMemo(double presentValue, double growthRate, int years, double[] memo) {
        if (years == 0) {
            return presentValue;
        }
        if (memo[years] != 0) {
            return memo[years];
        }
        memo[years] = calculateFutureValueMemo(presentValue * (1 + growthRate), growthRate, years - 1, memo);
        return memo[years];
    }
}