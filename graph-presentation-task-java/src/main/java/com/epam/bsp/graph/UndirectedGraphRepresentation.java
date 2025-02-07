package com.epam.bsp.graph;

public interface UndirectedGraphRepresentation {
    void addEdge(int vertexA, int vertexB);
    int[] getAdjacencyIndicators(int vertex);
    int getNumberOfAdjacentVertices(int vertex);
    boolean edgeExists(int vertexA, int vertexB);
}
