package com.epam.bsp;

import org.javatuples.Pair;

import java.util.Arrays;

public class Solution {
    public static Pair<Integer, Integer> getSumOfAllShortestPaths(int n, int[][] adjacencyMatrix) {
        int[][] d = Arrays.copyOf(adjacencyMatrix, n * n);
        final int BIG_VALUE = Integer.MAX_VALUE >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (d[i][j] == 0 && i != j) {
                    d[i][j] = BIG_VALUE;}}}
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);}}}
        int sums = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (d[i][j] == BIG_VALUE) {
                    count++;
                } else {
                    sums += d[i][j];}}}
        return Pair.with(sums, count);
    }
}