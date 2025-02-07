package com.epam.bsp;

import com.epam.bsp.engine.FuzzySearchEngine;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.epam.bsp.Solution.*;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    @Test
    public void testFindOccurrences() {
        //sample tests
        assertEquals(
                List.of(0, 2, 4),
                findOccurrences("abababa", "aba")
        );
        assertEquals(
                List.of(),
                findOccurrences("question", "answer")
        );
        assertEquals(
                List.of(13, 19, 29),
                findOccurrences(
                        "Who’s there? Figs. Figs who? Figs the doorbell, it’s not working!",
                        "Figs"
                )
        );
    }

    @Test
    public void testFindLevenshteinDistance() {
        //sample tests
        assertEquals(8, findLevenshteinDistance("property", "attribute"));
        assertEquals(2, findLevenshteinDistance("maximization", "minimization"));
        assertEquals(5, findLevenshteinDistance("confusion", "induction"));
    }

    @Test
    public void testFuzzySearchEngine() {
        //sample tests
        FuzzySearchEngine fse = new FuzzySearchEngine(List.of(
                "refund",
                "spy",
                "retailer",
                "concede",
                "dozen"
        ));
        assertEquals(
                fse.findBestMatches("recruit", 3),
                List.of("refund", "retailer", "concede")
        );
        assertEquals(
                fse.findBestMatches("button", 3),
                List.of("dozen", "refund", "spy")
        );
    }
}