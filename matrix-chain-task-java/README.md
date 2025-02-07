# The Matrix Chain Multiplication Problem

## Purpose

The coding exercises are designed to test your knowledge of the following concepts:
* The matrix chain multiplication problem
* Applying dynamic programming to solve the matrix chain multiplication problem

## Overview

The coding exercises cover the following practical problems:
* Finding the optimal substructure for a matrix chain multiplication problem
* Constructing a solution to a matrix chain multiplication problem

## Coding exercises

### Exercise 1: Find the optimal substructure for a given matrix chain multiplication problem

Your task is to implement the following static method for returning the optimal substructure for a given matrix multiplication problem:

```java
/**
 * Returns the optimal substructure matrix for a given MCM problem.
 *
 * The idea is to create a matrix F, where:
 *   F[i][j] is the minimum number of operations required to multiply matrices with the indices [i..j].
 * 
 * NOTE: assume that to multiply matrices Anm and Bmk you need n*m*k operations.
 * 
 * NOTE: F[i][i] = 0 for i in 1..|dimensionsOfMatrices|
 * 
 * NOTE: F[i][j] = 0, where i > j.
 * 
 * NOTE: the expected time complexity is O(N^3), where N=|dimensionsOfMatrices|
 * 
 * @param dimensionsOfMatrices a set of matrix dimensions that correspond to an MCM problem.
 * @return the optimal substructure matrix `F` for an MCM problem.
 */
public static int[][] getOptimalSubstructure(int[][] dimensionsOfMatrices)
```

**Example 1:**

`dimensionsOfMatrices`=[(5, 12), (12, 7), (7, 3), (3, 6)]

which corresponds to the following matrix chain multiplication problem:
$$
A_{5\times 12} \cdot B_{12\times 7} \cdot C_{7\times 3} \cdot D_{3\times 6}
$$

Expected output:

```math
A=\begin{pmatrix}
0 & 420 & 432 & 522 \\
0 & 0 & 252 & 468 \\
0 & 0 & 0 & 126 \\
0 & 0 & 0 & 0
\end{pmatrix}
```

**Example 2:**

`dimensionsOfMatrices`=[(3, 2), (2, 5), (5, 2)]

which corresponds to the following matrix chain multiplication problem:
$$
A_{3\times 2} \cdot B_{2\times 5} \cdot C_{5\times 2}
$$

Expected output:

```math
A=\begin{pmatrix}
0 & 30 & 32 \\
0 & 0 & 20 \\
0 & 0 & 0
\end{pmatrix}
```

**Example 3:**

`dimensionsOfMatrices`=[(1, 5), (5, 3), (3, 6), (6, 2)]

which corresponds to the following matrix chain multiplication problem:
$$
A_{1\times 5} \cdot B_{5\times 3} \cdot C_{3\times 6} \cdot C_{6\times 2}
$$

Expected output:

```math
A=\begin{pmatrix}
0 & 15 & 33 & 45 \\
0 & 0 & 90 & 66 \\
0 & 0 & 0 & 36 \\
0 & 0 & 0 & 0
\end{pmatrix}
```

<br>

Please use the template `Solution.getOptimalSubstructure` for the implementation.

### Exercise 2: Construct a solution for a given matrix chain multiplication problem

Your task is to implement the following static method for constructing the solution to a matrix chain multiplication problem in string form (please see the details below):

```java
/**
 * Returns the solution to a given MCM problem in string format.
 *
 * NOTE: you may use the method `getOptimalSubstructure` (if you've already implemented it).
 * 
 * String format of an MCM problem is a sequence of "*" symbols and brackets - "(", ")".
 * 
 * If you have two matrices, A and B, the only solution (optimal, obviously) is "*".
 * If you have three matrices, A, B and C, the following solutions are possible:
 * - "(*)*"
 * - "*(*)"
 * If you have four matrices, A, B, C and D, the following solutions are possible:
 * - "((*)*)*"
 * - "(*(*))*"
 * - "*((*)*)"
 * - "*(*(*))"
 * 
 * NOTE: All brackets should be explicitly mentioned in the solution string.
 * 
 * NOTE: if N=|dimensionsOfMatrices|, the expected solution should:
 * - contain N-1 "*" symbols
 * - contain N-2 pairs of brackets ("(" and ")")
 * 
 * NOTE: It is guaranteed that there is only one optimal solution.
 * 
 * NOTE: The expected time complexity is O(N^3), where N=|dimensionsOfMatrices|.
 * 
 * @param dimensionsOfMatrices a set of matrix dimensions that correspond
 *     to an MCM problem
 * @return the optimal solution to an MCM problem in string format.
*/
public static String getMCMSolution(int[][] dimensionsOfMatrices)
```

**Example 1:**

`dimensionsOfMatrices`=[(5, 12), (12, 7), (7, 3), (3, 6)]

which corresponds to the following matrix chain multiplication problem:
$$
A_{5\times 12} \cdot B_{12\times 7} \cdot C_{7\times 3} \cdot D_{3\times 6}
$$

Expected output: 

`solution`="(\*(\*))\*"

$$
(A_{5\times 12} \cdot (B_{12\times 7} \cdot C_{7\times 3})) \cdot D_{3\times 6}
$$

**Example 2:**

`dimensionsOfMatrices`=[(3, 2), (2, 5), (5, 2)]

which corresponds to the following matrix chain multiplication problem:
$$
A_{3\times 2} \cdot B_{2\times 5} \cdot C_{5\times 2}
$$

Expected output:

`solution`="\*(\*)"

$$
A_{3\times 2} \cdot (B_{2\times 5} \cdot C_{5\times 2})
$$

**Example 3:**

`dimensionsOfMatrices`=[(1, 5), (5, 3), (3, 6), (6, 2)]

which corresponds to the following matrix chain multiplication problem:
$$
A_{1\times 5} \cdot B_{5\times 3} \cdot C_{3\times 6} \cdot C_{6\times 2}
$$

Expected output:

`solution`="((\*)\*)\*"

$$
((A_{1\times 5} \cdot B_{5\times 3}) \cdot C_{3\times 6}) \cdot C_{6\times 2}
$$

<br>

Please use the template `Solution.getMCMSolution` for the implementation.
