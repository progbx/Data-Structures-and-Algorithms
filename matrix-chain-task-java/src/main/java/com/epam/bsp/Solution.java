package com.epam.bsp;

public class Solution {
    public static int[][] getOptimalSubstructure(int[][] dimensionsOfMatrices) {
        int n = dimensionsOfMatrices.length;
        int[][] F = new int[n][n];

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                F[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = F[i][k] + F[k + 1][j]
                            + dimensionsOfMatrices[i][0] * dimensionsOfMatrices[k][1] * dimensionsOfMatrices[j][1];
                    if (q < F[i][j]) {
                        F[i][j] = q;
                    }
                }
            }
        }
        return F;
    }
    public static String getMCMSolution(int[][] dimensionsOfMatrices) {
        int n = dimensionsOfMatrices.length;
        int[][] F = new int[n][n];
        int[][] s = new int[n][n];

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                F[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = F[i][k] + F[k + 1][j]
                            + dimensionsOfMatrices[i][0] * dimensionsOfMatrices[k][1] * dimensionsOfMatrices[j][1];
                    if (q < F[i][j]) {
                        F[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }

        return buildSolution(s, 0, n - 1);
    }
    private static String buildSolution(int[][] s, int i, int j) {
        if (i == j) {
            return "";
        } else {
            int k = s[i][j];
            String term1 = buildSolution(s, i, k);
            String term2 = buildSolution(s, k + 1, j);
            if (i == 0 && j == s.length - 1) {
                return term1 + "*" + term2;
            } else {
                return "(" + term1 + "*" + term2 + ")";
            }
        }
    }
}