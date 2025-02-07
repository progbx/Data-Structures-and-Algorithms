package com.epam.bsp.heap;

import java.util.ArrayList;
import java.util.List;
public class CustomPriorityQueue<E extends Comparable<E>> {
    private final List<E> heap;
    public CustomPriorityQueue() {
        this.heap = new ArrayList<>();
    }
    public E getMinimum() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        return heap.get(0);
    }
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        E minimum = getMinimum();
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return minimum;
    }
    public void insert(E value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    public int size() {
        return heap.size();
    }
    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }
    private void heapifyDown(int index) {
        int leftChildIndex, rightChildIndex, smallestIndex;
        while (true) {
            leftChildIndex = 2 * index + 1;
            rightChildIndex = 2 * index + 2;
            smallestIndex = index;
            if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(smallestIndex)) < 0) {
                smallestIndex = leftChildIndex;
            }
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(smallestIndex)) < 0) {
                smallestIndex = rightChildIndex;
            }
            if (smallestIndex == index) {
                break;
            }
            swap(index, smallestIndex);
            index = smallestIndex;
        }
    }
    private void swap(int i, int j) {
        E temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}