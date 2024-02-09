package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("empty string should return zero")
    public void emptyStringShouldReturnZero() {
        assertEquals(0, Calculator.add(""));
    }

    @Test
    @DisplayName("single number should return same")
    public void singleNumberShouldReturnSame() {
        assertEquals(1, Calculator.add("1"));
    }

    @Test
    @DisplayName("two numbers should return their sum")
    public void twoNumbersShouldReturnSum() {
        assertEquals(3, Calculator.add("1,2"));
    }

    @Test
    @DisplayName("sum of multiple numbers should be calculated correctly")
    public void sumOfMultipleNumbersShouldBeCalculatedCorrectly() {
        assertEquals(10, Calculator.add("1,2,3,4"));
    }

    @Test
    @DisplayName("numbers with newline should return correct sum")
    public void numbersWithNewlineShouldReturnCorrectSum() {
        assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    @DisplayName("adding numbers with default delimiters (',' and '\\n')")
    public void addNumbersWithDefaultDelimiters() {
        assertEquals(6, Calculator.add("1,2,3"));
        assertEquals(15, Calculator.add("1,2,3,4,5"));
        assertEquals(10, Calculator.add("1\n2,3\n4"));
    }

    @Test
    @DisplayName("adding numbers with custom delimiter ';'")
    public void addNumbersWithCustomDelimiterSemicolon() {
        assertEquals(3, Calculator.add("//;\n1;2"));
    }

    @Test
    @DisplayName("add with single negative number should throw exception with that number")
    public void addWithSingleNegativeNumberShouldThrowException() {
        String input = "-5";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.add(input);
        });
        assertTrue(exception.getMessage().contains("-5"));
    }

    @Test
    @DisplayName("add with only negative numbers should throw an exception with negative numbers")
    public void addWithOnlyNegativeNumbersShouldThrowException() {
        String input = "-1,-2,-3,-4,-5";
        try {
            Calculator.add(input);
            fail("Expected IllegalArgumentException, but no exception was thrown");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("-1"));
            assertTrue(e.getMessage().contains("-2"));
            assertTrue(e.getMessage().contains("-3"));
            assertTrue(e.getMessage().contains("-4"));
            assertTrue(e.getMessage().contains("-5"));
        }
    }

    @Test
    @DisplayName("add with positive and negative numbers should throw an exception with negative numbers")
    public void addWithPositiveAndNegativeNumbersShouldThrowException() {
        String input = "-1,2,-3,4,-5";
        try {
            Calculator.add(input);
            fail("Expected IllegalArgumentException, but no exception was thrown");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("-1"));
            assertTrue(e.getMessage().contains("-3"));
            assertTrue(e.getMessage().contains("-5"));
        }
    }

    @Test
    @DisplayName("add with more positive than negative numbers should throw an exception with negative numbers")
    public void addWithMorePositiveThanNegativeNumbersShouldThrowException() {
        String input = "1,2,-3,4,5";
        try {
            Calculator.add(input);
            fail("Expected IllegalArgumentException, but no exception was thrown");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("-3"));
        }
    }

}