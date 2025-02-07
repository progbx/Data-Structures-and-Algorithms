package com.epam.bsp;

import java.util.Map;
import java.util.*;

public class Solution {
    public static int findNumberOfComponents(int n, Map<Integer, Set<Integer>> edges) {
        boolean[] visited = new boolean[n];
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                bfs(i, edges, visited);}}
        return components;
    }
    private static void bfs(int start, Map<Integer, Set<Integer>> edges, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            if (edges.containsKey(vertex)) {
                for (int neighbor : edges.get(vertex)) {
                    if (!visited[neighbor]) {
                        queue.offer(neighbor);
                        visited[neighbor] = true;}}}}}
    public static boolean checkCycleExistence(int n, Map<Integer, Set<Integer>> edges) {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (bfsCheckCycle(i, edges, visited)) {
                    return true;}}}
        return false;
    }
    private static boolean bfsCheckCycle(int start, Map<Integer, Set<Integer>> edges, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> parent = new HashMap<>();
        queue.offer(start);
        visited[start] = true;
        parent.put(start, -1);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            if (edges.containsKey(vertex)) {
                for (int neighbor : edges.get(vertex)) {
                    if (!visited[neighbor]) {
                        queue.offer(neighbor);
                        visited[neighbor] = true;
                        parent.put(neighbor, vertex);
                    } else if (parent.get(vertex) != neighbor) {
                        return true;}}}}
        return false;
    }
    public static int[] getDistancesFromVertex(int n, Map<Integer, Set<Integer>> edges, int vertex) {
        int[] distances = new int[n];
        Arrays.fill(distances, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        distances[vertex] = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (edges.containsKey(current)) {
                for (int neighbor : edges.get(current)) {
                    if (distances[neighbor] == -1) {
                        queue.offer(neighbor);
                        distances[neighbor] = distances[current] + 1;}}}}
        return distances;}
}