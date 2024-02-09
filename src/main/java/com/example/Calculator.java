package com.example;

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

        int sum = 0;
        for (String num : numberSegments) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }
}
