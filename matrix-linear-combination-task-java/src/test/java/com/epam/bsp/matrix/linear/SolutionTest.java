package com.epam.bsp.matrix.linear;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;

public class SolutionTest {
	
	@Test
	public void tests() {
		//2 By 2
		int[][] a = {{1, 0}, {0, 1}};
		int[] b = {2, 3}; 
		int[] c = {2, 3};
		assertArrayEquals(c, Solution.linearCombination(a, b));
		
		//2 By 3
		int[][] a2 = {{1, 1, 1}, {1, 2, 3}};
		int[] b2 = {1, 2, 1}; 
		int[] c2 = {4, 8};
		assertArrayEquals(c2, Solution.linearCombination(a2, b2));
		
		//too long vector
		int[][] a3 = {{1, 1, 1}, {1, 2, 3}};
		int[] b3 = {1, 2, 3, 4}; 
		assertThrowsExactly(IllegalArgumentException.class,
				() -> Solution.linearCombination(a3, b3));
		
	}

}
