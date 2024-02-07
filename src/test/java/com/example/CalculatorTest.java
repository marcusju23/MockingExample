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

}