package com.epam.bsp;

import org.junit.jupiter.api.Test;

import static com.epam.bsp.Solution.*;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    public void testGetOptimalSubstructure() {
        //sample tests
        assertArrayEquals(
                new int[][]{
                        {0, 420, 432, 522},
                        {0, 0, 252, 468},
                        {0, 0, 0, 126},
                        {0, 0, 0, 0}
                },
                getOptimalSubstructure(
                        new int[][]{{5, 12}, {12, 7}, {7, 3}, {3, 6}}
                )
        );
        assertArrayEquals(
                new int[][]{
                        {0, 30, 32},
                        {0, 0, 20},
                        {0, 0, 0}
                },
                getOptimalSubstructure(
                        new int[][]{{3, 2}, {2, 5}, {5, 2}}
                )
        );
        assertArrayEquals(
                new int[][]{
                        {0, 15, 33, 45},
                        {0, 0, 90, 66},
                        {0, 0, 0, 36},
                        {0, 0, 0, 0}
                },
                getOptimalSubstructure(
                        new int[][]{{1, 5}, {5, 3}, {3, 6}, {6, 2}}
                )
        );
    }

    @Test
    public void testGetMCMSolution() {
        //sample tests
        assertEquals(
                "(*(*))*",
                getMCMSolution(
                        new int[][]{{5, 12}, {12, 7}, {7, 3}, {3, 6}}
                )
        );
        assertEquals(
                "*(*)",
                getMCMSolution(
                        new int[][]{{3, 2}, {2, 5}, {5, 2}}
                )
        );
        assertEquals(
                "((*)*)*",
                getMCMSolution(
                        new int[][]{{1, 5}, {5, 3}, {3, 6}, {6, 2}}
                )
        );
    }
}