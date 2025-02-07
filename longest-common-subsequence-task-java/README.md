# The Longest Common Subsequence (LCS) problem 

## Purpose

The following coding exercises are designed to test your knowledge of the following concepts:

* The LCS problem and its optimal substructure

## Overview

The coding exercises cover the following practical problems:
* Finding the optimal substructure matrix for the LCS problem
* Constructing the optimal solution using the optimal substructure matrix for the LCS problem

## Coding exercises

### Exercise 1: Find the optimal substructure matrix for the LCS problem

Your task is to implement the following static method for finding the optimal substructure given an `LCS` problem definition:

```java
/**
 * Returns the LCS optimal substructure using the two strings a and b.
 *
 * The idea is to build a matrix f, where
 *   f[i][j] - the maximum length of the common subsequence for the first i characters of the first string,
 *     and the first j characters of the second string
 *
 * NOTE: sometimes you won't be able to fill in the matrix f completely, for all
 *   'undefined' combinations of i and j just use 0 as a placeholder.
 *
 * NOTE: the result f is expected to have (N+1, M+1) shape,
 *   where N and M are the lengths of the given strings.
 *
 * NOTE: O(N * M) complexity is expected.
 *
 * @param a the first string.
 * @param b the second string.
 * @return the optimal substructure matrix for the given LCS problem.
 */
public static int[][] getOptimalSubstructure(String a, String b)
```

**Example 1:**

`a`="aa"

`b`="ab"

Expected result:
```math
\begin{pmatrix}
0 & 0 & 0 \\
0 & 1 & 1 \\
0 & 1 & 1
\end{pmatrix}
```

**Example 2:**

`a`="aaa"

`b`="aba"

Expected result:
```math
\begin{pmatrix}
0 & 0 & 0 & 0 \\
0 & 1 & 1 & 1 \\
0 & 1 & 1 & 2 \\
0 & 1 & 1 & 2
\end{pmatrix}
```

**Example 3:**

`a`="ababab"

`b`="accabcc"

Expected result:
```math
\begin{pmatrix}
0 & 0 & 0 & 0 & 0 & 0 & 0 & 0\\
0 & 1 & 1 & 1 & 1 & 1 & 1 & 1\\
0 & 1 & 1 & 1 & 1 & 2 & 2 & 2\\
0 & 1 & 1 & 1 & 2 & 2 & 2 & 2\\
0 & 1 & 1 & 1 & 2 & 3 & 3 & 3\\
0 & 1 & 1 & 1 & 2 & 3 & 3 & 3\\
0 & 1 & 1 & 1 & 2 & 3 & 3 & 3
\end{pmatrix}
```

<br>

Please use the template `Solution.getOptimalSubstructure` for the implementation.

### Exercise 2: Construct the optimal solution using the optimal substructure matrix

Your task is to implement the following static method for constructing the optimal solution to the `LCS` problem with the optimal substructure matrix:

```java
/**
 * Returns an optimal solution to the LCS problem using the first string and
 * the optimal substructure matrix.
 *
 * NOTE: if there are multiple optimal solutions, feel free to return any of them.
 *
 * @param a the first string.
 * @param optimalSubstructure the optimal substructure of the LCS knapsack problem previously 
 *   calculated using the `getOptimalSubstructure` method.
 * @return the optimal solution to the LCS problem.
 */
public static String getOptimalSolution(String a, int[][] optimalSubstructure)
```

**Example 1:**

`a`="aa"

`optimalSubstructure`:
```math
\begin{pmatrix}
0 & 0 & 0 \\
0 & 1 & 1 \\
0 & 1 & 1
\end{pmatrix}
```

Expected result: "a".

**Example 2:**

`a`="aaa"

`optimalSubstructure`:
```math
\begin{pmatrix}
0 & 0 & 0 & 0 \\
0 & 1 & 1 & 1 \\
0 & 1 & 1 & 2 \\
0 & 1 & 1 & 2
\end{pmatrix}
```

Expected result: "aa".

**Example 3:**

`string_a`="ababab"

`optimalSubstructure`:
```math
\begin{pmatrix}
0 & 0 & 0 & 0 & 0 & 0 & 0 & 0\\
0 & 1 & 1 & 1 & 1 & 1 & 1 & 1\\
0 & 1 & 1 & 1 & 1 & 2 & 2 & 2\\
0 & 1 & 1 & 1 & 2 & 2 & 2 & 2\\
0 & 1 & 1 & 1 & 2 & 3 & 3 & 3\\
0 & 1 & 1 & 1 & 2 & 3 & 3 & 3\\
0 & 1 & 1 & 1 & 2 & 3 & 3 & 3
\end{pmatrix}
```

Expected result: "aab".

<br>

Please use the template `Solution.getOptimalSolution` for the implementation.
