package com.epam.bsp.graph;

import java.util.Arrays;

public class GraphAdjacencyMatrix implements UndirectedGraphRepresentation {
    private int[][] adjacencyMatrix;
    public GraphAdjacencyMatrix(int numberOfVertices) {
        adjacencyMatrix = new int[numberOfVertices][numberOfVertices];
    }
    @Override
    public void addEdge(int vertexA, int vertexB) {
        adjacencyMatrix[vertexA][vertexB] = 1;
        adjacencyMatrix[vertexB][vertexA] = 1;
    }
    @Override
    public int[] getAdjacencyIndicators(int vertex) {
        return adjacencyMatrix[vertex];
    }
    @Override
    public int getNumberOfAdjacentVertices(int vertex) {
        int count = 0;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[vertex][i] == 1) {
                count++;
            }
        }
        return count;
    }
    @Override
    public boolean edgeExists(int vertexA, int vertexB) {
        return adjacencyMatrix[vertexA][vertexB] == 1;
    }
    public static void main(String[] args) {
        GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(3);
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