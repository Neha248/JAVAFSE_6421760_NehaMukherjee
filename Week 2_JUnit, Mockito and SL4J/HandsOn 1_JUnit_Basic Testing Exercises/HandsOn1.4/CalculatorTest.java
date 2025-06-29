package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    // Setup method: runs before each @Test
    @Before
    public void setUp() {
        System.out.println("Setting up...");
        calculator = new Calculator();  // Arrange
    }

    // Teardown method: runs after each @Test
    @After
    public void tearDown() {
        System.out.println("Cleaning up...");
        calculator = null;
    }

    @Test
    public void testAdd() {
        // Arrange: done in setUp
        // Act
        int result = calculator.add(10, 5);
        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testSubtract() {
        // Act
        int result = calculator.subtract(10, 5);
        // Assert
        assertEquals(5, result);
    }
}
