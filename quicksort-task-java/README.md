# The Quicksort algorithm

## Purpose

The coding exercises are designed to test your knowledge of the following concepts:

* The quicksort algorithm
* Lomuto partitioning
* Hoare partitioning

## Overview

The coding exercises cover the following practical problems:
* Implementing the quicksort algorithm with Lomuto partitioning
* Implementing the quicksort algorithm with Hoare partitioning

## Coding exercises

### Exercise 1: Quicksort (Lomuto Partitioning)

Your task is to implement 3 static methods 
to get the quicksort algorithm with Lomuto partitioning:

```java
public class Solution {

    /**
     * Representation of a pair of integers.
     *
     * Do not change this class!
     */
    public static class Pair {
        /**
         * the index
         */
        private int index;
        /**
         * the number of swaps used
         */
        private int swapsNumber;

        public Pair(int index, int swapsNumber) {
            this.index = index;
            this.swapsNumber = swapsNumber;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getSwapsNumber() {
            return swapsNumber;
        }

        public void setSwapsNumber(int swapsNumber) {
            this.swapsNumber = swapsNumber;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return index == pair.index && swapsNumber == pair.swapsNumber;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, swapsNumber);
        }
    }

    /**
     * Returns a partition index after Lomuto partitioning and the number of swaps used.
     *
     * The idea is simple:
     * - you need to partition a given array using the `rightIndex` element
     * - `partitionIndex` (the first number that should be returned) should contain the last element
     *     of a given interval (the pivot itself), and all elements to the left of it should be strictly lower than the pivot
     * - while partitioning, you need to keep track of the number of swaps required
     *     (according to the pseudocode below)
     *
     *     NOTE: refer to this pseudocode if necessary: https://www.baeldung.com/cs/algorithm-quicksort#1-lomuto-partitioning
     *       The idea is to keep two pointers and gradually move them toward the center.
     *
     *     NOTE: the expected time complexity is O(n), where n = rightIndex - leftIndex + 1
     *     NOTE: this method should work in-place
     *
     * @param array a given array to partition
     * @param leftIndex a starting index for partitioning
     * @param rightIndex an ending index for partitioning
     * @return a Pair instance, where the `pair.index` is the index of the pivoting element after partitioning
     */
    public static <T extends Comparable<T>> Pair lomutoPartition(T[] array, int leftIndex, int rightIndex) {
        //pivoting element => array[rightIndex]
        //put your code here

        //update the arguments in the constructor call if necessary
        return new Pair(0, 0);
    }

    /**
     * Implements the quicksort algorithm with Lomuto partitioning.
     *
     * @param array a given array to sort in ascending order
     * @return the number of swaps used
     */
    public static <T extends Comparable<T>> int quicksortLomuto(T[] array) {
        //update the arguments in the method call if necessary
        return iterationLomuto(array, 0, 0);
    }

    private static <T extends Comparable<T>> int iterationLomuto(T[] array, int leftIndex, int rightIndex) {
        //replace pseudocode below by the java code

        //if leftIndex >= rightIndex then return ...;
        //Pair pair = lomutoPartition(...);
        //pair.swapsNumber += iterationLomuto(...)
        //pair.swapsNumber += iterationLomuto(...)
        //return ...;

        return 0;
    }

}
```


**Example 1:**

`lomutoPartition([5, 3, 2, 1, 7, 4], 0, 5)`

Expected result:
* `partitionIndex`=3
* `swapsNumber`=4

Explanation:
* 1-st swap: Indices 0 and 1
    * Array after the swap: [**3**, **5**, 2, 1, 7, 4]
* 2-nd swap: Indices 1 and 2
    * Array after the swap: [3, **2**, **5**, 1, 7, 4]
* 3-rd swap: Indices 2 and 3
    * Array after the swap: [3, 2, **1**, **5**, 7, 4]
* 4-th swap: Indices 3 and 5
    * Array after the swap: [3, 2, 1, **4**, 7, **5**]

**Example 2:**

`lomutoPartition([2, 5, 3, 1, 4], 0, 4)`

Expected result:
* `partitionIndex`=3
* `swapsNumber`=4

Explanation:
* 1-st swap: Indices 0 and 0 (!!!)
    * Array after the swap: [**2**, 5, 3, 1, 4]
* 2-nd swap: Indices 1 and 2
    * Array after the swap: [2, **3**, **5**, 1, 4]
* 3-rd swap: Indices 2 and 3
    * Array after the swap: [2, 3, **1**, **5**, 4]
* 4-th swap: Indices 3 and 4
    * Array after the swap: [2, 3, 1, **4**, **5**]

**Example 3:**

`lomutoPartition([1, 2, 4, 5, 6, 3], 0, 5)`

Expected result:
* `partitionIndex`=2
* `swapsNumber`=3

Explanation:
* 1-st swap: Indices 0 and 0 (!!!)
    * Array after the swap: [**1**, 2, 4, 5, 6, 3]
* 2-nd swap: Indices 1 and 1 (!!!)
    * Array after the swap: [1, **2**, 4, 5, 6, 3]
* 3-rd swap: Indices 2 and 5
    * Array after the swap: [1, 2, **3**, 5, 6, **4**]

**Example 4:**

`quicksortLomuto([1, 2, 3, 4, 5])`

Expected result:
* `array`=[1, 2, 3, 4, 5]
* `swapsNumber`=14

**Example 5:**

`quicksortLomuto([5, 4, 3, 2, 1])`

Expected result:
* `array`=[1, 2, 3, 4, 5]
* `swapsNumber`=8

**Example 6:**

`quicksortLomuto([5, 3, 2, 7, 5, 9])`

Expected result:
* `array`=[2, 3, 5, 5, 7, 9]
* `swapsNumber`=11

**Example 7:**

`quicksortLomuto(["learning", "algorithms", "and", "data", "structures"])`

Expected result:
* `array`=["algorithms", "and", "data", "learning", "structures"]
* `swapsNumber`=10

<br>


Please use the templates `lomutoPartition`, `quicksortLomuto`, `iterationLomuto` for the implementation.


### Exercise 2: Quicksort (Hoare partitioning)

Your task is to implement 3 static methods to get the quicksort algorithm with Hoare partitioning:

```java
public class Solution {

    /**
     * Returns a partition index after Hoare partitioning and the number of swaps used.
     *
     * The idea is simple:
     * - you need to partition a given array using the `middle` element
     * - while partitioning, you need to keep track of the number of swaps required
     *     (according to the pseudocode below)
     *
     *     NOTE: refer to this pseudocode if necessary: https://www.baeldung.com/cs/algorithm-quicksort#2-hoare-partitioning
     *       The idea is to keep two pointers and gradually move them toward the center.
     *
     *     NOTE: the expected time complexity is O(n), where n = rightIndex - leftIndex + 1
     *     NOTE: this method should work in-place
     *
     * @param array a given array to partition
     * @param leftIndex a starting index for partitioning
     * @param rightIndex an ending index for partitioning
     * @return a Pair instance, where the `pair.index` is the final position of the 'right' pointer just before partitioning
     *         ('left' pointer >= 'right' pointer)
     */
    public static <T extends Comparable<T>> Pair hoarePartition(T[] array, int leftIndex, int rightIndex) {
        //pivoting element => array[(left_index + right_index) / 2]
        //put your code here

        //update the arguments in the constructor call if necessary
        return new Pair(0, 0);
    }

    /**
     * Implements the quicksort algorithm with Hoare partitioning.
     *
     * @param array a given array to sort in ascending order
     * @return the number of swaps used
     */
    public static <T extends Comparable<T>> int quicksortHoare(T[] array) {
        //update the arguments in the method call if necessary
        return iterationHoare(array, 0, 0);
    }

    private static <T extends Comparable<T>> int iterationHoare(T[] array, int leftIndex, int rightIndex) {
        //replace pseudocode below by the java code

        //if leftIndex >= rightIndex then return ...;
        //Pair pair = hoarePartition(...);
        //pair.swapsNumber += iterationHoare(...);
        //pair.swapsNumber += iterationHoare(...);
        //return ...;

        return 0;
    }

}
```


**Example 1:**

`hoarePartition([1, 5, 3, 2, 4], 0, 4)`

Expected result:
* `partitionIndex`=2
* `swapsNumber`=1

Explanation:
* 1-st swap: Indices 1 and 3
    * Array after the swap: [1, **2**, 3, **5**, 4]

**Example 2:**

`hoarePartition([6, 5, 4, 3, 2, 1], 0, 5)`

Expected result:
* `partitionIndex`=2
* `swapsNumber`=3

Explanation:
* 1-st swap: Indices 0 and 5
    * Array after the swap: [**1**, 5, 4, 3, 2, **6**]
* 2-nd swap: Indices 1 and 4
    * Array after the swap: [1, **2**, 4, 3, **5**, 6]
* 3-rd swap: Indices 2 and 3
    * Array after the swap: [1, 2, **3**, **4**, 5, 6]

**Example 3:**

`quicksortHoare([6, 5, 4, 3, 2, 1])`

Expected result:
* `array`=[1, 2, 3, 4, 5, 6]
* `swapsNumber`=3

**Example 4:**

`quicksortHoare([5, 3, 2, 7, 5, 9])`

Expected result:
* `array`=[2, 3, 5, 5, 7, 9]
* `swapsNumber`=3

**Example 5:**

`quicksortHoare([6, 6, 1, 8, 3, 1, 7, 4, 2])`

Expected result:
* `array`=[1, 1, 2, 3, 4, 6, 6, 7, 8]
* `swapsNumber`=8

**Example 6:**

`quicksortHoare(["learning", "algorithms", "and", "data", "structures"])`

Expected result:
* `array`=["algorithms", "and", "data", "learning", "structures"]
* `swapsNumber`=3

<br>

Please use the templates `hoarePartition`, `quicksortHoare`, `iterationHoar` for the implementation.

