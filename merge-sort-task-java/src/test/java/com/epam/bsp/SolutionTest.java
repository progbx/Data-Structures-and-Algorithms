package com.epam.bsp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testMergeSortAlgorithm() {
        //Sample test for `mergeSortedSubarrays`.
        int[] a = {1, 3, 5, 2, 4, 6};
        int[] expected = {1, 2, 3, 4, 5, 6};
        Solution.mergeSortedSubarrays(a, 0, 2, 5);
        assertArrayEquals(expected, a);

        //Example 1
        a = new int[]{3, 2, 1};
        expected = new int[]{1, 2, 3};
        assertEquals(27, Solution.mergeSortAlgorithm(a));
        assertArrayEquals(expected, a);

        //Example 2
        a = new int[]{5, 3, 1, 5, 2};
        expected = new int[]{1, 2, 3, 5, 5};
        assertEquals(83, Solution.mergeSortAlgorithm(a));
        assertArrayEquals(expected, a);

        //Example 3
        a = new int[]{5, 3, 6, 2, 1, 7, 3, 2};
        expected = new int[]{1, 2, 2, 3, 3, 5, 6, 7};
        assertEquals(153, Solution.mergeSortAlgorithm(a));
        assertArrayEquals(expected, a);

        //Example 4
        a = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(315, Solution.mergeSortAlgorithm(a));
        assertArrayEquals(expected, a);
    }
}