# Priority Queue. The Heap sort algorithm

## Purpose

The coding exercises are designed to test your knowledge of the following concepts:

* The priority queue data structure as an API on top of a heap
* The heap sort algorithm

## Overview

The coding exercises cover the following practical problems:
* Implementing a basic priority queue API
* Implementing the heap sort algorithm
* Supporting an infinite set with the `popMinimum` and `insert` operations


## Coding exercises

### Exercise 1: Implement a basic priority queue API

Your task is to implement the following class, which provides the basic `Priority Queue API`:

```java
/**
 * Basic data structure for custom Priority Queue representation
 */
public class CustomPriorityQueue<E extends Comparable<E>> {

    //field(s)
    //put your code here

    public CustomPriorityQueue() {
        //put your code here
    }

    /**
     * Returns the minimum in the data structure.
     * NOTE: the expected time complexity is O(1).
     *
     * @return the minimum in the data structure.
     */
    public E getMinimum() {
        //put your code here
        return null;
    }

    /**
     * Returns the minimum in the data structure and removes it.
     * NOTE: the expected time complexity is O(log N),
     * where N is the number of elements in the data structure.
     *
     * @return the minimum in the data structure
     */
    public E pop() {
        //put your code here
        return null;
    }

    /**
     * Inserts a given value into the data structure.
     * NOTE: the expected time complexity is O(log N),
     * where N is the number of elements in the data structure.
     *
     * @param value the given value into the data structure.
     */
    public void insert(E value) {
        //put your code here
    }

    /**
     * Returns true if there are no elements in the data structure.
     * NOTE: the expected time complexity is O(1).
     *
     * @return whether there are no elements in the data structure.
     */
    public boolean isEmpty() {
        //put your code here
        return false;
    }

    /**
     * Returns the number of elements in the data structure.
     * NOTE: the expected time complexity is O(1).
     *
     * @return the number of elements in the data structure.
     */
    public int size() {
        //put your code here
        return 0;
    }
}
```


**Example 1:**

```java
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>();

        assertTrue(pq.isEmpty());

        pq.insert(4);   //[4]
        pq.insert(3);   //[3, 4]
        pq.insert(2);   //[2, 3, 4]
        assertEquals(3, pq.size());

        assertEquals(2, pq.pop());  //[3, 4]
        assertEquals(3, pq.getMinimum());

        pq.insert(1);   //[1, 3, 4]
        assertEquals(1, pq.getMinimum());
```

**Example 2:**

```java
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>();
        pq.insert(1);   //[1, 2]
        pq.insert(2);   //[1, 2]
        pq.insert(3);   //[1, 2, 3]
        pq.insert(4);   //[1, 2, 3, 4]
        pq.insert(5);   //[1, 2, 3, 4, 5]

        assertEquals(1, pq.pop());  //[2, 3, 4, 5]
        assertEquals(2, pq.pop());  //[3, 4, 5]
        assertEquals(3, pq.pop());  //[4, 5]
        assertEquals(4, pq.pop());  //[5]
        assertEquals(5, pq.pop());  //[]

        assertTrue(pq.isEmpty());
```

**Example 3:**

```java
        CustomPriorityQueue<String> strpq = new CustomPriorityQueue<>();
        strpq.insert("4");   //["4"]
        strpq.insert("3");   //["3", "4"]
        strpq.insert("2");   //["2", "3", "4"]
        assertEquals(3, strpq.size());

        assertEquals("2", strpq.pop());  //["3", "4"]
        assertEquals("3", strpq.getMinimum());

        strpq.insert("1");   //["1", "3", "4"]
        assertEquals("1", strpq.getMinimum());
```

<br>

Please use the template `CustomPriorityQueue` for the implementation.

### Exercise 2: Implement the heap sort algorithm

Your task is to implement the following methods that, when combined, 
are `the Heap sort algorithm` itself:

```java
/**
 * Sorts a given array in ascending order using the heap sort algorithm.
 * The idea is simple:
 * 1) First, use the `minHeapify` to get a heap
 * 2) Then, iteratively execute the `popMinimum` method (almost as in PriorityQueue.pop method) to create an ordered array
 *
 * NOTE: the expected time complexity is O(N * log N), where N=data.length
 * @param data a given array to sort
 * @return the ordered array
 */
public static int[] heapSort(int[] data) {
        return new int[0];
}

/**
 * Returns the result of running the `heapify` (minimum) operation on a given array list of numbers.
 *
 * What we know about the `heapify` operation:
 * 1) The expected time complexity of this operation is O(n), where n=data.size()
 * 2) Here we're considering the "minimum" variation of `heapify`, so for the resulting array list,
 *     the following conditions should hold (let's call the result array list h):
 *         a) h.get(i) <= h.get(2 * i + 1), if 2 * i + 1 < n
 *         b) h.get(i) <= h.get(2 * i + 2), if 2 * i + 2 < n
 *
 * Basically the resulting array list can be used as a base for the heap.
 *
 * @param data a given array list of numbers to `heapify`
 * @return the result of running the `heapify` (minimum) operation on a given array list of numbers.
 */
public static List<Integer> minHeapify(List<Integer> data) {
        return List.of();
}
```

**NOTE**:
* The basic idea of how to implement `minHeapify` is described [here](https://www.baeldung.com/cs/binary-tree-max-heapify). You just need to adjust it for the *minimum* case.


**Example 1:**

`data`=[6, 4, 2, 1, 6, 3]

Expected result:

`minHeapify(data)`=[1, 3, 2, 6, 6, 4]  # One of the available options

`heapSort(data)`=[1, 2, 3, 4, 6, 6]


**Example 2:**

`data`=[1000, 100, 1, 10]

Expected result:

`minHeapify(data)`=[1, 10, 1000, 100]  # One of the available options

`heapSort(data)`=[1, 10, 100, 1000]

<br>

Please use the templates `Solution.minHeapify` and `Solution.heapSort` for the implementation.


### Exercise 3: An infinite set of natural numbers

Suppose you possess all the natural numbers out there: 1, 2, 3, 4, 5, ...

As the owner, you need to support the following operations:
* `popMinimum()` - You give us the minimum number that you have.
* `insert(x)` - When we are finished playing with the number `x` (which you gave us before), we decide to give it back to you. It is guaranteed that you don't have `x` at that moment.

Your task is to implement the following class, which supports these operations for you:

```java
/**
 * Emulates a set of all natural numbers.
 */
public class InfiniteSet {

    //field(s)
    //put your code here

    public InfiniteSet() {
        //put your code here
    }

    /**
     * Returns the minimum natural number available and removes it from the set.
     * NOTE: the expected complexity is O(log K),
     * where K is the total number of `popMinimum/insert` calls done previously.
     *
     * @return the minimum natural number available
     */
    public int popMinimum() {
        //put your code here
        return 0;
    }

    /**
     * Inserts a given number back into the set.
     * NOTE: the expected complexity is O(log K),
     * where K is the total number of `popMinimum/insert` calls done previously.
     *
     * @param x the given number to insert back into the set.
     */
    public void insert(int x) {
        //put your code here
    }
}
```

**Example 1:**

```java
        InfiniteSet infSet = new InfiniteSet();  //[1, 2, 3, 4, 5, ...]
        assertEquals(1, infSet.popMinimum());  //[2, 3, 4, 5, 6, ...]
        assertEquals(2, infSet.popMinimum());  //[3, 4, 5, 6, ...]
        assertEquals(3, infSet.popMinimum());  //[4, 5, 6, ...]
        assertEquals(4, infSet.popMinimum());  //[5, 6, 7, ...]
        assertEquals(5, infSet.popMinimum());  //[6, 7, 8, ...]

        infSet.insert(3);   //[3, 6, 7, ...]
        infSet.insert(1);   //[1, 3, 6, 7, ...]

        assertEquals(1, infSet.popMinimum());  //[3, 6, 7, ...]
        assertEquals(3, infSet.popMinimum());  //[6, 7, 8, ...]
        assertEquals(6, infSet.popMinimum());  //[7, 8, 9, ...]
```


**Example 2:**

```java
        InfiniteSet infSet = new InfiniteSet();         //[1, 2, 3, 4, 5, ...]

        //...
        //After 100 popMinimum() operations
        assertEquals(101, infSet.popMinimum());    //[102, 103, 104, ...]
        infSet.insert(35);   //[35, 102, 103, ...]
        infSet.insert(23);   //[23, 35, 102, 103, ...]

        assertEquals(23, infSet.popMinimum());    //[35, 102, 103, 104, ...]
        assertEquals(35, infSet.popMinimum());    //[102, 103, 104, ...]
        assertEquals(102, infSet.popMinimum());    //[103, 104, ...]
```


<br>

Please use the template `InfiniteSet` for the implementation.

