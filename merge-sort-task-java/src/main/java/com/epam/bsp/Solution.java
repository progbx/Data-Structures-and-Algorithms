package com.epam.bsp;

public class Solution {
    public static void mergeSortedSubarrays(int[] data, int leftIndex, int middleIndex, int rightIndex) {
        int n1 = middleIndex - leftIndex + 1;
        int n2 = rightIndex - middleIndex;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = data[leftIndex + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = data[middleIndex + 1 + j];
        }
        int i = 0, j = 0;
        int k = leftIndex;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                data[k] = leftArray[i];
                i++;
            } else {
                data[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            data[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            data[k] = rightArray[j];
            j++;
            k++;
        }
    }
    public static int mergeSortAlgorithm(int[] data) {
        return mergeSort(data, 0, data.length - 1);
    }
    private static int mergeSort(int[] data, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex)
            return 0;
        int middleIndex = (leftIndex + rightIndex) >> 1;
        int statistic = 0;
        if (Math.abs(leftIndex - rightIndex) > 1) {
            statistic += mergeSort(data, leftIndex, middleIndex);
            statistic += mergeSort(data, middleIndex + 1, rightIndex);
        }
        statistic += data[rightIndex] + data[middleIndex] + data[leftIndex];
        mergeSortedSubarrays(data, leftIndex, middleIndex, rightIndex);
        statistic += data[rightIndex] + data[middleIndex] + data[leftIndex];
        return statistic;
    }
}