package com.epam.bsp.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testGetIslandsCountSample() {
        int[][] grid = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        assertEquals(1, Solution.getIslandsCount(grid));

        int[][] grid2 = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1, 1}
        };
        assertEquals(2, Solution.getIslandsCount(grid2));
    }

    @Test
    public void testGetMinimumKnightMovesSample() {
        char[][] chessboard = {
                "K.......".toCharArray(),
                "........".toCharArray(),
                "........".toCharArray(),
                "........".toCharArray(),
                "........".toCharArray(),
                "........".toCharArray(),
                "........".toCharArray(),
                ".....D..".toCharArray()
        };
        assertEquals(4, Solution.getMinimumKnightMoves(chessboard));

        char[][] chessboard2 = {
                "K...O...".toCharArray(),
                ".....O..".toCharArray(),
                ".O..OO..".toCharArray(),
                ".O......".toCharArray(),
                "...O.O..".toCharArray(),
                "O.OOO...".toCharArray(),
                "O.......".toCharArray(),
                "O....D..".toCharArray()
        };
            assertEquals(6, Solution.getMinimumKnightMoves(chessboard2));
    }

}
