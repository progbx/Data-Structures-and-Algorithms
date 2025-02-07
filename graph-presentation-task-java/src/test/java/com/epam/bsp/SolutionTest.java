package com.epam.bsp;

import com.epam.bsp.graph.GraphAdjacencyDictionary;
import com.epam.bsp.graph.GraphAdjacencyMatrix;
import com.epam.bsp.graph.UndirectedGraphRepresentation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    public void testGraphAdjacencyMatrix() {
        runSampleTests(new GraphAdjacencyMatrix(5));
    }

    @Test
    public void testGraphAdjacencyDictionary() {
        runSampleTests(new GraphAdjacencyDictionary(5));
    }

    private void runSampleTests(UndirectedGraphRepresentation graph) {
        assertEquals(0, graph.getNumberOfAdjacentVertices(0));

        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, graph.getAdjacencyIndicators(0));
        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, graph.getAdjacencyIndicators(2));

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        assertArrayEquals(new int[]{0, 1, 0, 0, 0}, graph.getAdjacencyIndicators(0));
        assertArrayEquals(new int[]{0, 1, 0, 1, 0}, graph.getAdjacencyIndicators(2));

        assertEquals(1, graph.getNumberOfAdjacentVertices(0));
        assertEquals(2, graph.getNumberOfAdjacentVertices(1));
        assertEquals(1, graph.getNumberOfAdjacentVertices(4));

        assertTrue(graph.edgeExists(0, 1));
        assertTrue(graph.edgeExists(2, 1));
        assertTrue(graph.edgeExists(2, 3));
        assertTrue(graph.edgeExists(4, 3));

        assertFalse(graph.edgeExists(4, 0));
        assertFalse(graph.edgeExists(2, 4));
        assertFalse(graph.edgeExists(1, 3));
    }

}