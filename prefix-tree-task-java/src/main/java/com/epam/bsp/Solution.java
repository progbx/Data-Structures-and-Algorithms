package com.epam.bsp;

public class Solution {
    public static int getNumberOfMatches(String text, String[] patterns) {
        var count = 0;
        for (String pattern : patterns) {
            count += countOccurrences(pattern, text);
        }
        return count;
    }
    private static int countOccurrences(String pattern, String text) {
        if (pattern.length() == 0 || text.length() == 0) {
            return 0;
        }
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(pattern, index)) != -1) {
            count++;
            index++;
        }
        return count;
    }
}