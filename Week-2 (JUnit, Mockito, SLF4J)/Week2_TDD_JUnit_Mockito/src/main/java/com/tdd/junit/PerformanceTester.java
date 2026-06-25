package com.tdd.junit;

public class PerformanceTester {

    // Fast task — completes in ~100ms
    public void performFastTask() {
        try {
            Thread.sleep(100);
            System.out.println("Fast task completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Slow task — completes in ~3000ms
    public void performSlowTask() {
        try {
            Thread.sleep(3000);
            System.out.println("Slow task completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Heavy computation task
    public long computeSum(int limit) {
        long sum = 0;
        for (int i = 0; i <= limit; i++) {
            sum += i;
        }
        return sum;
    }
}