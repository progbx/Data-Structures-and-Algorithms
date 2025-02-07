package com.epam.bsp.binary.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Solution {

    public static int guessNumber(int leftBound, int rightBound, Function<Integer, Integer> blackBox) {
        long lb = leftBound;
        long rb = rightBound;

        var trialNumber = lb;
        while (lb < rb) {
            if (blackBox.apply((int) trialNumber) >= 0)
                rb = trialNumber;
            else
                lb = trialNumber + 1;

            trialNumber = (rb + lb) >> 1;
        }
        return (int) trialNumber;
    }

    public static int getRequiredTime(List<Integer> capacities, int targetAmount) {
        int l = 1, r = Integer.MAX_VALUE / 2;

        while (r - l > 1) {
            int mid = l + (r - l) / 2;
            if (f(mid, capacities) >= targetAmount) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if (f(l, capacities) >= targetAmount) {
            return l;
        }

        return r;
    }

    private static int f(int time, List<Integer> capacities) {
        int sum = 0;
        for (int c : capacities) {
            sum += time / c;
        }
        return sum;
    }

    public static class Pair {
        private int left;
        private int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }

    }

    public static List<Integer> processQueries(List<Integer> array, List<Pair> queries) {
        List<Integer> result = new ArrayList<>();

        for (Pair query : queries) {
            int leftIndex = findLeftBound(array, query.getLeft());
            int rightIndex = findRightBound(array, query.getRight());
            result.add(rightIndex - leftIndex + 1);
        }

        return result;
    }

    private static int findLeftBound(List<Integer> array, int target) {
        int left = 0, right = array.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array.get(mid) >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int findRightBound(List<Integer> array, int target) {
        int left = 0, right = array.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}