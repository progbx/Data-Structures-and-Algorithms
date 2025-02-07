# The Merge sort algorithm

## Purpose

The coding exercises are designed to test your knowledge of the following concepts:

* The merge sort algorithm
* The divide and conquer paradigm

## Overview

The coding exercises cover the following practical problems:
* Merging two sorted linked lists
* Implementing the merge sort algorithm

## Coding exercises

### Exercise 1: Merge two sorted linked lists

As you should already know, a linked list can be represented in memory 
using the following data structure for its elements:

```java
import java.util.List;

/**
 * Basic data structure for custom Linked List representation
 */
public class CustomLinkedList<E extends Comparable<E>> {
  /**
   * Internal class for representing a linked list node
   */
  protected static class CustomListNode<E> {
    /**
     * Data part
     */
    protected E element;
    /**
     * Link to the next node
     */
    protected CustomListNode<E> next;

    public CustomListNode() {
    }

    public CustomListNode(E element, CustomListNode<E> next) {
      this.element = element;
      this.next = next;
    }
  }

  /**
   * Linked List head
   */
  protected CustomListNode<E> head;

  public CustomLinkedList() {
    head = null;
  }

  public CustomLinkedList(CustomLinkedList list) {
    head = list.head;
  }

  /**
   * Constructor from a list instance.
   * @param elements elements that should be inserted into the result linked list.
   */
  public CustomLinkedList(List<E> elements) {
    this();
    CustomListNode<E> curr = null;
    for (E element : elements) {
      if (head == null) {
        head = new CustomListNode<>(element, null);
        curr = head;
        continue;
      }
      curr.next = new CustomListNode<>(element, null);
      curr = curr.next;
    }
  }
  
  /**
   * Returns whether `this` instance is identical to `list` one, order of elements matters
   * @param elements `list` for identification
   * @return result of comparison
   */
  public boolean check(List<E> elements) {
    CustomListNode<E> curr = head;
    for(E element : elements) {
      if(curr == null) {
        return false;
      }
      if(!element.equals(curr.element)) {
        return false;
      } else {
        curr = curr.next;
      }
    }
    return curr == null;
  }

}
```

Your task is to implement the following method, 
which merges two given linked lists (that are already sorted), 
to obtain a new sorted linked list:

```java
    /**
     * Returns a merged (sorted) linked list using two given (sorted) linked lists: `this` and `sorted`.
     * @param sorted the second sorted linked list
     * @return the result of merging two given lists
     */
    public CustomLinkedList<E> merge(CustomLinkedList<E> sorted) {
        //put your code here
        return new CustomLinkedList<>();
    }
```

**Example 1:**

`this`="(5) -> (11) -> (30)"
`sorted`="(1) -> (6)"

Expected output:

"(1) -> (5) -> (6) -> (11) -> (30)"

**Example 2:**

`this`="(5) -> (11) -> (30)"
`sorted`="null"

Expected output:

"(5) -> (11) -> (30)"

**Example 3:**

`this`="(5) -> (11) -> (30)"
`sorted`="(5) -> (11) -> (30)"

Expected output:

"(5) -> (5) -> (11) -> (11) -> (30) -> (30)"

**Example 4:**

`this`="(a) -> (bc) -> (c)"
`sorted`="(aa) -> (abc) -> (bca) -> (cc)"

Expected output:

"(a) -> (aa) -> (abc) -> (bc) -> (bca) -> (c) -> (cc)"

<br>

Please use the template `CustomLinkedList.merge` for the implementation.

### Exercise 2: Implement the merge sort algorithm

Your task is to implement the following static methods 
to get the complete merge sort algorithm:

```java
/**
 * Merges two sorted subarrays of a given array (in-place).
 *
 * Assume the first ordered subarray is within the [leftIndex; middleIndex] interval
 * and the second subarray is within the (middleIndex; rightIdex] interval.
 *
 * NOTE: even though this method should work in-place, you can use up to O(n) auxiliary space,
 * where n = rightIndex - leftIndex + 1
 * NOTE: the expected time complexity is O(n), where n = rightIndex - leftIndex + 1
 *
 * @param data a given array that contains two subarrays for merging
 * @param leftIndex defines the left bound of the first subarray
 * @param middleIndex defines the right bound of the first subarray
 * @param rightIndex defines the right bound of the second subarray
 */
public static void mergeSortedSubarrays(int[] data, int leftIndex, int middleIndex, int rightIndex) {
        //put your code here
}

/**
 * Returns a `special statistic` that will be defined below.
 *
 * The idea is simple: You use the merge sort algorithm to order a given array, and that's it.
 * The algorithm is simple: You divide the current subarray, sort both parts, and then merge them.
 *
 * NOTE: The statistic you need to calculate has the following definition:
 * * At the beginning of the algorithm `statistic=0`
 * * Each time you use the `mergeSortedSubarrays` method, you should do the following BEFORE and AFTER each call:
 *     * `statistic += data[leftIndex]`
 *     * `statistic += data[middleIndex]` (even if leftIndex == middleIndex)
 *     * `statistic += data[rightIndex]`
 * Ask yourself, "But why?" You know, just to avoid silly stuff like `return Arrays.sort(data)`.
 *
 * NOTE: you are expected to implement `mergeSortedSubarrays` before starting with this method
 * NOTE: the expected time complexity is O(n * log n), where n=data.length
 *
 * @param data a given array of elements to sort (in ascending order)
 * @return the `statistic` defined above
 */
public static int mergeSortAlgorithm(int[] data) {
        return mergeSort(data, 0, data.length - 1);
}

private static int mergeSort(int[] data, int leftIndex, int rightIndex) {
        // [YOUR CODE HERE] Check some corner cases...

        // Don't change this!
        int middleIndex = (leftIndex + rightIndex) >> 1;
        int statistic = 0;

        // [YOUR CODE HERE] Call mergeSort a few times and aggregate `statistic` values...
        // [YOUR CODE HERE] Update `statistic`...
        // [YOUR CODE HERE] Call mergeSortedSubarrays
        // [YOUR CODE HERE] Update `statistic` again...

        return statistic;
}
```

**Example 1:**

`data`=[3, 2, 1]

Expected result: 27
`data`=[1, 2, 3]

Explanation:

`mergeSortedSubarrays` was called twice:
* mergeSortedSubarrays(0, 0, 1)
    * `statistic` += 3 + 3 + 2 (Before the call)
    * `statistic` += 2 + 2 + 3 (After the call)
* mergeSortedSubarrays(0, 1, 2)
    * `statistic` += 2 + 3 + 1 (Before the call)
    * `statistic` += 1 + 2 + 3 (After the call)


**Example 2:**

`data`=[5, 3, 1, 5, 2]

Expected result: 83
`data`=[1, 2, 3, 5, 5]

Explanation:

`merge_sorted_subarrays` was called four times:
* mergeSortedSubarrays(0, 0, 1)
    * `statistic` += 5 + 5 + 3 (Before the call)
    * `statistic` += 3 + 3 + 5 (After the call)
* mergeSortedSubarrays(0, 1, 2)
    * `statistic` += 3 + 5 + 1 (Before the call)
    * `statistic` += 1 + 3 + 5 (After the call)
* mergeSortedSubarrays(3, 3, 4)
    * `statistic` += 5 + 5 + 2 (Before the call)
    * `statistic` += 2 + 2 + 5 (After the call)
* mergeSortedSubarrays(0, 2, 4)
    * `statistic` += 1 + 5 + 5 (Before the call)
    * `statistic` += 1 + 3 + 5 (After the call)


**Example 3:**

`data`=[5, 3, 6, 2, 1, 7, 3, 2]

Expected result: 153
`data`=[1, 2, 2, 3, 3, 5, 6, 7]


**Example 4:**

`data`=[10, 9, 8, 7, 6, 5, 4, 3, 2, 1]

Expected result: 315
`data`=[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

<br>

Please use the templates `Solution.mergeSortedSubarrays` 
and `Solution.mergeSortAlgorithm` for the implementation.
