package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("empty string should return zero")
    void emptyStringShouldReturnZero() {
        assertEquals(0, Calculator.add(""));
    }

    @Test
    @DisplayName("single number should return same")
    void singleNumberShouldReturnSame() {
        assertEquals(1, Calculator.add("1"));
    }

    @Test
    @DisplayName("two numbers should return their sum")
    void twoNumbersShouldReturnSum() {
        assertEquals(3, Calculator.add("1,2"));
    }

    @Test
    @DisplayName("sum of multiple numbers should be calculated correctly")
    void sumOfMultipleNumbersShouldBeCalculatedCorrectly() {
        assertEquals(10, Calculator.add("1,2,3,4"));
    }

    @Test
    @DisplayName("numbers with newline should return correct sum")
    void numbersWithNewlineShouldReturnCorrectSum() {
        assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    @DisplayName("adding numbers with default delimiters (',' and '\\n')")
    void addNumbersWithDefaultDelimiters() {
        assertEquals(6, Calculator.add("1,2,3"));
        assertEquals(15, Calculator.add("1,2,3,4,5"));
        assertEquals(10, Calculator.add("1\n2,3\n4"));
    }

    @Test
    @DisplayName("adding numbers with custom delimiter ';'")
    void addNumbersWithCustomDelimiterSemicolon() {
        assertEquals(3, Calculator.add("//;\n1;2"));
    }

    @Test
    @DisplayName("add with single negative number should throw exception with that number")
    void addWithSingleNegativeNumberShouldThrowException() {
        String input = "-5";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.add(input);
        });
        assertTrue(exception.getMessage().contains("-5"));
    }

    @Test
    @DisplayName("add with only negative numbers should throw an exception with negative numbers")
    void addWithOnlyNegativeNumbersShouldThrowException() {
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
    void addWithPositiveAndNegativeNumbersShouldThrowException() {
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
    void addWithMorePositiveThanNegativeNumbersShouldThrowException() {
        String input = "1,2,-3,4,5";
        try {
            Calculator.add(input);
            fail("Expected IllegalArgumentException, but no exception was thrown");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("-3"));
        }
    }

    @ParameterizedTest
    @DisplayName("add method handles different sets of numbers")
    @CsvSource(value = {"2,1001,5,2000,992;999", "2,998;1000", "1001,2000,5000;0"}, delimiter = ';')
    void addMethodHandlesDifferentSetsOfNumbers(String input, int expectedSum) {
        int sum = Calculator.add(input);
        assertThat(sum).isEqualTo(expectedSum);
    }
}