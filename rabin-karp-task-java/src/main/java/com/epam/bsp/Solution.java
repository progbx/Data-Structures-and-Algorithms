package com.epam.bsp;

import java.util.ArrayList;
import java.util.List;

import com.epam.bsp.hash.RollingHash;

public class Solution {

    /**
     * Returns all positions within a text where a given pattern occurs.
     *
     * NOTE: Please use the Rabin-Karp algorithm.
     *
     * NOTE: The parameter `deterministic` defines whether hash value hits
     * should be checked explicitly or whether false positive matches are fine.
     *
     * @param text the text to be searched.
     * @param pattern the pattern to search for.
     * @param hashBase the base value for polynomial hashing (P).
     * @param hashModulo the modulo that will be used for hashing (M).
     * @param deterministic whether hash value hits should be checked explicitly.
     * @return all indices in the text where the pattern occurs.
     */
    public static List<Integer> findOccurrencesViaRabinKarp(
            String text,
            String pattern,
            int hashBase,
            int hashModulo,
            boolean deterministic
    ) {
        List<Integer> result = new ArrayList<>();
        if (pattern.length() > text.length()) {
            return result;
        }
        RollingHash rollingHash = new RollingHash(text, hashBase, hashModulo);
        RollingHash patternHash = new RollingHash(pattern, hashBase, hashModulo);
        int patternHashValue = patternHash.getHash(0, pattern.length() - 1);
        int textHashValue = rollingHash.getHash(0, pattern.length() - 1);
        long power = rollingHash.getPowers()[pattern.length() - 1];
        if (textHashValue == patternHashValue) {
            if (!deterministic || text.substring(0, pattern.length()).equals(pattern)) {
                result.add(0);
            }
        }
        for (int i = 1; i <= text.length() - pattern.length(); i++) {
            textHashValue = (int)(((textHashValue - text.charAt(i - 1) * power) * hashBase + text.charAt(i + pattern.length() - 1)) % hashModulo);
            if (textHashValue < 0) {
                textHashValue += hashModulo;
            }
            if (textHashValue == patternHashValue) {
                if (!deterministic || text.substring(i, i + pattern.length()).equals(pattern)) {
                    result.add(i);
                }
            }
        }
        return result;
    }

}