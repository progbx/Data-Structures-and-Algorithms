package com.epam.bsp.disjoint.set;

import java.util.HashMap;
import java.util.Map;

public class DisjointSets<K> {

    private class Node {
        K key;
        Node parent;
        int rank;

        Node(K key) {
            this.key = key;
            this.parent = this;
            this.rank = 0;
        }
    }

    private final Map<K, Node> nodes = new HashMap<>();

    public void makeSet(K key) {
        nodes.put(key, new Node(key));
    }

    public K findSet(K key) {
        Node node = nodes.get(key);
        if (node == null) {
            return null;
        }

        if (!node.parent.equals(node)) {
            node.parent = nodes.get(findSet(node.parent.key));
        }

        return node.parent.key;
    }

    public void unionSets(K firstKey, K secondKey) {
        Node firstRoot = nodes.get(findSet(firstKey));
        Node secondRoot = nodes.get(findSet(secondKey));

        if (firstRoot == null || secondRoot == null || firstRoot.equals(secondRoot)) {
            return;
        }

        if (firstRoot.rank < secondRoot.rank) {
            firstRoot.parent = secondRoot;
        } else if (firstRoot.rank > secondRoot.rank) {
            secondRoot.parent = firstRoot;
        } else {
            secondRoot.parent = firstRoot;
            firstRoot.rank++;
        }
    }
}