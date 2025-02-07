package com.epam.bsp;

public class Solution {
    public static int[][] getOptimalSubstructure(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] f = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    f[i][j] = 0;
                else if (a.charAt(i - 1) == b.charAt(j - 1))
                    f[i][j] = f[i - 1][j - 1] + 1;
                else
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
            }
        }
        return f;
    }
    public static String getOptimalSolution(String a, int[][] optimalSubstructure) {
        int i = a.length();
        int j = optimalSubstructure[0].length - 1;
        StringBuilder lcs = new StringBuilder();

        while (i > 0 && j > 0) {
            if (optimalSubstructure[i][j] == optimalSubstructure[i - 1][j])
                i--;
            else if (optimalSubstructure[i][j] == optimalSubstructure[i][j - 1])
                j--;
            else {
                lcs.append(a.charAt(i - 1));
                i--;
                j--;
            }
        }
        return lcs.reverse().toString();
    }
}