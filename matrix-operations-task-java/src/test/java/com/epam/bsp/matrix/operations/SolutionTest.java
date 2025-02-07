package com.epam.bsp.matrix.operations;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;

public class SolutionTest {

	@Test
	public void testTransposeSample() {
		//2 By 2
		int[][] a = {{1, 2}, {3, 4}};
		int[][] aTransposed = {{1, 3}, {2, 4}}; 
		assertArrayEquals(aTransposed, Solution.transpose(a));
		
		//2 By 3
		int[][] a2 = {{1, 2, 3}, {4, 5, 6}};
		int[][] a2Transposed = {{1, 4}, {2, 5}, {3, 6}}; 
		assertArrayEquals(a2Transposed, Solution.transpose(a2));
	}

	@Test
	public void testAddMatricesSample() {
		//2 By 2
		int[][] a = {{1, 2}, {3, 4}};
		int[][] b = {{1, 1}, {1, 2}};
		int[][] sum = {{2, 3}, {4, 6}}; 
		assertArrayEquals(sum, Solution.addMatrices(a, b));
		
		//2 By 3
		int[][] a2 = {{1, 2, 3}, {3, 4, 1}};
		int[][] b2 = {{1, 1, 0}, {1, 1, -10}};
		int[][] sum2 = {{2, 3, 3}, {4, 5, -9}}; 
		assertArrayEquals(sum2, Solution.addMatrices(a2, b2));
		
		//number of rows does not match
		int[][] a3 = {{1, 2}};
		int[][] b3 = {{1, 2}, {1, 4}}; 
		assertThrowsExactly(IllegalArgumentException.class,
				() -> Solution.addMatrices(a3, b3));

		//number of columns does not match
		int[][] a4 = {{1, 2, 3}};
		int[][] b4 = {{1, 2}}; 
		assertThrowsExactly(IllegalArgumentException.class,
				() -> Solution.addMatrices(a4, b4));
	}
	
	@Test
	public void testMultiplyMatricesSample() {
		//2 By 2
		int[][] a = {{1, 2}, {3, 4}};
		int[][] b = {{1, 1}, {1, 2}};
		int[][] product = {{3, 5}, {7, 11}}; 
		assertArrayEquals(product, Solution.multiplyMatrices(a, b));
		
		//2 By 3 * 3 By 2
		int[][] a2 = {{1, 2, 3}, {3, 4, 1}};
		int[][] b2 = {{1, 2}, {2, 1}, {1, 1}};
		int[][] product2 = {{8, 7}, {12, 11}}; 
		assertArrayEquals(product2, Solution.multiplyMatrices(a2, b2));
		
		//matrices are not compatible
		int[][] a3 = {{1, 2}};
		int[][] b3 = {{1, 2}}; 
		assertThrowsExactly(IllegalArgumentException.class,
				() -> Solution.multiplyMatrices(a3, b3));

		//matrices are not compatible
		int[][] a4 = {{1, 2, 3}};
		int[][] b4 = {{1, 2, 3, 4}, {1, 2, 3, 4}}; 
		assertThrowsExactly(IllegalArgumentException.class,
				() -> Solution.multiplyMatrices(a4, b4));
	}
	

}
