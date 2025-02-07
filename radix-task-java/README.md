# Bucket and Radix sorting algorithms

## Purpose

The coding exercises are designed to test your knowledge of the following concepts:

* The bucket sort algorithm
* The radix sort algorithm

## Overview

The coding exercises cover the following practical problems:
* Implementing the bucket sort algorithm
* Implementing the radix sort algorithm


## Coding exercises

### Exercise 1: Implement the bucket sort algorithm

Your task is to implement the following static method, 
which emulates the bucket sort algorithm:

```java
public class Solution {

    /**
     * Representation of a pair of integers.
     *
     * Do not change this class!
     */
    public static class Pair {
        /**
         * Global position of a pattern in an ordered list.
         */
        private int global;
        /**
         * Local position of a pattern in an ordered list.
         */
        private int local;

        public Pair(int global, int local) {
            this.global = global;
            this.local = local;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return global == pair.global && local == pair.local;
        }

        @Override
        public int hashCode() {
            return Objects.hash(global, local);
        }
    }


    /**
     * Orders a given list of strings using bucket sort.
     *
     * NOTE: for bucketing purposes, you need to use the first `prefixLength` characters
     * of each input pattern.
     *     Example 1:
     *     | patterns = ["aa", "ab", "ba", "bb", "bbac"], prefixLength=1
     *     | buckets = {"a": ["aa", "ab"], "b": ["ba", "bb", "bbac"]}
     *
     *     Example 2:
     *     | patterns = ["aa", "ab", "ba", "bb", "bbac"], prefixLength=2
     *     | There will be four buckets (two patterns in the bucket "bb").
     *
     * NOTE: for each input pattern, you should return two things:
     * 1. the final (global) position of pattern after bucket sort
     * 2. the local position of a pattern in corresponding bucket after ordering within a bucket
     *
     * @param patterns a given list of patterns to order
     * @param prefixLength a parameter that should be used to bucket patterns
     * @return positions that correspond to given patterns both globally and
     *             within individual buckets
     */
    public static List<Pair> bucketSort(List<String> patterns, int prefixLength) {
        //put your code here
        return List.of();
    }

}
```

**Example 1:**

`patterns`=["abc", "cab", "qaf", "cabg", "qwr", "qegtw"]

`prefixLength`=1

Expected result: [ <br>
(0, 0), // "abc" <br>
(1, 0), // "cab" <br>
(3, 0), // "qaf" <br>
(2, 1), // "cabg" <br>
(5, 2), // "qwr" <br>
(4, 1), // "qegtw" <br>
]

Explanation: there will be three buckets (the patterns are already ordered):
* "a": ["abc"]
* "c": ["cab", "cabg"]
* "q": ["qaf", "qegtw", "qwr"]


**Example 2:**

`patterns`=["aaaba", "aaaa", "basfa", "badaa", "macda"]

`prefixLength`=2

Expected result: [ <br>
(1, 1), // "aaaba" <br>
(0, 0), // "aaaa" <br>
(3, 1), // "basfa" <br>
(2, 0), // "badaa" <br>
(4, 0), // "macda" <br>
]

Explanation: there will be three buckets (the patterns are already ordered):
* "aa": ["aaaa", "aaaba"]
* "ba": ["badaa", "basfa"]
* "ma": ["macda"]


**Example 3:**

`patterns`=["aa", "bb", "aa", "bb", "aa"]

`prefixLength`=1

Expected result: [ <br>
(0, 0), // "aa" <br>
(3, 0), // "bb" <br>
(1, 1), // "aa" <br>
(4, 1), // "bb" <br>
(2, 2), // "aa" <br>
]

Explanation: there will be two buckets (the patterns are already ordered):
* "a": ["aa", "aa", "aa"]
* "b": ["bb", "bb"]


<br>

Please use the template `bucketSort` for the implementation.


### Exercise 2: Implement the radix sort algorithm

Your task is to implement the following static method, 
which returns intermediate indices of given elements after `k` iterations of the radix sort algorithm:

```java
public class Solution {

    /**
     * Emulates a given number of iterations of the radix sort algorithm.
     *
     * NOTE: all elements of a given list are in string format but contain only '0'-'9' characters.
     * NOTE: assume that all input elements have the same length d (k <= d).
     *
     * @param array a given list of 'integers' to order
     * @param k the required number of radix sort iterations
     * @return the list of intermediate positions after `k` iterations.
     */
    public static List<Integer> radixSort(List<String> array, int k) {
        return List.of();
    }

}
```

**Example 1:**

`array`=["542", "124", "423", "142", "631", "624"]

`k`=1

Expected result: [1, 4, 3, 2, 0, 5]

Explanation:

After the first iteration, the numbers will be ordered as follows:
* ["631", "542", "142", "423", "124", "624"]
* "542" has index `1`
* "123" has index `4`
* "423" has index `3`, etc.


**Example 2:**

`array`=["542", "124", "423", "142", "631", "624"]

`k`=2

Expected result: [4, 1, 0, 5, 3, 2]

Explanation:

After the second iteration, the numbers will be ordered as follows:
* ["423", "124", "624", "631", "542", "142"]


**Example 3:**

`array`=["542", "124", "423", "142", "631", "624"]

`k`=3

Expected result: [3, 0, 2, 1, 5, 4]

Explanation:

After the third (final) iteration, the numbers will be ordered as follows:
* ["124", "142", "423", "542", "624", "631"]


**Example 4:**

`array`=["22", "32", "33", "11", "11"]

`k`=1

Expected result: [2, 3, 4, 0, 1]

Explanation:

After the third (final) iteration, the numbers will be ordered as follows:
* ["11", "11", "22", "32", "33"]

<br>

Please use the template `radixSort` for the implementation.

