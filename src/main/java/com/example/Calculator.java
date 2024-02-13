package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Calculator {

    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = "[,|\n]";
        if (numbers.startsWith("//")) {
            int startDelimiterIndex = numbers.indexOf("//") + 2;
            int endDelimiterIndex = numbers.indexOf("\n");
            String customDelimiter = numbers.substring(startDelimiterIndex, endDelimiterIndex);
            delimiter = "[" + Pattern.quote(customDelimiter) + "|\n]";
            numbers = numbers.substring(endDelimiterIndex + 1);
        }

        String[] numberSegments = numbers.split(delimiter);

        List<String> negatives = new ArrayList<>();
        int sum = 0;

        for (String num : numberSegments) {
            if (!num.isEmpty()) {
                int currentNum = Integer.parseInt(num);
                if (currentNum < 0) {
                    negatives.add(String.valueOf(currentNum));
                } else if (currentNum <= 1000) {
                    sum += currentNum;
                } else {
                    sum += 0;
                }
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + String.join(", ", negatives));
        }

        return sum;
    }
}