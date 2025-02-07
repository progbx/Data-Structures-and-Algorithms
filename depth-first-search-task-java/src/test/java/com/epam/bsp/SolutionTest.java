package com.epam.bsp;

import java.util.*;

import org.junit.jupiter.api.Test;

import static com.epam.bsp.Solution.*;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    @Test
    public void testCheckPathExistence() {
        //sample tests
        assertFalse(checkPathExistence(5, new HashMap<>(), 0, 4));

        Map<Integer, Set<Integer>> edges = Map.of(
                1, Set.of(0, 3),
                0, Set.of(2),
                3, Set.of(4)
        );
        assertTrue(checkPathExistence(5, edges, 1, 4));
        assertFalse(checkPathExistence(5, edges, 4, 1));

        edges = Map.of(
                4, Set.of(3),
                3, Set.of(2),
                2, Set.of(1),
                1, Set.of(0)
        );
        assertTrue(checkPathExistence(5, edges, 3, 0));
        assertFalse(checkPathExistence(5, edges, 0, 1));
    }

    @Test
    public void testCheckBipartiteGraph() {
        //sample tests
        Map<Integer, Set<Integer>> edges = Map.of(
                0, Set.of(1, 4),
                1, Set.of(0, 2),
                2, Set.of(1, 3),
                3, Set.of(2, 4),
                4, Set.of(3, 0)
        );
        assertFalse(checkBipartiteGraph(5, edges));

        edges = Map.of(
                0, Set.of(1),
                1, Set.of(0, 2),
                2, Set.of(1, 3),
                3, Set.of(2, 4),
                4, Set.of(3)
        );
        assertTrue(checkBipartiteGraph(5, edges));

        edges = Map.of(
                0, Set.of(1, 3),
                1, Set.of(0, 2, 4),
                2, Set.of(1, 4),
                3, Set.of(0, 5),
                4, Set.of(1, 2),
                5, Set.of(3)
        );
        assertFalse(checkBipartiteGraph(6, edges));

        edges = Map.of(
                0, Set.of(1, 3),
                1, Set.of(0, 2, 5),
                2, Set.of(1, 4),
                3, Set.of(0, 5),
                4, Set.of(2, 5),
                5, Set.of(1, 3, 4)
        );
        assertTrue(checkBipartiteGraph(6, edges));
    }

    @Test
    public void testGetLengthOfLongestPathInDAG() {
        //sample tests
        assertEquals(0, getLengthOfLongestPathInDAG(5, new HashMap<>()));

        Map<Integer, Set<Integer>> edges = Map.of(
                0, Set.of(2),
                1, Set.of(0, 3),
                3, Set.of(4)
        );
        assertEquals(2, getLengthOfLongestPathInDAG(5, edges));

        edges = Map.of(
                0, Set.of(1, 2),
                1, Set.of(0),
                2, Set.of(0)
        );
        assertEquals(4, getLengthOfLongestPathInDAG(5, edges));

        edges = Map.of(
                0, Set.of(1, 3),
                1, Set.of(2),
                2, Set.of(5),
                3, Set.of(4),
                5, Set.of(3)
        );
        assertEquals(5, getLengthOfLongestPathInDAG(6, edges));
    }
}