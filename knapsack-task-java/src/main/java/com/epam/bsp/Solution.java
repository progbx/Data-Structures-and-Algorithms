package com.epam.bsp;

public class Solution {
    public static int[][] getOptimalSubstructure(int[] weights, int[] values, int w) {
        int n = weights.length;
        int[][] f = new int[n + 1][w + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (weights[i - 1] <= j) {
                    f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - weights[i - 1]] + values[i - 1]);
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }
        }
        return f;
    }
    public static int[] getOptimalSolution(int[] weights, int[][] optimalSubstructure) {
        int n = optimalSubstructure.length - 1;
        int w = optimalSubstructure[0].length - 1;
        int[] solution = new int[n];

        for (int i = n, j = w; i > 0 && j > 0; i--) {
            if (optimalSubstructure[i][j] != optimalSubstructure[i - 1][j]) {
                solution[i - 1] = 1;
                j -= weights[i - 1];
            }
        }
        return solution;
    }
}