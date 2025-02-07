package com.epam.bsp;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import static com.epam.bsp.Solution.*;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    public void testSolveAlsProblem() {
        //sample tests
        Pair<Integer, Integer[]> solution1 = solveAlsProblem(
                new Pair<>(2, 3),
                new Pair<>(new Integer[]{5, 10}, new Integer[]{7, 1}),
                new Pair<>(new Integer[]{1}, new Integer[]{3}),
                new Pair<>(1, 1)
        );
        assertEquals(10, solution1.getValue0());
        assertArrayEquals(new Integer[]{1, 2}, solution1.getValue1());

        Pair<Integer, Integer[]> solution2 = solveAlsProblem(
                new Pair<>(2, 6),
                new Pair<>(new Integer[]{5, 2, 9, 1}, new Integer[]{3, 5, 2, 1}),
                new Pair<>(new Integer[]{5, 2, 1}, new Integer[]{1, 4, 2}),
                new Pair<>(2, 4)
        );
        assertEquals(18, solution2.getValue0());
        assertArrayEquals(new Integer[]{1, 1, 2, 2}, solution2.getValue1());
    }
}