# Basic matrix operations

## Purpose

The coding exercises are designed to test your knowledge of the following concepts:

* Matrix transposition
* Matrix addition
* Matrix multiplication

## Overview

The coding exercises cover the following practical problems:
* Transposition of a given matrix
* Calculating the result of given matrices addition
* Calculating the result of given matrices multiplication

## Coding exercises


### Exercise 1: Transpose a given matrix

Your task is to implement the following static method for matrix transposition:

```java
	/**
	* @param matrix a given numeric matrix, i.e. 2 dimensional array 
	* with the same number of elements in each row.
	* matrix.length > 0, matrix[0].length > 0
	* 
	* @return the transposed matrix. 
	*/
	public static int[][] transpose(int[][] matrix)
```

**Example 1:**
```math
matrix = \left(\begin{array}{} 
1 & 2\\
3 & 4
\end{array}\right)

\\
transposed\_matrix = \left(\begin{array}{} 
1 & 3\\
2 & 4
\end{array}\right)
```

**Example 2:**
```math
matrix = \left(\begin{array}{} 
1 & 2 & 3\\
4 & 5 & 6
\end{array}\right)

\\
transposed\_matrix = \left(\begin{array}{} 
1 & 4\\
2 & 5\\
3 & 6
\end{array}\right)
```

### Exercise 2: Add two given matrices

Your task is to implement the following function for adding two matrices:

```java
	/**
	* @param matrixA the first numeric matrix.
	* @param matrixB the second numeric matrix.
	* each matrix is a 2 dimensional array with the same number of elements in each row.
	* matrixA.length > 0, matrixA[0].length > 0, matrixB.length > 0, matrixB[0].length > 0
	* 
	* @throws IllegalArgumentException if the matrices are not compatible (dimensions differ in size).
	* @return The sum of two given matrices.
	*/
	public static int[][] addMatrices(int[][] matrixA, int[][] matrixB)
```
 
**Example 1:**
```math
\left(\begin{array}{} 
1 & 2\\
3 & 4
\end{array}\right)+\left(\begin{array}{} 
1 & 1\\
1 & 2
\end{array}\right)=\left(\begin{array}{} 
2 & 3\\
4 & 6
\end{array}\right)
```

**Example 2:**
```math
\left(\begin{array}{} 
1 & 2 & 3\\
3 & 4 & 1
\end{array}\right)+\left(\begin{array}{} 
1 & 1 & 0\\
1 & 1 & -10
\end{array}\right)=\left(\begin{array}{} 
2 & 3 & 3\\
4 & 5 & -9
\end{array}\right)
```

### Exercise 3: Multiply two given matrices

Your task is to implement the following function for multiplying two matrices:

```java
	/**
	* @param matrixA the first numeric matrix.
	* @param matrixB the second numeric matrix.
	* each matrix is a 2 dimensional array with the same number of elements in each row.
	* matrixA.length > 0, matrixA[0].length > 0, matrixB.length > 0, matrixB[0].length > 0
	* @throws IllegalArgumentException if the matrices are not compatible.
	* @return The product of two given matrices.
	*/
	public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB)
```
 
**Example 1:**
```math
\left(\begin{array}{} 
1 & 2\\
3 & 4
\end{array}\right)*\left(\begin{array}{} 
1 & 1\\
1 & 2
\end{array}\right)=\left(\begin{array}{} 
3 & 5\\
7 & 11
\end{array}\right)
```

**Example 2:**
```math
\left(\begin{array}{} 
1 & 2 & 3\\
3 & 4 & 1
\end{array}\right)*\left(\begin{array}{} 
1 & 2\\
2 & 1\\
1 & 1
\end{array}\right)=\left(\begin{array}{} 
8 & 7\\
12 & 11
\end{array}\right)
```

