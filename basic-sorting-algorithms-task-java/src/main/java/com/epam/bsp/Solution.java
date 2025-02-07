package com.epam.bsp;

public class Solution {
    public static <T extends Comparable<T>> T[] partialSelectionSort(T[] data, int k) {
        for (int i = 0; i < k; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T temp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = temp;
            }
        }
        return data;
    }
    public static <T extends Comparable<T>> T[] partialInsertionSort(T[] data, int k) {
        for (int i = 1; i <= k; i++) {
            T key = data[i];
            int j = i - 1;
            while (j >= 0 && data[j].compareTo(key) > 0) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }
        return data;
    }
    public static <T extends Comparable<T>> T[] partialBubbleSort(T[] data, int k) {
        int swaps = 0;
        boolean swapped;
        for (int i = 0; i < data.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    T temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    swaps++;
                    swapped = true;
                    if (swaps == k) {
                        return data;
                    }
                }
            }
            if (!swapped) {
                break;
            }
        }
        return data;
    }
}