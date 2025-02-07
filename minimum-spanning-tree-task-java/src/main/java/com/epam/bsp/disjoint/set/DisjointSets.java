package com.epam.bsp.disjoint.set;

import java.util.HashMap;
import java.util.Map;

public class DisjointSets<K> {
    private final Map<K, K> parent = new HashMap<>();
    private final Map<K, Integer> rank = new HashMap<>();
    public void makeSet(K key) {
        parent.put(key, key);
        rank.put(key, 0);
    }
    public K findSet(K key) {
        if (!parent.containsKey(key)) {
            throw new IllegalArgumentException("Element not found");
        }
        if (!parent.get(key).equals(key)) {
            parent.put(key, findSet(parent.get(key)));
        }
        return parent.get(key);
    }
    public void unionSets(K firstKey, K secondKey) {
        K root1 = findSet(firstKey);
        K root2 = findSet(secondKey);
        if (!root1.equals(root2)) {
            int rank1 = rank.get(root1);
            int rank2 = rank.get(root2);
            if (rank1 > rank2) {
                parent.put(root2, root1);
            } else {
                parent.put(root1, root2);
                if (rank1 == rank2) {
                    rank.put(root2, rank2 + 1);}}}}
}