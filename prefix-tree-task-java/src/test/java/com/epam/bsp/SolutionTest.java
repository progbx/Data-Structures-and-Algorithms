package com.epam.bsp;

import com.epam.bsp.tree.AugmentedPrefixTree;
import com.epam.bsp.tree.PrefixTree;
import org.junit.jupiter.api.Test;

import static com.epam.bsp.Solution.*;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    @Test
    public void testPrefixTree() {
        //sample tests
        PrefixTree pt = new PrefixTree();
        pt.insert("aba");
        pt.insert("aba");
        pt.insert("abab");
        pt.insert("caba");

        assertFalse(pt.search("a"));
        assertFalse(pt.search("ab"));
        assertTrue(pt.search("aba"));
        assertTrue(pt.search("abab"));
        assertTrue(pt.search("caba"));
        assertFalse(pt.search("cabacaba"));

        assertTrue(pt.startsWith("a"));
        assertTrue(pt.startsWith("ab"));
        assertTrue(pt.startsWith("aba"));
        assertTrue(pt.startsWith("abab"));
        assertTrue(pt.startsWith("caba"));
        assertFalse(pt.startsWith("cabacaba"));
    }

    @Test
    public void testAugmentedPrefixTree() {
        //sample tests
        AugmentedPrefixTree apt = new AugmentedPrefixTree();
        apt.insert("aba");
        apt.insert("aba");
        apt.insert("aba");
        apt.insert("abab");
        apt.insert("ababad");
        apt.insert("caba");


        // The basic operations should still work correctly.
        assertFalse(apt.search("a"));
        assertFalse(apt.search("ab"));
        assertTrue(apt.search("aba"));
        assertTrue(apt.search("abab"));
        assertTrue(apt.search("caba"));
        assertFalse(apt.search("cabacaba"));

        assertTrue(apt.startsWith("a"));
        assertTrue(apt.startsWith("ab"));
        assertTrue(apt.startsWith("aba"));
        assertTrue(apt.startsWith("abab"));
        assertTrue(apt.startsWith("caba"));
        assertFalse(apt.startsWith("cabacaba"));

        // The new operations.
        assertEquals(3, apt.countWordsEqualTo("aba"));
        assertEquals(0, apt.countWordsEqualTo("ab"));
        assertEquals(1, apt.countWordsEqualTo("abab"));
        assertEquals(0, apt.countWordsEqualTo("cabacaba"));

        assertEquals(6, apt.countWordsStartingWith(""));
        assertEquals(5, apt.countWordsStartingWith("a"));
        assertEquals(5, apt.countWordsStartingWith("ab"));
        assertEquals(5, apt.countWordsStartingWith("aba"));
        assertEquals(2, apt.countWordsStartingWith("abab"));
        assertEquals(1, apt.countWordsStartingWith("ababa"));
        assertEquals(1, apt.countWordsStartingWith("c"));
    }

    @Test
    public void testGetNumberOfMatches() {
        //sample tests
        assertEquals(13,
                getNumberOfMatches(
                        "abracadabra",
                        new String[]{"a", "a", "abra", "ca"}
                )
        );
        assertEquals(9,
                getNumberOfMatches(
                        "hello world",
                        new String[]{"hell", "l", "l", "o"}
                )
        );
        assertEquals(6,
                getNumberOfMatches(
                        "Tomatoes make great weapons when water balloons aren’t available.",
                        new String[]{"at", "ma", "great weapons"}
                )
        );
    }

}