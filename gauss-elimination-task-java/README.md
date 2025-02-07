# The Gauss elimination method

## Purpose

The coding exercise is designed to test your knowledge of the following concepts:

* Systems of linear equations
* The Gauss elimination method with partial pivoting

## Overview

The coding exercise covers the following practical problems:
* Solving a system of linear equations using the Gauss elimination method

## Coding exercises

### Exercise 1: Solve a given system of linear equations using the Gauss elimination method

Your task is to implement the following function to solve systems of linear equations using the Gauss elimination method with partial pivoting:

```java
	/**
	* Returns the solution of a given system of linear equations (Ax = b).
	* 
	* NOTE: It is guaranteed that the given matrix A is square.
	* NOTE: It is guaranteed that only one solution exists.
	* NOTE: The Gauss elimination should be extended with partial pivoting, 
	* as this helps to reduce rounding errors; you are less likely 
	* to add/subtract with a very small number (or a very large number).
	* NOTE: To avoid issues with precision, use EPS=1e-8 to detect zeros:
	* |x| < EPS => we assume that x is zero.
	* 
	* @param a a matrix with coefficients (a11 * x1 + ... + a1k * xk) of a given system (the left part).
	* @param b a list with values of a given system's equations (the right part, b1 = a11 * x1 + ... + a1k * xk).
	* @return the solution of a given system of linear equations.
	*/
	public static double[] findSleSolution(double[][] a, double[] b)
```

**Example 1:**

```math
A=\begin{pmatrix}
1 & 2 & 3 \\
4 & 5 & 2 \\
2 & 5 & 1
\end{pmatrix}

b=\begin{pmatrix}
14 \\
20 \\
15
\end{pmatrix}
```

Expected result:
```math
\begin{pmatrix}
1 \\
2 \\
3
\end{pmatrix}
```

**Example 2:**

```math
A=\begin{pmatrix}
1 & 2 & -3 \\
4 & -5 & 2 \\
-2 & 5 & 1
\end{pmatrix}

b=\begin{pmatrix}
-4 \\
0 \\
11
\end{pmatrix}
```

Expected result:
```math
\begin{pmatrix}
1 \\
2 \\
3
\end{pmatrix}
```

**Example 3:**

```math
A=\begin{pmatrix}
1 & -2 & -3 \\
4 & -5 & -2 \\
-2 & -5 & 1
\end{pmatrix}

b=\begin{pmatrix}
-12 \\
-12 \\
-9
\end{pmatrix}
```

Expected result:
```math
\begin{pmatrix}
1 \\
2 \\
3
\end{pmatrix}
```
