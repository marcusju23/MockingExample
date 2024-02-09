package com.example;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = "[,\n]";
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            if (delimiterIndex != -1) {
                String customDelimiter = numbers.substring(2, delimiterIndex);
                delimiter = "[" + customDelimiter + "\n]";
                numbers = numbers.substring(delimiterIndex + 1);
            }
        }

        String[] numberSegments = numbers.split(delimiter);

        List<String> negatives = new ArrayList<>();
        int sum = 0;

        for (String num : numberSegments) {
            int currentNum = Integer.parseInt(num);
            if (currentNum < 0) {
                negatives.add(String.valueOf(currentNum));
            } else if (currentNum <= 1000) {
                sum += currentNum;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + String.join(", ", negatives));
        }

        return sum;
    }
}