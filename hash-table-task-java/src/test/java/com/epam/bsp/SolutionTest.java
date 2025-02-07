package com.epam.bsp;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SolutionTest {

    @Test
    public void testFindTargetSum() {
        assertEquals(new Solution.Pair(0, 2), Solution.findTargetSum(List.of(1, 2, 3, 4, 5), 4));
        assertEquals(new Solution.Pair(2, 4), Solution.findTargetSum(List.of(1, 2, 3, 4, 5), 8));
        assertNull(Solution.findTargetSum(List.of(1, 2, 7), 5));
    }

    @Test
    public void testFindRepeatedDnaSequences() {
        assertEquals(Set.of("AAAATTTT"), Solution.findRepeatedDnaSequences("AAAATTTTAAAATTTT"));
        assertEquals(Set.of("ATATATAT", "TATATATA"), Solution.findRepeatedDnaSequences("ATATATATATA"));
    }

}