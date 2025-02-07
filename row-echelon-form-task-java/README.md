# Row-echelon form and equivalent operations

## Purpose

The following coding exercises are designed to test your knowledge of the following concepts:

* Row echelon and reduced row-echelon forms of a matrix
* Equivalent matrix operations
* The rank of a matrix

## Overview

The coding exercises cover the following practical problems:
* Checking whether a given matrix is in row-echelon form
* Converting a given matrix into reduced row-echelon form
* Finding a rank of a given square matrix

## Coding exercises

### Exercise 1: Check whether a given matrix is in row-echelon form

Your task is to implement the following function to verify whether a matrix is in row-echelon form:

```java
	/**
	* Checks whether a given matrix is in row-echelon form.
	* 
    * NOTE: To avoid issues with precision, use EPS=1e-8 to detect zeros:
    *     |x| < EPS => We assume that x is zero.
	* 
	* @param matrix a given numeric matrix.
	* @return whether a given matrix is in row-echelon form.
	*/
	public static boolean isRowEchelonForm(double[][] matrix)
```

**Example 1:**
```math
matrix = \left(\begin{array}{} 
1 & 2\\
3 & 4
\end{array}\right)
```

Expected output: false.

**Example 2:**
```math
matrix = \left(\begin{array}{} 
1 & 1 & 2 & 1\\
0 & 1 & 3 & 12\\
0 & 0 & 1 & 8\\
0 & 0 & 0 & 1
\end{array}\right)
```

Expected output: true.

**Example 3:**
```math
matrix = \left(\begin{array}{} 
1 & 1 & 2 & 1 & 1\\
0 & 2 & 3 & 12 & 3\\
0 & 0 & 0 & 8 & 4\\
0 & 0 & 0 & 0 & 2
\end{array}\right)
```

Expected output: true.


### Exercise 2: Convert a given matrix into reduced row-echelon form

Your task is to implement the following function for converting matrices into `reduced row echelon form`:

```java
	/**
	* Returns the reduced row-echelon form of a given matrix.
	* 
	* NOTE: Reduced row-echelon form of a matrix is unique and does not depend on the algorithm used to compute it.
	* 
	* NOTE: You are not allowed to permute rows or columns.
	* 
	* NOTE: To avoid issues with precision, use EPS=1e-8 to detect zeros:
	* |x| < EPS => We assume that x is zero.
	* 
	* @param matrix a given numeric matrix.
	* @return the reduced row-echelon form of a given matrix.
	*/
	public static double[][] convertIntoRref(double[][] matrix)
```

**Example 1:**
```math
matrix = \left(\begin{array}{} 
1 & 5 & 1\\
2 & 11 & 5
\end{array}\right)

result = \left(\begin{array}{} 
1 & 0 & -14\\
0 & 1 & 3
\end{array}\right)
```

**Example 2:**
```math
matrix = \left(\begin{array}{} 
1 & 5 & 6\\
2 & 4 & 7\\
3 & 5 & 9
\end{array}\right)

result = \left(\begin{array}{} 
1 & 0 & 0\\
0 & 1 & 0\\
0 & 0 & 1
\end{array}\right)
```

**Example 3:**
```math
matrix = \left(\begin{array}{} 
1 & 5 & 6\\
5 & 0 & 4\\
1 & 2 & 5\\
4 & 2 & 4
\end{array}\right)

result = \left(\begin{array}{} 
1 & 0 & 0\\
0 & 1 & 0\\
0 & 0 & 1\\
0 & 0 & 0
\end{array}\right)
```

### Exercise 3: Find the rank of a given square matrix

Your task is to implement the following function to find the ranks of square matrices:

```java
	/**
	* Returns the rank of a given square matrix.
	* 
	* NOTE: You may use the 'convertIntoRref' function here.
	* 
	* NOTE: To avoid issues with precision, use EPS=1e-8 to detect zeros:
	* |x| < EPS => We assume that x is zero.
	* 
	* @param matrix a given numeric matrix.
	* @return the rank of a given square matrix.
	*/
	public static int getRankOfSquareMatrix(double[][] matrix)
```

**Example 1:**
```math
matrix = \left(\begin{array}{} 
1 & 5 & 6\\
2 & 4 & 7\\
3 & 5 & 9
\end{array}\right)
```

Expected output: 3

**Example 2:**
```math
matrix = \left(\begin{array}{} 
1 & 2 & 4\\
2 & 4 & 3\\
2 & 4 & 2
\end{array}\right)
```

Expected output: 2

**Example 3:**
```math
matrix = \left(\begin{array}{} 
1 & 2 & 4 & 0\\
0 & 0 & 0 & 0\\
2 & 4 & 2 & 0\\
5 & 2 & 1 & 0
\end{array}\right)
```

Expected output: 3
