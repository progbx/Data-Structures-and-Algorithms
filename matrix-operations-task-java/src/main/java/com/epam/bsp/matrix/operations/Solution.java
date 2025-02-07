package com.epam.bsp.matrix.operations;

public class Solution {

	public static int[][] transpose(int[][] matrix) {
		int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				transposedMatrix[j][i] = matrix[i][j];
			}
		}
		return transposedMatrix;
	}

	public static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
		if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
			throw new IllegalArgumentException("The matrices are not compatible (dimensions differ in size).");
		}

		int[][] sumMatrix = new int[matrixA.length][matrixA[0].length];
		for (int i = 0; i < matrixA.length; i++) {
			for (int j = 0; j < matrixA[0].length; j++) {
				sumMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
			}
		}
		return sumMatrix;
	}

	public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
		if (matrixA[0].length != matrixB.length) {
			throw new IllegalArgumentException("The matrices are not compatible.");
		}

		int[][] productMatrix = new int[matrixA.length][matrixB[0].length];
		for (int i = 0; i < matrixA.length; i++) {
			for (int j = 0; j < matrixB[0].length; j++) {
				for (int k = 0; k < matrixA[0].length; k++) {
					productMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
				}
			}
		}
		return productMatrix;
	}
}
