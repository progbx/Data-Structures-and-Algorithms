package com.epam.bsp;

import com.epam.bsp.hash.RollingHash;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.epam.bsp.Solution.*;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    @Test
    public void testRollingHash() {
        //sample tests
        RollingHash rh = new RollingHash("hello hello", 3, 31);

        assertEquals(10, rh.getHash(0, 1));
        assertEquals(14, rh.getHash(0, 2));
        assertEquals(12, rh.getHash(2, 4));
        assertEquals(15, rh.getHash(2, 2));
        assertEquals(rh.getHash(0, 4), rh.getHash(6, 10));
    }

    @Test
    public void testFindOccurrencesViaRabinKarp() {
        //sample tests
        assertEquals(
                List.of(4, 7),
                findOccurrencesViaRabinKarp("hello world", "o", 3, 31, true)
        );
        assertEquals(
                List.of(1, 4, 6, 7),
                findOccurrencesViaRabinKarp("hello world", "o", 3, 2, false)
        );
    }

}