package com.epam.bsp;

import com.epam.bsp.disjoint.set.DisjointSets;

import java.util.List;

public class Solution {

    public static class Pair {
        private int i;
        private int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static boolean isValidTree(int n, List<Pair> edges) {
        DisjointSets<Integer> disjointSets = new DisjointSets<>();

        for (int i = 0; i < n; i++) {
            disjointSets.makeSet(i);
        }

        for (Pair edge : edges) {
            int firstRoot = disjointSets.findSet(edge.getI());
            int secondRoot = disjointSets.findSet(edge.getJ());

            if (firstRoot == secondRoot) {
                return false;
            }

            disjointSets.unionSets(firstRoot, secondRoot);
        }

        return edges.size() == n - 1;
    }
}