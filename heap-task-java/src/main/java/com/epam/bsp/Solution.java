package com.epam.bsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import static java.util.Collections.swap;

public class Solution {

    public static List<Integer> minHeapify(List<Integer> data) {
        data = new ArrayList<>(data);
        for (int i = data.size() / 2 - 1; i >= 0; i--) {
            minHeapifyDown(data, i, data.size());
        }
        return data;
    }
    public static int[] heapSort(int[] data) {
        int n = data.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : data) {
            minHeap.add(i);
        }
        for (int i = 0; i < n; i++) {
            data[i] = minHeap.remove();
        }
        return data;
    }
    private static void minHeapifyDown(List<Integer> heap, int i, int size) {
        int smallest = i;
        int leftChildIdx = 2 * i + 1;
        int rightChildIdx = 2 * i + 2;
        if (leftChildIdx < size && heap.get(leftChildIdx) < heap.get(smallest)) {
            smallest = leftChildIdx;
        }
        if (rightChildIdx < size && heap.get(rightChildIdx) < heap.get(smallest)) {
            smallest = rightChildIdx;
        }
        if (smallest != i) {
            swap(heap, i, smallest);
            minHeapifyDown(heap, smallest, size);
        }
    }
}