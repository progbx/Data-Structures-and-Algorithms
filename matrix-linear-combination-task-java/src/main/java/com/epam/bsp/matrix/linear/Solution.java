package com.epam.bsp.matrix.linear;

public class Solution {

	public static int[] linearCombination(int[][] matrix, int[] weights) {
		if (matrix == null || weights == null || matrix[0].length != weights.length) {
			throw new IllegalArgumentException("The given matrix and weights are not compatible (dimensionalities don't match).");
		}

		int[] result = new int[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				result[i] += matrix[i][j] * weights[j];
			}
		}

		return result;
	}
}
