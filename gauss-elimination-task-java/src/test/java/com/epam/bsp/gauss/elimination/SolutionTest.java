package com.epam.bsp.gauss.elimination;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class SolutionTest {

	@Test
	public void testFindSleSolutionSample() {
		double[][] a = {
				{1, 2, 3}, 
				{4, 5, 2}, 
				{2, 5, 1}
		};
		double[] b = {14, 20, 15};
		double[] x = {1, 2, 3};
		assertArrayEquals(x, Solution.findSleSolution(a, b), Solution.EPS);

		double[][] a2 = {
				{1, 2, -3}, 
				{4, -5, 2}, 
				{-2, 5, 1}
		};
		double[] b2 = {-4, 0, 11};
		double[] x2 = {1, 2, 3};
		assertArrayEquals(x2, Solution.findSleSolution(a2, b2), Solution.EPS);

		double[][] a3 = {
				{1, -2, -3}, 
				{4, -5, -2}, 
				{-2, -5, 1}
		};
		double[] b3 = {-12, -12, -9};
		double[] x3 = {1, 2, 3};
		assertArrayEquals(x3, Solution.findSleSolution(a3, b3), Solution.EPS);
	}
	
}
