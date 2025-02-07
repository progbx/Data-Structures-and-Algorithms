package com.epam.bsp.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FuzzySearchEngine {
    public List<String> corpus;
    public FuzzySearchEngine(List<String> corpus) {
        this.corpus = corpus;
    }
    public List<String> findBestMatches(String queryText, int nResults) {
        List<String> results = new ArrayList<>(corpus);
        Collections.sort(results, Comparator.comparingInt((String s) -> findLevenshteinDistance(s, queryText))
                .thenComparing(s -> s));
        return results.subList(0, Math.min(nResults, results.size()));
    }
    private int findLevenshteinDistance(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int[][] dp = new int[lenA + 1][lenB + 1];
        for (int i = 0; i <= lenA; i++) {
            for (int j = 0; j <= lenB; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[lenA][lenB];
    }
}