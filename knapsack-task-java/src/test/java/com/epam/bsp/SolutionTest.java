package com.epam.bsp;

import org.junit.jupiter.api.Test;

import static com.epam.bsp.Solution.*;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    public void testGetOptimalSubstructure() {
        //sample tests
        assertArrayEquals(
                new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 1, 1},
                        {0, 0, 2, 2}
                },
                getOptimalSubstructure(
                        new int[]{2, 2},
                        new int[]{1, 2},
                        3
                )
        );
        assertArrayEquals(
                new int[][]{
                        {0, 0, 0},
                        {0, 1, 1},
                        {0, 2, 3},
                        {0, 3, 5}
                },
                getOptimalSubstructure(
                        new int[]{1, 1, 1},
                        new int[]{1, 2, 3},
                        2
                )
        );
        assertArrayEquals(
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1},
                        {0, 0, 2, 2, 2, 3, 3},
                        {0, 1, 2, 3, 3, 3, 4},
                        {0, 1, 2, 3, 3, 3, 4}
                },
                getOptimalSubstructure(
                        new int[]{3, 2, 1, 4},
                        new int[]{1, 2, 1, 2},
                        6
                )
        );
    }


    @Test
    public void testGetOptimalSolution() {
        //sample tests
        assertArrayEquals(
                new int[]{0, 1},
                getOptimalSolution(
                        new int[]{2, 2},
                        new int[][]{
                                {0, 0, 0, 0},
                                {0, 0, 1, 1},
                                {0, 0, 2, 2}
                        }
                )
        );
        assertArrayEquals(
                new int[]{0, 1, 1},
                getOptimalSolution(
                        new int[]{1, 1, 1},
                        new int[][]{
                                {0, 0, 0},
                                {0, 1, 1},
                                {0, 2, 3},
                                {0, 3, 5}
                        }
                )
        );
        
        // Two solutions are eligible
        int[] solution = getOptimalSolution(
                new int[]{3, 2, 1, 4},
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1},
                        {0, 0, 2, 2, 2, 3, 3},
                        {0, 1, 2, 3, 3, 3, 4},
                        {0, 1, 2, 3, 3, 3, 4}
                }
        );
        assertThat(solution,
                anyOf(
                        is(new int[]{1, 1, 1, 0}),
                        is(new int[]{0, 1, 0, 1})
                )
        );
    }

}