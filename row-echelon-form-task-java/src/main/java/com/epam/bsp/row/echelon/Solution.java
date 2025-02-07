package com.epam.bsp.row.echelon;

public class Solution {

	public final static double EPS = 1e-8;

	public static boolean isRowEchelonForm(double[][] matrix) {
		int leadingCoefficientPosition = -1;
		for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
			double[] row = matrix[rowIndex];
			int firstNonZeroPosition = -1;
			for (int i = 0; i < row.length; i++) {
				if (Math.abs(row[i]) > EPS) {
					firstNonZeroPosition = i;
					break;
				}
			}
			if (firstNonZeroPosition == -1) {
				for (int i = rowIndex + 1; i < matrix.length; i++) {
					for (double value : matrix[i]) {
						if (Math.abs(value) > EPS) {
							return false;
						}
					}
				}
				break;
			}
			if (firstNonZeroPosition <= leadingCoefficientPosition) {
				return false;
			}
			leadingCoefficientPosition = firstNonZeroPosition;
		}
		return true;
	}


	public static double[][] convertIntoRref(double[][] matrix) {
		int rowCount = matrix.length;
		int columnCount = matrix[0].length;
		int lead = 0;
		for (int r = 0; r < rowCount; r++) {
			if (lead >= columnCount) {
				break;
			}
			int i = r;
			while (Math.abs(matrix[i][lead]) < EPS) {
				i++;
				if (i == rowCount) {
					i = r;
					lead++;
					if (lead == columnCount) {
						double[] temp = matrix[r];
						System.arraycopy(matrix, r + 1, matrix, r, rowCount - r - 1);
						matrix[rowCount - 1] = temp;
						return matrix;
					}
				}
			}			double[] temp = matrix[i];
			matrix[i] = matrix[r];
			matrix[r] = temp;
			double div = matrix[r][lead];
			for (int j = 0; j < columnCount; j++) {
				matrix[r][j] /= div;
			}
			for (int j = 0; j < rowCount; j++) {
				if (j != r) {
					double sub = matrix[j][lead];
					for (int k = 0; k < columnCount; k++) {
						matrix[j][k] -= sub * matrix[r][k];
					}
				}
			}
			lead++;
		}
		return matrix;
	}

	public static int getRankOfSquareMatrix(double[][] matrix) {
		matrix = convertIntoRref(matrix);
		int rank = 0;
		for (double[] row : matrix) {
			boolean isZeroRow = true;
			for (double value : row) {
				if (Math.abs(value) > EPS) {
					isZeroRow = false;
					break;
				}
			}
			if (!isZeroRow) {
				rank++;
			}
		}
		return rank;
	}
}
