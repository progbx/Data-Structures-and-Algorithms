package com.epam.bsp.row.echelon;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.DoubleStream;

import org.junit.jupiter.api.Test;

public class SolutionTest {
	
	@Test
	public void testIsRowEchelonFormSample() {
		double[][] matrix = {
				{1, 2}, 
				{3, 4}
		};
		assertFalse(Solution.isRowEchelonForm(matrix));
		
		double[][] matrix2 = {
				{1, 1, 2, 1}, 
				{0, 1, 3, 12}, 
				{0, 0, 1, 8}, 
				{0, 0, 0, 1}
		};
		assertTrue(Solution.isRowEchelonForm(matrix2));
		
		double[][] matrix3 = {
				{1, 1, 2, 1, 1}, 
				{0, 2, 3, 12, 3}, 
				{0, 0, 0, 8, 4}, 
				{0, 0, 0, 0, 2}
		};
		assertTrue(Solution.isRowEchelonForm(matrix3));
	}
	
	@Test
	public void testConvertIntoRrefSample() {
		double[][] initial = {
				{1, 5, 1}, 
				{2, 11, 5}
		};
		double[][] expected = {
				{1, 0, -14}, 
				{0, 1, 3}
		};
		assertArrayEquals(
				convertMatrixToArray(expected), 
				convertMatrixToArray(Solution.convertIntoRref(initial)), 
				Solution.EPS
		);

		double[][] initial2 = {
				{1, 5, 6}, 
				{2, 4, 7},
				{3, 5, 9}
		};
		double[][] expected2 = {
				{1, 0, 0}, 
				{0, 1, 0},
				{0, 0, 1}
		};
		assertArrayEquals(
				convertMatrixToArray(expected2), 
				convertMatrixToArray(Solution.convertIntoRref(initial2)), 
				Solution.EPS
		);

		double[][] initial3 = {
				{1, 5, 6}, 
				{5, 0, 4},
				{1, 2, 5},
				{4, 2, 4}
		};
		double[][] expected3 = {
				{1, 0, 0}, 
				{0, 1, 0},
				{0, 0, 1},
				{0, 0, 0}
		};
		assertArrayEquals(
				convertMatrixToArray(expected3), 
				convertMatrixToArray(Solution.convertIntoRref(initial3)), 
				Solution.EPS
		);
	}
	
	private static double[] convertMatrixToArray(double[][] matrix) {
		return Arrays.stream(matrix)
				.flatMapToDouble(DoubleStream::of)
				.toArray();
	}
	
	@Test
	public void testGetRankOfSquareMatrixSample() {
		double[][] initial = {
				{1, 5, 6}, 
				{2, 4, 7},
				{3, 5, 9}
		};
		assertEquals(3, Solution.getRankOfSquareMatrix(initial));
		
		double[][] initial2 = {
				{1, 2, 4}, 
				{2, 4, 3},
				{2, 4, 2}
		};
		assertEquals(2, Solution.getRankOfSquareMatrix(initial2));
		
		double[][] initial3 = {
				{1, 2, 4, 0}, 
				{0, 0, 0, 0},
				{2, 4, 2, 0},
				{5, 2, 1, 0}
		};
		assertEquals(3, Solution.getRankOfSquareMatrix(initial3));
	}

}
