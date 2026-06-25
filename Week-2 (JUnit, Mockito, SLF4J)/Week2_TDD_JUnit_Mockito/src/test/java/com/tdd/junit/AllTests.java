package com.tdd.junit;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    CalculatorTest.class,
    AssertionsTest.class,
    AAAPatternTest.class,
    EvenCheckerTest.class
})
public class AllTests {
    // This class groups all test classes together
    // Running this runs ALL tests from all selected classes
}