package com.example;

public class Calculator {

    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String[] numberSegments = numbers.split("[,\n]");

        int sum = 0;
        for (String num : numberSegments) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }
}