package com.epam.bsp;

import static com.epam.bsp.Solution.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void testIsValidTree() {
        //Sample tests for isValidTree method.
        //Example 1
        assertTrue(isValidTree(5,
                List.of(
                        new Pair(0, 1),
                        new Pair(0, 2),
                        new Pair(0, 3),
                        new Pair(3, 4)
                )
        ));
        //Example 2
        assertFalse(isValidTree(5,
                List.of(
                        new Pair(0, 1),
                        new Pair(0, 2),
                        new Pair(0, 3),
                        new Pair(2, 3)
                )
        ));
        //Example 3
        assertFalse(isValidTree(6,
                List.of(
                        new Pair(0, 1),
                        new Pair(0, 2),
                        new Pair(0, 3),
                        new Pair(2, 3),
                        new Pair(0, 3)
                )
        ));
    }

}