package com.epam.bsp;

public class Solution {

    public static int getMaximumAmountOfGold(int[][] mines) {
        int m = mines.length;
        int n = mines[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = mines[i][0];
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                int upRight = (i > 0) ? dp[i - 1][j - 1] : 0;
                int right = dp[i][j - 1];
                dp[i][j] = Math.max(upRight, right) + mines[i][j];
            }
        }

        int maxGold = dp[0][n - 1];
        for (int i = 1; i < m; i++) {
            maxGold = Math.max(maxGold, dp[i][n - 1]);
        }

        return maxGold;
    }
}