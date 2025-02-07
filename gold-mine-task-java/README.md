# Elements of dynamical programming

## Purpose

The coding exercise is designed to test your knowledge of the following concepts:
* Dynamic Programming
* Optimal substructure

## Overview

The coding exercise covers the Gold Mine problem.

## Coding exercises

### Exercise 1: The Gold mine problem

The Gold Mine Problem can be defined as follows:
* The gold mine is represented by a matrix of dimensions $n\times m$. 
* Each entry in this matrix contains a positive integer which is the amount of gold. 
* The miner starts at any cell of the **first column** and must finish his path in the **last column**. 
* The miner can move only **to the right** or **to the right and down** from one cell to another. 
* The miner's goal is to collect the maximum amount of gold along the way. 


The first part of the exercise is to figure out how to solve the Gold Mine Problem (described above) using dynamic programming.

The second part of the exercise is to implement the following static method to find the maximum amount of gold that can be gathered.

```java
/**
* Returns the maximum amount of gold that can be gathered by the miner.
*
* The rules for mining:
* * each entry in the matrix accounts for the amount of gold that can be gathered
* * the miner starts in the first column and ends his route in the last column
* * the miner has only two eligible moves: to the right and to the right and down
* 
* @param mines a given configuration of mines with amounts of gold for each mine.
* @return the maximum amount of gold that can be gathered.
*/
public static int getMaximumAmountOfGold(int[][] mines)
```


**Example 1:**

The source matrix of the size $3\times 3$ is:

|   i/j   |   1   |   2   |   3   |   4   |
|:-------:|:-----:|:-----:|:-----:|:-----:|
|  **1**  |   3   |   2   |   1   |   6   |
|  **2**  | **4** |   1   |   1   |   8   |
|  **3**  |   1   | **6** | **2** | **4** |

The optimal itinerary is highlighted in bold. The total amount of gold is 16.

**Example 2:**

The source matrix of the size $4\times 4$ is: 

|   i/j   |   1   |   2   |   3   |   4   |
|:-------:|:-----:|:-----:|:-----:|:-----:|
|  **1**  | **4** | **1** | **6** |   1   |
|  **2**  |   4   |   1   |   5   | **3** |
|  **3**  |   6   |   5   |   1   |   1   |
|  **4**  |   7   |   1   |   1   |   1   |

A possible optimal itinerary is highlighted in bold (there are several optimal itineraries in this example).
The target value of any optimal path is equal to 14. 

<br>

Please use the template `Solution.getMaximumAmountOfGold` for the implementation.
