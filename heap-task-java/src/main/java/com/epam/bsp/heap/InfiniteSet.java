package com.epam.bsp.heap;

import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.TreeSet;

public class InfiniteSet {
    private TreeSet<Integer> set;
    private int nextNumber;
    public InfiniteSet() {
        set = new TreeSet<>();
        nextNumber = 1;
    }
    public int popMinimum() {
        if (!set.isEmpty()) {
            return set.pollFirst();
        }
        int currentNumber = nextNumber;
        nextNumber++;
        return currentNumber;
    }
    public void insert(int x) {
        if (x != nextNumber) {
            set.add(x);
        } else {
            nextNumber++;
        }
        while (set.contains(nextNumber)) {
            set.remove(nextNumber);
            nextNumber++;
        }
    }
}