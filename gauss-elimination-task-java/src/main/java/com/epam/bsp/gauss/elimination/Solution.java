package com.epam.bsp.gauss.elimination;
public class Solution {
	public final static double EPS = 1e-8;
	public static double[] findSleSolution(double[][] a, double[] b) {
		int n = a.length;
		double[] x = new double[n];
		for (int i = 0; i < n; i++) {
			int max = i;
			for (int j = i + 1; j < n; j++) {
				if (Math.abs(a[j][i]) > Math.abs(a[max][i])) {
					max = j;
				}
			}
			double[] temp = a[i]; a[i] = a[max]; a[max] = temp;
			double t = b[i]; b[i] = b[max]; b[max] = t;
			if (Math.abs(a[i][i]) <= EPS) {
				throw new RuntimeException("Matrix is singular or nearly singular");
			}
			for (int j = i + 1; j < n; j++) {
				double alpha = a[j][i] / a[i][i];
				b[j] -= alpha * b[i];
				for (int k = i; k < n; k++) {
					a[j][k] -= alpha * a[i][k];
				}
			}
		}
		for (int i = n - 1; i >= 0; i--) {
			double sum = 0.0;
			for (int j = i + 1; j < n; j++) {
				sum += a[i][j] * x[j];
			}
			x[i] = (b[i] - sum) / a[i][i];
		}
		return x;
	}
}
