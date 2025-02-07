package com.epam.bsp;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    public void testBucketSort() {
        //Example 1
        assertEquals(
                List.of(
                        new Solution.Pair(0, 0),    //"abc"
                        new Solution.Pair(1, 0),    //"cab"
                        new Solution.Pair(3, 0),    //"qaf"
                        new Solution.Pair(2, 1),    //"cabg"
                        new Solution.Pair(5, 2),    //"qwr"
                        new Solution.Pair(4, 1)     //"qegtw"
                ),
                Solution.bucketSort(
                        List.of("abc", "cab", "qaf", "cabg", "qwr", "qegtw"), 1
                )
        );

        //Example 2
        assertEquals(
                List.of(
                        new Solution.Pair(1, 1),    //"aaaba"
                        new Solution.Pair(0, 0),    //"aaaa"
                        new Solution.Pair(3, 1),    //"basfa"
                        new Solution.Pair(2, 0),    //"badaa"
                        new Solution.Pair(4, 0)     //"macda"
                ),
                Solution.bucketSort(
                        List.of("aaaba", "aaaa", "basfa", "badaa", "macda"), 2
                )
        );

        //Example 3
        assertEquals(
                List.of(
                        new Solution.Pair(0, 0),    //"aa"
                        new Solution.Pair(3, 0),    //"bb"
                        new Solution.Pair(1, 1),    //"aa"
                        new Solution.Pair(4, 1),    //"bb"
                        new Solution.Pair(2, 2)     //"aa"
                ),
                Solution.bucketSort(
                        List.of("aa", "bb", "aa", "bb", "aa"), 1
                )
        );
    }

    @Test
    public void testRadixSort() {
        //Example 1
        assertEquals(
                List.of(1, 4, 3, 2, 0, 5),
                Solution.radixSort(List.of("542", "124", "423", "142", "631", "624"), 1)
        );

        //Example 2
        assertEquals(
                List.of(4, 1, 0, 5, 3, 2),
                Solution.radixSort(List.of("542", "124", "423", "142", "631", "624"), 2)
        );

        //Example 3
        assertEquals(
                List.of(3, 0, 2, 1, 5, 4),
                Solution.radixSort(List.of("542", "124", "423", "142", "631", "624"), 3)
        );

        //Example 4
        assertEquals(
                List.of(2, 3, 4, 0, 1),
                Solution.radixSort(List.of("22", "32", "33", "11", "11"), 1)
        );
    }
}