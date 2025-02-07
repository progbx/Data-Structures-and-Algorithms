# The Knuth-Morris-Pratt algorithm

## Purpose

The coding exercises are designed to test your knowledge of the following concepts:

* The LPS array
* The KMP algorithm for matching strings
* Applying the KMP algorithm in practice

## Overview

The coding exercises cover the following practical problems:
* Building an LPS array for a given string
* Implementing the KMP algorithm
* Checking whether a given string is a tandem repeat

## Coding exercises

### Exercise 1: Build the LPS array for a given string

Your task is to implement the following static method, which returns `the LPS array` for a given string:

```java
/**
    * Returns the LPS array for a given string.
    *
    * @param text a given string.
    * @return the result LPS array.
    */
public static int[] buildLPSArray(String text) {
        //put your code here
        return new int[0];
}
```


**Example 1:**

`text`="abracadabra"

Expected output: [0, 0, 0, 1, 0, 1, 0, 1, 2, 3, 4]

**Example 2:**

`text`="abacaba"

Expected output: [0, 0, 1, 0, 1, 2, 3]

**Example 3:**

`text`="ababbaab"

Expected output: [0, 0, 1, 2, 0, 1, 1, 2]

<br>

Please use the template `Solution.buildLPSArray` for the implementation.

### Exercise 2: Implementing the KMP algorithm

Your task is to implement the following static method for matching strings using `the Knuth-Morris-Pratt algorithm`:

```java
/**
 * Returns all positions within a given text where a given pattern occurs.
 * 
 * NOTE: Please use the KMP algorithm.
 *
 * @param text the text to be search.
 * @param pattern the pattern to search for.
 * @return all indices in the given text where the pattern occurs.
 */
public static List<Integer> findOccurrencesViaKMP(String text, String pattern) {
        //put your code here
        return List.of();
}
```


**Example 1:**

`text`="hello world"

`pattern`="o"

Expected result: [4, 7]

**Example 2:**

`text`="abacaba"

`pattern`="aba"

Expected output: [0, 4]

**Example 3:**

`text`="ababbaab"

`pattern`="ab"

Expected output: [0, 2, 6]

**Example 4:**

`text`="ababbaab"

`pattern`="caba"

Expected output: []

<br>

Please use the template `Solution.findOccurrencesViaKMP` for the implementation.

### Exercise 3: Check whether a given string is a tandem repeat

A string `s` is called a tandem repeat if a non-empty string `t` (|`s`| > |`t`|) exists such that `s=t^k` (`s` is equal to string `t` concatenated `k` times) for a positive integer `k` (where `k>1`).

Your task is to implement the following static method, which checks whether a given string is a tandem repeat:

```java
/**
 * Checks whether a given string is a tandem repeat.
 * 
 * NOTE: The expected complexity is O(n), where n is the length of `text`.
 *
 * @param text a given string
 * @return whether a given string is a tandem repeat.
 */
public static boolean isTandemRepeat(String text) {
        //put your code here
        return false;
}
```


**Example 1:**

`text`='abacaba'

Expected result: False

**Example 2:**

`text`='**aba**abaabaaba'

Expected output: True

Explanation: 'aba' is repeated 4 times. 'abaaba' also works here (it is repeated twice). 

**Example 3:**

`text`='**ab**abab'

Expected output: True

Explanation: 'ab' is repeated 3 times.

<br>

Please use the template `Solution::isTandemRepeat` for the implementation.
