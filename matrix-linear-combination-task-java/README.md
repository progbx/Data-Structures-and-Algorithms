# Linear combination

## Purpose

The following coding exercise is designed to test your knowledge of the following concepts:
* Linear combination of vectors

## Overview

The coding exercise covers the following practical problem:
* Computing a linear combination of columns for a given matrix

## Coding exercises

### Exercise 1: Compute a linear combination

Your task is to implement the static method that returns the linear combination of columns for a given matrix:

```java
	/**
	* @param matrix a given numeric matrix - 2 dimensional array with the same number of elements in each row.
	* @param weights an array of weights that correspond to the columns of the matrix.
	* @return the linear combination of the columns for the given matrix using an array of corresponding weights. 
	* @throws IllegalArgumentException if the given matrix and weights are not compatible (dimensionalities don't match).
	*/
	public static int[] linearCombination(int[][] matrix, int[] weights)
```

**Example 1:**

```math
matrix=\begin{pmatrix}
   3 & 4 \\
   2 & 1
\end{pmatrix}

weights=\begin{pmatrix}
   2 \\
   3 
\end{pmatrix}
```


Expected output: 

```math
2\times\begin{pmatrix}
   3 \\
   2 
\end{pmatrix}
+3\times
\begin{pmatrix}
   4 \\
   1 
\end{pmatrix}=
\begin{pmatrix}
   6 + 12\\
   4 + 3
\end{pmatrix}=
\begin{pmatrix}
   18\\
   7
\end{pmatrix}
```

**Example 2:**

```math
matrix = \begin{pmatrix}
   1 & 0 \\
   0 & 1
\end{pmatrix}

weights = \begin{pmatrix}
   2 \\
   3 
\end{pmatrix}
```

Expected output: 

```math
\begin{pmatrix}
   2\\
   3
\end{pmatrix}
```

**Example 3:**

```math
matrix = \begin{pmatrix}
   1 & 0 \\
   0 & 1
\end{pmatrix}

weights = \begin{pmatrix}
   2
\end{pmatrix}
```

Expected output: the `IllegalArgumentException` exception is thrown because the matrix and the weights are not compatible.
