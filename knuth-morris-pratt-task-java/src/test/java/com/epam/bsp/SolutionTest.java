package com.epam.bsp;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.epam.bsp.Solution.*;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    @Test
    public void testBuildLPSArray() {
        //sample tests
        assertArrayEquals(
                new int[]{0, 0, 0, 1, 0, 1, 0, 1, 2, 3, 4},
                buildLPSArray("abracadabra")
        );
        assertArrayEquals(
                new int[]{0, 0, 1, 0, 1, 2, 3},
                buildLPSArray("abacaba")
        );
        assertArrayEquals(
                new int[]{0, 0, 1, 2, 0, 1, 1, 2},
                buildLPSArray("ababbaab")
        );
    }

    @Test
    public void testFindOccurrencesViaKMP() {
        //sample tests
        assertEquals(
                List.of(4, 7),
                findOccurrencesViaKMP("hello world", "o")
        );
        assertEquals(
                List.of(0, 4),
                findOccurrencesViaKMP("abacaba", "aba")
        );
        assertEquals(
                List.of(0, 2, 6),
                findOccurrencesViaKMP("ababbaab", "ab")
        );
        assertEquals(
                List.of(),
                findOccurrencesViaKMP("ababbaab", "caba")
        );
    }

    @Test
    public void testIsTandemRepeat() {
        //sample tests
        assertFalse(isTandemRepeat("abacaba"));
        assertTrue(isTandemRepeat("abaabaabaaba"));
        assertTrue(isTandemRepeat("ababab"));
        assertFalse(isTandemRepeat("a"));
    }
}