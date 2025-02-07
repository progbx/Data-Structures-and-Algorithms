# Queue

## Purpose

The coding exercises are designed to test your knowledge of the following concepts:

* The default `Fifo` interface (the alias to `java.util.Queue` interface from jdk)
* `Fifo` that is implemented using two stacks
* Using the `Fifo` data structure in practice

## Overview

The coding exercises cover the following practical problems:
* Implementing the default `Fifo` interface
* Implementing `Fifo` using two stacks
* Calculating the number of islands in a grid
* Knight traversal


## Coding exercises

### Exercise 1: Implement the default `Fifo` interface

The following snippet contains the default interface, which can be used to implement the `Fifo` data structure. 
Of course, the interface can be expanded with additional methods if necessary.

```java
/**
 * Default interface for Queue data structure
 * @param <E> the type of elements in this data structure
 */
public interface Fifo<E> {

    /**
     * Returns true if the queue is empty.
     * NOTE: O(1) complexity is expected for this operation.
     *
     * @return whether the queue is empty.
     */
    boolean empty();

    /**
     * Returns the number of elements within the queue.
     * NOTE: O(1) complexity is expected for this operation.
     *
     * @return the number of elements within the queue.
     */
    int size();

    /**
     * Adds a given element to the queue's tail.
     * NOTE: O(1) complexity is expected for this operation.
     *
     * @param e element to be added
     * @return the added element.
     */
    E push(E e);

    /**
     * Returns the head element and removes it.
     * NOTE: O(1) complexity is expected for this operation.
     *
     * @return the head element
     * @throws java.util.NoSuchElementException if the queue is empty.
     */
    E pop();

    /**
     * Returns the head element.
     * NOTE: O(1) complexity is expected for this operation.
     *
     * @return the head element
     * @throws java.util.NoSuchElementException if the queue is empty.
     */
    E peek();
```

Your task is to implement the default interface for the `Fifo` above.

## Exercise 2: Implement a queue using two stacks

Your task is to implement a `Fifo` data structure using only two Stacks. 
For this exercise, to the first problem from the stack problem set (`Exercise 1: Implement the default Lifo interface`).


You should use the following template:
```java
/**
 * Fifo implementation with two stacks only
 * NOTE: Lifo interface is defined within stack-task-java project, you may re-use
 * the existing implementation (you should have created it at this point).
 * 
 * @param `<E>` the type of elements in this implementation
 */
public class QueueViaStacks<E> implements Fifo<E> {
    
    //fields shouldn't be changed.
    private Lifo<E> stack1 = new LifoImpl<E>();
    private Lifo<E> stack2 = new LifoImpl<E>();

    /**
     * Returns true if the queue is empty.
     * NOTE: O(1) complexity is expected for this operation.
     *
     * @return whether the queue is empty.
     */
    public boolean empty() {
        return false;
    }

    /**
     * Returns the number of elements within the queue.
     * NOTE: O(1) complexity is expected for this operation.
     *
     * @return the number of elements within the queue.
     */
    public int size() {
        return 0;
    }

    /**
     * Adds a given element to the queue's tail.
     * NOTE: O(1) complexity is expected for this operation.
     *
     * @param e element to be added
     * @return the added element.
     */
    public E push(E e) {
        return null;
    }

    /**
     * Returns the head element and removes it.
     * NOTE: O(1) complexity is expected for this operation.
     *
     * @return the head element
     * @throws java.util.NoSuchElementException if the queue is empty.
     */
    public E pop() {
        return null;
    }

    /**
     * Returns the head element.
     * NOTE: O(1) complexity is expected for this operation.
     *
     * @return the head element
     * @throws java.util.NoSuchElementException if the queue is empty.
     */
    public E peek() {
        return null;
    }
}
```

## Exercise 3: Calculate the number of islands in a grid

Given an `m x n` 2D binary grid `grid` which represents a map of `1`s (land) and `0`s (water), return *the number of islands*.

An **island** is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. Assume all four edges of the grid are surrounded by water.

Your task is implement the following static method to solve the problem above:

```java
/**
 * Returns the number of islands in a given grid.
 *
 * @param grid a map of 1 (land) and 0 (water).
 * @return the number of islands in a given grid.
 */
public static int getIslandsCount(int[][] grid)
        //Hint: you need to go over the grid and 'explore' islands
        //one by one, some sort of BFS (using queue) will do.
```

**Example 1:**

`grid`:
```
000000000
001111100
001101000
001100000
000000000
```

Expected output: 1.

Explanation: there is only one island in the middle.

**Example 2:**

`grid`:
```
000000000
001110000
001100000
001100011
000000011
```

Expected output: 2.

Explanation: there is one island in the middle, and the second one is in the bottom-right corner.


## Exercise 4: Knight traversal

For a given `chessboard` (`8 x 8` cells), you need to determine the minimum number of moves for the knight (character `K`) to reach the destination cell (character `D`). It is guaranteed that the answer exists.

There are four types of cells available:

* `K` - the knight. It is guaranteed that it exists on the board.
* `D` - the destination cell. It is guaranteed that it exists on the board.
* `O` - obstacles. The knight cannot occupy cells with obstacles.
* `.` - empty cells. The knight can occupy these cells.

**Eligible moves**
![alt text](imgs/knight_moves.png "Eligible knight moves")

Your task is to implement the following static method to solve the problem above:

```java
/**
 * Returns the minimum number of knight moves to reach the destination point.
 *
 * @param chessboard a matrix of cells.
 * @return the minimum number of knight moves to reach the destination point.
 */
public static int getMinimumKnightMoves(char[][] chessboard)
```

**Example 1:**

`chessboard`:
```
K.......
........
........
........
........
........
........
.....D..
```

Expected output: 4.

Explanation:
```
K.......
........
.1......
........
..2.....
........
...3....
.....D..
```

**Example 2:**

`chessboard`:
```
K...O...
.....O..
.O..OO..
.O......
...O.O..
O.OOO...
O.......
O....D..
```

Expected output: 6.

Explanation:
```
K...O...
..1..O..
2O..OO..
.O3.....
...O4O..
O.OOO.5.
O.......
O....D..
```

