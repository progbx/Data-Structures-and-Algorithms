package com.epam.bsp;

import java.util.*;

public class Solution {
    public static class Pair {
        private int global;
        private int local;
        public Pair(int global, int local) {
            this.global = global;
            this.local = local;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return global == pair.global && local == pair.local;
        }
        @Override
        public int hashCode() {
            return Objects.hash(global, local);
        }
        @Override
        public String toString() {
            return "Pair{" + global + ", " + local + '}';
        }
    }

    record Node(String str, int idx) {
    }

    public static List<Pair> bucketSort(List<String> patterns, int prefixLength) {
        Map<String, List<Node>> buckets = new HashMap<>();
        for (int i = 0; i < patterns.size(); i++) {
            var pattern = patterns.get(i);
            String prefix = pattern.substring(0, prefixLength);
            buckets.computeIfAbsent(prefix, k -> new ArrayList<>()).add(new Node(pattern, i));
        }
        var result = new ArrayList<Pair>(patterns.size());
        for (int i = 0; i < patterns.size(); i++) {
            result.add(null);
        }
        var keys = new ArrayList<>(buckets.keySet());
        keys.sort(Comparator.naturalOrder());
        int globalPosition = 0;
        for (var prefix : keys) {
            var bucket = buckets.get(prefix);
            bucket.sort(Comparator.comparing(a -> a.str));
            for (int i = 0; i < bucket.size(); i++) {
                result.set(bucket.get(i).idx, new Pair(globalPosition++, i));
            }}
        return result;
    }
    public static List<Integer> radixSort(List<String> array, int k) {
        var list = new ArrayList<Node>(array.size());
        for (int i = 0; i < array.size(); i++) {
            list.add(new Node(array.get(i), i));
        }
        int index = array.get(0).length() - 1;
        for (; k > 0; k--, index--) {
            var digs = new List[10];
            for (int i = 0; i < 10; i++) {
                digs[i] = new ArrayList<Node>();
            }
            for (Node node : list) {
                digs[node.str.charAt(index) - '0'].add(node);
            }
            var newList = new ArrayList<Node>(list.size());
            for (int i = 0; i < 10; i++) {
                for (var node : digs[i])
                    newList.add((Node) node);
            }
            list = newList;
        }

        List<Integer> result = new ArrayList<>(array.size());
        for (int i = 0; i < array.size(); i++) {
            result.add(0);
        }
        int i = 0;
        for (var node : list) {
            result.set(node.idx, i++);
        }
        return result;
    }
}