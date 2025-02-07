package com.epam.bsp;

import org.junit.jupiter.api.Test;

import static com.epam.bsp.Solution.*;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    public void testPartialSelectionSort() {
        //sample tests
        assertArrayEquals(new Integer[]{2, 8, 6, 4, 5},
                partialSelectionSort(new Integer[]{4, 8, 6, 2, 5}, 1)
        );
        assertArrayEquals(new Integer[]{2, 4, 6, 8, 5},
                partialSelectionSort(new Integer[]{4, 8, 6, 2, 5}, 2)
        );
        assertArrayEquals(new Integer[]{2, 4, 5, 8, 6},
                partialSelectionSort(new Integer[]{4, 8, 6, 2, 5}, 3)
        );
        assertArrayEquals(new Integer[]{2, 4, 5, 6, 8},
                partialSelectionSort(new Integer[]{4, 8, 6, 2, 5}, 4)
        );

        assertArrayEquals(new String[]{"a", "aa", "ab", "b", "ba", "bb"},
                partialSelectionSort(new String[]{"aa", "b", "ab", "a", "bb", "ba"}, 5)
        );

    }

    @Test
    public void testPartialInsertionSort() {
        //sample tests
        assertArrayEquals(new Integer[]{4, 8, 6, 2, 5},
                partialInsertionSort(new Integer[]{4, 8, 6, 2, 5}, 1)
        );
        assertArrayEquals(new Integer[]{4, 6, 8, 2, 5},
                partialInsertionSort(new Integer[]{4, 8, 6, 2, 5}, 2)
        );
        assertArrayEquals(new Integer[]{2, 4, 6, 8, 5},
                partialInsertionSort(new Integer[]{4, 8, 6, 2, 5}, 3)
        );
        assertArrayEquals(new Integer[]{2, 4, 5, 6, 8},
                partialInsertionSort(new Integer[]{4, 8, 6, 2, 5}, 4)
        );

        assertArrayEquals(new String[]{"a", "aa", "ab", "b", "ba", "bb"},
                partialInsertionSort(new String[]{"aa", "b", "ab", "a", "bb", "ba"}, 5)
        );

    }

    @Test
    public void testPartialBubbleSort() {
        //sample tests
        assertArrayEquals(new Integer[]{4, 6, 8, 2, 5},
                partialBubbleSort(new Integer[]{4, 8, 6, 2, 5}, 1)
        );
        assertArrayEquals(new Integer[]{4, 6, 2, 8, 5},
                partialBubbleSort(new Integer[]{4, 8, 6, 2, 5}, 2)
        );
        assertArrayEquals(new Integer[]{4, 6, 2, 5, 8},
                partialBubbleSort(new Integer[]{4, 8, 6, 2, 5}, 3)
        );
        assertArrayEquals(new Integer[]{4, 2, 6, 5, 8},
                partialBubbleSort(new Integer[]{4, 8, 6, 2, 5}, 4)
        );
        assertArrayEquals(new Integer[]{4, 2, 5, 6, 8},
                partialBubbleSort(new Integer[]{4, 8, 6, 2, 5}, 5)
        );
        assertArrayEquals(new Integer[]{2, 4, 5, 6, 8},
                partialBubbleSort(new Integer[]{4, 8, 6, 2, 5}, 6)
        );

        assertArrayEquals(new String[]{"a", "aa", "ab", "b", "ba", "bb"},
                partialBubbleSort(new String[]{"aa", "b", "ab", "a", "bb", "ba"}, 10)
        );

    }

}