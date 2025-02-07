package com.epam.bsp;

import org.javatuples.Pair;

import java.util.*;

public class Solution {
    public static double getMaximumProbabilityPath(
            int n,
            Map<Integer, Map<Integer, Double>> edges,
            int vertexV,
            int vertexU
    ) {
        double[] maxProb = new double[n];
        maxProb[vertexV] = 1.0;
        PriorityQueue<Pair<Integer, Double>> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(b.getValue1(), a.getValue1())
        );
        pq.offer(new Pair<>(vertexV, 1.0));
        while (!pq.isEmpty()) {
            Pair<Integer, Double> current = pq.poll();
            int node = current.getValue0();
            double prob = current.getValue1();
            if (node == vertexU) {
                return prob;
            }
            for (Map.Entry<Integer, Double> neighbor : edges.getOrDefault(node, Collections.emptyMap()).entrySet()) {
                int nextNode = neighbor.getKey();
                double edgeProb = neighbor.getValue();
                double newProb = prob * edgeProb;
                if (newProb > maxProb[nextNode]) {
                    maxProb[nextNode] = newProb;
                    pq.offer(new Pair<>(nextNode, newProb));}}}
        return 0.0;
    }
    public static Optional<Pair<Integer, Integer>> findShortestPathsCost(
            int n,
            Map<Integer, Map<Integer, Integer>> edges,
            int vertexV
    ) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[vertexV] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int u = 0; u < n; u++) {
                for (Map.Entry<Integer, Integer> entry : edges.getOrDefault(u, Collections.emptyMap()).entrySet()) {
                    int v = entry.getKey();
                    int weight = entry.getValue();
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;}}}}
        for (int u = 0; u < n; u++) {
            for (Map.Entry<Integer, Integer> entry : edges.getOrDefault(u, Collections.emptyMap()).entrySet()) {
                int v = entry.getKey();
                int weight = entry.getValue();
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    return Optional.empty();}}}
        int sumCost = 0;
        int unachievableCount = 0;
        for (int d : dist) {
            if (d == Integer.MAX_VALUE) {
                unachievableCount++;
            } else {
                sumCost += d;}}
        return Optional.of(new Pair<>(sumCost, unachievableCount));}
}