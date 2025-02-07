# Basic sorting algorithms

## Purpose

The coding exercises are designed to test your knowledge of the following concepts:
* The selection sort algorithm
* The insertion sort algorithm
* The bubble sort algorithm

## Overview

The coding exercises cover the following practical problems:
* Implementing and analyzing the selection sort algorithm
* Implementing and analyzing the insertion sort algorithm
* Implementing and analyzing the bubble sort algorithm

## Coding exercises

### Exercise 1: Partial Selection Sort

Your task is to implement the following static method 
for partial sorting of a given array using `the selection sort algorithm` 
and a given number of iterations:

```
    /**
     * Returns the partially sorted array after 'k' iterations of the Selection Sort algorithm.
     * NOTE: after the first 'i' iterations - the first 'i + 1' elements of the array should be ordered.
     * NOTE: 0 <= k < data.length
     *
     * @param data a given array to order.
     * @param k the required number of selection sort iterations
     * @return the partially sorted array.
     * @param <T> type of array elements
     */
    public static <T extends Comparable<T>> T[] partialSelectionSort(T[] data, int k)
```

**Example 1:**

`data`=[4,8,6,2,5]

`k`=1

Expected output: [**2**,8,6,4,5]


**Example 2:**

`data`=[4,8,6,2,5]

`k`=2

Expected output: [**2**,**4**,6,8,5]


**Example 3:**

`data`=[4,8,6,2,5]

`k`=3

Expected output: [**2**,**4**,**5**,8,6]


**Example 4:**

`data`=[4,8,6,2,5]

`k`=4

Expected output: [**2**,**4**,**5**,**6**,8]


**Example 5:**

`data`=["aa", "b", "ab", "a", "bb", "ba"]

`k`=5

Expected output: ["a", "aa", "ab", "b", "ba", "bb"]



<br>

Please use the template `Solution.partialSelectionSort` for the implementation.

### Exercise 2: Partial Insertion Sort

Your task is to implement the following static method
for partial sorting of a given array using `the insertion sort algorithm` 
nd a given number of iterations:

```
    /**
     * Returns the partially sorted array after 'k' iterations of the Insertion Sort algorithm.
     * NOTE: after the first 'i' iterations - the first 'i + 1' elements of the array should be ordered.
     * NOTE: 0 <= k < data.length
     *
     * @param data a given array to order.
     * @param k the required number of insertion sort iterations
     * @return the partially sorted array.
     * @param <T> type of array elements
     */
    public static <T extends Comparable<T>> T[] partialInsertionSort(T[] data, int k)
```

**Example 1:**

`data`=[4,8,6,2,5]

`k`=1

Expected output: [**4**,**8**,6,2,5]


**Example 2:**

`data`=[4,8,6,2,5]

`k`=2

Expected output: [**4**,**6**,**8**,2,5]


**Example 3:**

`data`=[4,8,6,2,5]

`k`=3

Expected output: [**2**,**4**,**6**,**8**,5]


**Example 4:**

`data`=[4,8,6,2,5]

`k`=4

Expected output: [2,4,5,6,8]

**Example 5:**

`data`=["aa", "b", "ab", "a", "bb", "ba"]

`k`=5

Expected output: ["a", "aa", "ab", "b", "ba", "bb"]



<br>

Please use the template `Solution.partialInsertionSort` for the implementation.

### Exercise 3: Partial Bubble Sort

Your task is to implement the following static method  
for partial sorting of a given array using `the bubble sort algorithm` 
and a given number of **swaps**:

```
    /**
     * Returns the intermediate state of a given array after 'k' swaps of the Bubble Sort algorithm.
     * NOTE: if 'k' exceeds the number of swaps required (and an array can be sorted
     * in less than 'k' swaps) - just ignore the other 'potential' swaps and return the sorted array.
     *
     * @param data a given array to order.
     * @param k the required number of bubble sort swaps
     * @return the intermediate array after 'k' swaps.
     * @param <T> type of array elements
     */
    public static <T extends Comparable<T>> T[] partialBubbleSort(T[] data, int k)
```

**Example 1:**

`data`=[4,8,6,2,5]

`k`=1

Expected output: [4,**6**,**8**,2,5]


**Example 2:**

`data`=[4,8,6,2,5]

`k`=2

Expected output: [4,6,**2**,**8**,5]


**Example 3:**

`data`=[4,8,6,2,5]

`k`=3

Expected output: [4,6,2,**5**,**8**]


**Example 4:**

`data`=[4,8,6,2,5]

`k`=4

Expected output: [4,**2**,**6**,5,8]

**Example 5:**

`data`=[4,8,6,2,5]

`k`=5

Expected output: [4,2,**5**,**6**,8]

**Example 6:**

`data`=[4,8,6,2,5]

`k`=6

Expected output: [**2**,**4**,5,6,8]

**Example 7:**


`data`=["aa", "b", "ab", "a", "bb", "ba"]

`k`=10

Expected output: ["a", "aa", "ab", "b", "ba", "bb"]

<br>

Please use the template `Solution.partialBubbleSort` for the implementation.

