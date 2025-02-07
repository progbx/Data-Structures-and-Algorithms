package com.epam.bsp.graph;

import java.util.*;

public class GraphAdjacencyDictionary implements UndirectedGraphRepresentation {
    private Map<Integer, Set<Integer>> adjacencyDictionary;
    public GraphAdjacencyDictionary(int numberOfVertices) {
        adjacencyDictionary = new HashMap<>();
        for (int i = 0; i < numberOfVertices; i++) {
            adjacencyDictionary.put(i, new HashSet<>());
        }
    }
    @Override
    public void addEdge(int vertexA, int vertexB) {
        adjacencyDictionary.get(vertexA).add(vertexB);
        adjacencyDictionary.get(vertexB).add(vertexA);
    }
    @Override
    public int[] getAdjacencyIndicators(int vertex) {
        int[] indicators = new int[adjacencyDictionary.size()];
        Set<Integer> adjacentVertices = adjacencyDictionary.get(vertex);
        for (int adjacentVertex : adjacentVertices) {
            indicators[adjacentVertex] = 1;
        }
        return indicators;
    }
    @Override
    public int getNumberOfAdjacentVertices(int vertex) {
        return adjacencyDictionary.get(vertex).size();
    }
    @Override
    public boolean edgeExists(int vertexA, int vertexB) {
        return adjacencyDictionary.get(vertexA).contains(vertexB);
    }
    public static void main(String[] args) {
        GraphAdjacencyDictionary graph = new GraphAdjacencyDictionary(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        int[] adjacencyIndicators = graph.getAdjacencyIndicators(0);
        System.out.println(Arrays.toString(adjacencyIndicators));
        int adjacentVerticesCount = graph.getNumberOfAdjacentVertices(1);
        System.out.println(adjacentVerticesCount);
        boolean exists = graph.edgeExists(0, 1);
        System.out.println(exists);
        exists = graph.edgeExists(0, 2);
        System.out.println(exists);
    }
}