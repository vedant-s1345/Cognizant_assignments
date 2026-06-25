package com.tdd.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTesterTest {

    PerformanceTester tester = new PerformanceTester();

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    public void testFastTaskCompletesWithinTimeout() {
        // Fast task takes ~100ms, limit is 1 second — should PASS
        tester.performFastTask();
        System.out.println("testFastTaskCompletesWithinTimeout passed");
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    public void testSlowTaskCompletesWithinTimeout() {
        // Slow task takes ~3000ms, limit is 5 seconds — should PASS
        tester.performSlowTask();
        System.out.println("testSlowTaskCompletesWithinTimeout passed");
    }

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    public void testComputeSumWithinTimeout() {
        // Sum computation should finish well within 2 seconds
        long result = tester.computeSum(1000000);
        assertEquals(500000500000L, result);
        System.out.println("testComputeSumWithinTimeout passed: sum = " + result);
    }

    @Test
    public void testSlowTaskExceedsTimeout() {
        // Verify that slow task actually takes more than 1 second
        long start = System.currentTimeMillis();
        tester.performSlowTask();
        long duration = System.currentTimeMillis() - start;
        assertTrue(duration >= 3000);
        System.out.println("testSlowTaskExceedsTimeout passed: duration = " + duration + "ms");
    }
}