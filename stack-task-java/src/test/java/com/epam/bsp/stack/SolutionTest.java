package com.epam.bsp.stack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    public void testEvaluateRpnTokensSample() {
        String[] rpnTokens = {"3", "2", "+", "10", "*"};
        assertEquals(50, Solution.evaluateRpnTokens(rpnTokens));

        String[] rpnTokens2 = {"10", "4", "-", "2", "*", "5", "/"};
        assertEquals(2, Solution.evaluateRpnTokens(rpnTokens2));
    }

    @Test
    public void testIsValidParenthesesSample() {
        assertTrue(Solution.isValidParentheses("()"));
        assertTrue(Solution.isValidParentheses("()[]{}"));
        assertFalse(Solution.isValidParentheses("([})"));
        assertFalse(Solution.isValidParentheses("([)]"));
    }

}
