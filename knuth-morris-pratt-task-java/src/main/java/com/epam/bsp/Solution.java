package com.epam.bsp;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int[] buildLPSArray(String text) {
        int n = text.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < n) {
            if (text.charAt(i) == text.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;}}}
        return lps;
    }
    public static List<Integer> findOccurrencesViaKMP(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        int m = pattern.length();
        int n = text.length();
        if (m == 0) {
            return result;
        }
        int[] lps = buildLPSArray(pattern);
        int i = 0;
        int j = 0;
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == m) {
                result.add(i - j);
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;}}}
        return result;
    }
    public static boolean isTandemRepeat(String text) {
        int n = text.length();
        int[] lps = buildLPSArray(text);
        int lengthOfPattern = lps[n - 1];
        return lengthOfPattern > 0 && n % (n - lengthOfPattern) == 0;
    }
}