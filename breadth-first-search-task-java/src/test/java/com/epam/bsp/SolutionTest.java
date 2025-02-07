package com.epam.bsp;

import java.util.*;

import org.junit.jupiter.api.Test;

import static com.epam.bsp.Solution.*;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    @Test
    public void testFindNumberOfComponents() {
        //sample tests
        assertEquals(5, findNumberOfComponents(5, new HashMap<>()));
        assertEquals(10, findNumberOfComponents(10, new HashMap<>()));

        Map<Integer, Set<Integer>> edges = Map.of(
                0, Set.of(6, 7),
                6, Set.of(0, 7),
                7, Set.of(0, 6)
        );
        assertEquals(findNumberOfComponents(10, edges), 8);

        edges = Map.of(
                0, Set.of(1, 2),
                1, Set.of(0, 2),
                2, Set.of(0, 1)
        );
        assertEquals(findNumberOfComponents(5, edges), 3);

        edges = Map.of(
                0, Set.of(1, 4),
                1, Set.of(0, 2),
                2, Set.of(1, 3),
                3, Set.of(2, 4),
                4, Set.of(3, 0)
        );
        assertEquals(1, findNumberOfComponents(5, edges));
    }

    @Test
    public void testGetDistancesFromVertex() {
        //sample tests
        assertArrayEquals(
                new int[]{-1, 0, -1, -1, -1},
                getDistancesFromVertex(5, new HashMap<>(), 1)
        );

        Map<Integer, Set<Integer>> edges = Map.of(
                0, Set.of(1, 2),
                1, Set.of(0),
                2, Set.of(0)
        );
        assertArrayEquals(
                new int[]{1, 2, 0, -1, -1},
                getDistancesFromVertex(5, edges, 2)
        );

        edges = Map.of(
                0, Set.of(1, 4),
                1, Set.of(0, 2),
                2, Set.of(1, 3),
                3, Set.of(2, 4),
                4, Set.of(0, 3)
        );
        assertArrayEquals(
                new int[]{1, 2, 2, 1, 0},
                getDistancesFromVertex(5, edges, 4)
        );
    }

    @Test
    public void testCheckCycleExistence() {
        //sample tests
        assertFalse(checkCycleExistence(5, new HashMap<>()));

        Map<Integer, Set<Integer>> edges = Map.of(
                0, Set.of(6, 7),
                6, Set.of(0, 7),
                7, Set.of(0, 6)
        );
        assertTrue(checkCycleExistence(10, edges));

        edges = Map.of(
                0, Set.of(1, 2),
                1, Set.of(0),
                2, Set.of(0)
        );
        assertFalse(checkCycleExistence(5, edges));

        edges = Map.of(
                0, Set.of(1, 4),
                1, Set.of(0, 2),
                2, Set.of(1, 3),
                3, Set.of(2, 4),
                4, Set.of(3, 0)
        );
        assertTrue(checkCycleExistence(5, edges));
    }
}