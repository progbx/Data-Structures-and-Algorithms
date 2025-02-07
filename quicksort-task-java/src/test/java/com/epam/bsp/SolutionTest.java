package com.epam.bsp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    //Sample tests for hoarePartition and quicksortHoare methods.
    @Test
    public void testQuicksortHoare() {
        //Example 1
        Integer[] array = new Integer[]{1, 5, 3, 2, 4};
        assertEquals(
                new Solution.Pair(2, 1),
                Solution.hoarePartition(array, 0, 4)
        );
        assertArrayEquals(new Integer[]{1, 2, 3, 5, 4}, array);

        //Example 2
        array = new Integer[]{6, 5, 4, 3, 2, 1};
        assertEquals(
                new Solution.Pair(2, 3),
                Solution.hoarePartition(array, 0, 5)
        );
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, array);

        //Example 3
        array = new Integer[]{6, 5, 4, 3, 2, 1};
        assertEquals(3, Solution.quicksortHoare(array));
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, array);

        //Example 4
        array = new Integer[]{5, 3, 2, 7, 5, 9};
        assertEquals(3, Solution.quicksortHoare(array));
        assertArrayEquals(new Integer[]{2, 3, 5, 5, 7, 9}, array);

        //Example 5
        array = new Integer[]{6, 6, 1, 8, 3, 1, 7, 4, 2};
        assertEquals(8, Solution.quicksortHoare(array));
        assertArrayEquals(new Integer[]{1, 1, 2, 3, 4, 6, 6, 7, 8}, array);

        //Example 6
        String[] strings = {"learning", "algorithms", "and", "data", "structures"};
        assertEquals(3, Solution.quicksortHoare(strings));
        assertArrayEquals(new String[]{"algorithms", "and", "data", "learning", "structures"}, strings);

    }

    //Sample tests for lomutoPartition and quicksortLomuto methods.
    @Test
    public void testQuicksortLomuto() {
        //Example 1
        Integer[] array = new Integer[]{5, 3, 2, 1, 7, 4};
        assertEquals(
                new Solution.Pair(3, 4),
                Solution.lomutoPartition(array, 0, 5)
        );
        assertArrayEquals(new Integer[]{3, 2, 1, 4, 7, 5}, array);

        //Example 2
        array = new Integer[]{2, 5, 3, 1, 4};
        assertEquals(
                new Solution.Pair(3, 4),
                Solution.lomutoPartition(array, 0, 4)
        );
        assertArrayEquals(new Integer[]{2, 3, 1, 4, 5}, array);

        //Example 3
        array = new Integer[]{1, 2, 4, 5, 6, 3};
        assertEquals(
                new Solution.Pair(2, 3),
                Solution.lomutoPartition(array, 0, 5)
        );
        assertArrayEquals(new Integer[]{1, 2, 3, 5, 6, 4}, array);

        //Example 4
        array = new Integer[]{1, 2, 3, 4, 5};
        assertEquals(14, Solution.quicksortLomuto(array));
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, array);

        //Example 5
        array = new Integer[]{5, 4, 3, 2, 1};
        assertEquals(8, Solution.quicksortLomuto(array));
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, array);

        //Example 6
        array = new Integer[]{5, 3, 2, 7, 5, 9};
        assertEquals(11, Solution.quicksortLomuto(array));
        assertArrayEquals(new Integer[]{2, 3, 5, 5, 7, 9}, array);

        //Example 7
        String[] strings = {"learning", "algorithms", "and", "data", "structures"};
        assertEquals(10, Solution.quicksortLomuto(strings));
        assertArrayEquals(new String[]{"algorithms", "and", "data", "learning", "structures"}, strings);
    }
}