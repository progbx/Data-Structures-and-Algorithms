package com.epam.bsp;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.javatuples.Pair;
import org.javatuples.Triplet;


import com.epam.bsp.disjoint.set.DisjointSets;

public class Solution {
    public static Optional<Integer> kruskalMST(int n, List<Triplet<Integer, Integer, Integer>> edges) {
        edges.sort(Comparator.comparing(Triplet::getValue2));
        DisjointSets<Integer> ds = new DisjointSets<>();
        for (int i = 0; i < n; i++) {
            ds.makeSet(i);
        }
        int result = 0;
        int nUnions = 0;
        for (Triplet<Integer, Integer, Integer> edge : edges) {
            Integer x = ds.findSet(edge.getValue0());
            Integer y = ds.findSet(edge.getValue1());
            if (!x.equals(y)) {
                nUnions++;
                result += edge.getValue2();
                ds.unionSets(x, y);
            }
        }
        return nUnions == n - 1 ? Optional.of(result) : Optional.empty();
    }
    public static Optional<Pair<Integer[], Integer>> primMST(int n, int[][] adjacencyMatrix) {
        boolean[] mstFlag = new boolean[n];
        int[] minEdge = new int[n];
        Integer[] mstAddingOrder = new Integer[n];
        for (int i = 0; i < n; i++) {
            mstFlag[i] = false;
            minEdge[i] = Integer.MAX_VALUE;
            mstAddingOrder[i] = -1;
        }
        mstFlag[0] = true;
        minEdge[0] = 0;
        int mstWeight = 0;
        mstAddingOrder[0] = 0;
        int nAdded = 1;
        for (int i = 0; i < n; i++) {
            if (adjacencyMatrix[0][i] > 0) {
                minEdge[i] = adjacencyMatrix[0][i];
            }
        }
        for (int i = 1; i < n; i++) {
            int v = -1;
            for (int j = 0; j < n; j++) {
                if (mstFlag[j]) {
                    continue;
                }
                if (v == -1) {
                    v = j;
                }
                if (minEdge[v] > minEdge[j]) {
                    v = j;
                }
            }
            if (v == -1 || minEdge[v] == Integer.MAX_VALUE) {
                break;
            }
            mstFlag[v] = true;
            mstAddingOrder[nAdded] = v;
            nAdded++;
            mstWeight += minEdge[v];
            for (int j = 0; j < n; j++) {
                if (adjacencyMatrix[v][j] > 0 && adjacencyMatrix[v][j] < minEdge[j]) {
                    minEdge[j] = adjacencyMatrix[v][j];}}}
        return nAdded == n ? Optional.of(Pair.with(mstAddingOrder, mstWeight)) : Optional.empty();
    }
}