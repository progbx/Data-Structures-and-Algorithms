package com.epam.bsp;

import java.util.Objects;

public class Solution {
    public static class Pair {
        private int index;
        private int swapsNumber;
        public Pair(int index, int swapsNumber) {
            this.index = index;
            this.swapsNumber = swapsNumber;
        }
        public int getIndex() {
            return index;
        }
        public void setIndex(int index) {
            this.index = index;
        }
        public int getSwapsNumber() {
            return swapsNumber;
        }
        public void setSwapsNumber(int swapsNumber) {
            this.swapsNumber = swapsNumber;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return index == pair.index && swapsNumber == pair.swapsNumber;
        }
        @Override
        public int hashCode() {
            return Objects.hash(index, swapsNumber);
        }
    }
    public static <T extends Comparable<T>> Pair lomutoPartition(T[] array, int leftIndex, int rightIndex) {
        T pivot = array[rightIndex];
        int i = leftIndex - 1;
        int swaps = 0;
        for (int j = leftIndex; j < rightIndex; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                swap(array, i, j);
                swaps++;
            }
        }
        swap(array, i + 1, rightIndex);
        swaps++;
        return new Pair(i + 1, swaps);
    }
    public static <T extends Comparable<T>> int quicksortLomuto(T[] array) {
        return iterationLomuto(array, 0, array.length - 1);
    }
    private static <T extends Comparable<T>> int iterationLomuto(T[] array, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) return 0;
        Pair pair = lomutoPartition(array, leftIndex, rightIndex);
        int swaps = pair.getSwapsNumber();
        swaps += iterationLomuto(array, leftIndex, pair.getIndex() - 1);
        swaps += iterationLomuto(array, pair.getIndex() + 1, rightIndex);
        return swaps;
    }
    public static <T extends Comparable<T>> Pair hoarePartition(T[] array, int leftIndex, int rightIndex) {
        T pivot = array[(leftIndex + rightIndex) / 2];
        int i = leftIndex;
        int j = rightIndex;
        int swaps = 0;
        while (true) {
            while (array[i].compareTo(pivot) < 0) i++;
            while (array[j].compareTo(pivot) > 0) j--;
            if (i >= j) return new Pair(j, swaps);
            swap(array, i, j);
            swaps++;
            i++;
            j--;
        }
    }
    public static <T extends Comparable<T>> int quicksortHoare(T[] array) {
        return iterationHoare(array, 0, array.length - 1);
    }
    private static <T extends Comparable<T>> int iterationHoare(T[] array, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) return 0;
        Pair pair = hoarePartition(array, leftIndex, rightIndex);
        int swaps = pair.getSwapsNumber();
        swaps += iterationHoare(array, leftIndex, pair.getIndex());
        swaps += iterationHoare(array, pair.getIndex() + 1, rightIndex);
        return swaps;
    }
    private static <T extends Comparable<T>> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}