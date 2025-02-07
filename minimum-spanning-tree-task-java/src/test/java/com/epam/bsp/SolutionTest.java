package com.epam.bsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.javatuples.Pair;
import org.javatuples.Triplet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    @Test
    public void testKruskalMST() {
        //sample tests
        List<Triplet<Integer, Integer, Integer>> edges = new ArrayList<>(
                List.of(
                        Triplet.with(0, 1, 1),
                        Triplet.with(0, 2, 1),
                        Triplet.with(2, 3, 5),
                        Triplet.with(0, 3, 1),
                        Triplet.with(2, 4, 7),
                        Triplet.with(3, 4, 5)
                )
        );
        assertEquals(Solution.kruskalMST(5, edges), Optional.of(8));

        edges = new ArrayList<>(
                List.of(
                        Triplet.with(0, 1, 1),
                        Triplet.with(0, 2, 1),
                        Triplet.with(2, 3, 5),
                        Triplet.with(0, 3, 1)
                )
        );
        assertEquals(Solution.kruskalMST(5, edges), Optional.empty());

        edges = new ArrayList<>(
                List.of(
                        Triplet.with(1, 0, 5),
                        Triplet.with(2, 0, 10),
                        Triplet.with(1, 2, 6)
                )
        );
        assertEquals(Solution.kruskalMST(3, edges), Optional.of(11));

        edges = new ArrayList<>(
                List.of(
                        Triplet.with(1, 0, 5),
                        Triplet.with(2, 0, 10)
                )
        );
        assertEquals(Solution.kruskalMST(3, edges), Optional.of(15));
    }

    @Test
    public void testPrimMST() {
        //sample tests
        int[][] adjacencyMatrix = new int[][]{
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };
        Pair<Integer[], Integer> result = Solution.primMST(5, adjacencyMatrix).get();
        assertArrayEquals(result.getValue0(), new Integer[]{0, 1, 2, 4, 3});
        assertEquals(result.getValue1(), 16);

        adjacencyMatrix = new int[][]{
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 0},
                {0, 3, 0, 0, 0},
                {6, 8, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        assertEquals(Solution.primMST(5, adjacencyMatrix), Optional.empty());

        adjacencyMatrix = new int[][]{
                {0, 10, 5},
                {10, 0, 6},
                {5, 6, 0}
        };
        result = Solution.primMST(3, adjacencyMatrix).get();
        assertArrayEquals(result.getValue0(), new Integer[]{0, 2, 1});
        assertEquals(result.getValue1(), 11);
    }
}