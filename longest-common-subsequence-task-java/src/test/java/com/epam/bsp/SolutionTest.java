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
                        {0, 0, 0},
                        {0, 1, 1},
                        {0, 1, 1}
                },
                getOptimalSubstructure("aa", "ab")
        );
        assertArrayEquals(
                new int[][]{
                        {0, 0, 0, 0},
                        {0, 1, 1, 1},
                        {0, 1, 1, 2},
                        {0, 1, 1, 2}
                },
                getOptimalSubstructure("aaa", "aba")
        );
        assertArrayEquals(
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 1, 1, 1, 1, 1, 1},
                        {0, 1, 1, 1, 1, 2, 2, 2},
                        {0, 1, 1, 1, 2, 2, 2, 2},
                        {0, 1, 1, 1, 2, 3, 3, 3},
                        {0, 1, 1, 1, 2, 3, 3, 3},
                        {0, 1, 1, 1, 2, 3, 3, 3}
                },
                getOptimalSubstructure("ababab", "accabcc")
        );
    }


    @Test
    public void testGetOptimalSolution() {
        //sample tests
        assertEquals(
                "a",
                getOptimalSolution(
                        "aa",
                        new int[][]{
                                {0, 0, 0},
                                {0, 1, 1},
                                {0, 1, 1}
                        }
                )
        );
        assertEquals(
                "aa",
                getOptimalSolution(
                        "aaa",
                        new int[][]{
                                {0, 0, 0, 0},
                                {0, 1, 1, 1},
                                {0, 1, 1, 2},
                                {0, 1, 1, 2}
                        }
                )
        );
        assertEquals(
                "aab",
                getOptimalSolution(
                        "ababab",
                        new int[][]{
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 2, 2, 2},
                                {0, 1, 1, 1, 2, 2, 2, 2},
                                {0, 1, 1, 1, 2, 3, 3, 3},
                                {0, 1, 1, 1, 2, 3, 3, 3},
                                {0, 1, 1, 1, 2, 3, 3, 3}
                        }
                )
        );
    }

}