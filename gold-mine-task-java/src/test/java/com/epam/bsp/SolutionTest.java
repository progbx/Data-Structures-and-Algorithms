package com.epam.bsp;

import org.junit.jupiter.api.Test;

import static com.epam.bsp.Solution.*;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    public void testSolveAlsProblem() {
        //sample tests
        assertEquals(
                10,
                getMaximumAmountOfGold(new int[][]{
                        {10}
                })
        );
        assertEquals(
                9,
                getMaximumAmountOfGold(new int[][]{
                        {7, 2},
                        {4, 1}
                })
        );
        assertEquals(
                12,
                getMaximumAmountOfGold(new int[][]{
                        {3, 2, 1},
                        {4, 1, 5},
                        {1, 6, 2}
                })
        );
        assertEquals(
                16,
                getMaximumAmountOfGold(new int[][]{
                        {3, 2, 1, 6},
                        {4, 1, 1, 8},
                        {1, 6, 2, 4}
                })
        );
        assertEquals(
                18,
                getMaximumAmountOfGold(new int[][]{
                        {4, 1, 6, 7},
                        {4, 1, 5, 3},
                        {6, 6, 1, 2},
                        {7, 1, 1, 1}
                })
        );
    }
}