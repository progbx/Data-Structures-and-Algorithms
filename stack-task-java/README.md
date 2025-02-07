# Stack

## Purpose

The coding exercises are designed to test your knowledge of the following concepts:

* The default `Lifo` interface (the alias to `java.util.Stack` class from jdk) 
* Adjusting the `Lifo` data structure to support more complex operations
* Using the `Lifo` data structure in practice

## Overview

The coding exercises cover the following practical problems:
* Implementing the default `Lifo` interface
* Validating expressions in parentheses
* Adjusting `Lifo` to support the `getMinimum` operation
* Reverse Polish notation (RPN) parsing

## Coding exercises

### Exercise 1: Implement the default `Lifo` interface

The following snippet contains the default interface for implementing the `Lifo` data structure. Of course the interface can be expanded with additional methods if necessary.

```java
/**
 * Default interface for Stack data structure
 * @param `<E>` the type of elements in this data structure
 */
public interface Lifo<E> {
    /**
     * Returns true if the stack is empty.
     * NOTE: O(1) complexity is expected for this operation.
     *
     * @return whether the stack is empty.
     */
    boolean empty();

    /**
     * Returns the number of elements within the stack.
     * NOTE: O(1) complexity is expected for this operation.
     *
     * @return the number of elements within the stack.
     */
    int size();

    /**
     * Adds a given element to the top of the stack.
     * NOTE: O(1) complexity is expected for this operation.
     *
     * @param e element to be added
     * @return the added element.
     */
    E push(E e);

    /**
     * Returns the top element and removes it.
     * NOTE: O(1) complexity is expected for this operation.
     *
     * @return the top element
     * @throws IllegalStateException if the stack is empty.
     */
    E pop();

    /**
     * Returns the top element.
     * NOTE: O(1) complexity is expected for this operation.
     *
     * @return the top element
     * @throws IllegalStateException if the stack is empty.
     */
    E peek();

}
```

Your task is to implement the provided default interface for the Lifo data structure above.


## Exercise 2: Check whether a given parentheses expression is valid

Given a string `s` containing only the characters `"("`, `")"`, `"{"`, `"}"`, `"["` and `"]"`, determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.


Your task is implement the following static method to solve the problem above:

```java
/**
 * Returns true if a given string is valid parentheses expression.
 *
 * @param expression input string for validation.
 * @return whether a given string is valid parentheses expression.
 */
public static boolean isValidParentheses(String expression)
```

**Example 1:**

`s = "()"`

Expected output: `true`.

**Example 2:**

`s = "()[]{}"`

Expected output: `true`.

**Example 3:**

`s = "([})"`

Expected output: `false`.

## Exercise 3: A stack with the `getMinimum` operation

Your task is to extend the default interface for `Lifo` data structure and add the `getMinimum` method:

```java
/**
 * Extended `Lifo` interface that supports `getMinimum` operation.
 * @param `<E>` the type of elements in this list that implements the interface `Comparable<E>`
 */
public interface LifoWithMinimum<E extends Comparable<E>> extends Lifo<E> {

    /**
     * Returns the minimum element in the stack.
     * NOTE: O(1) complexity is expected for this operation.
     *
     * @return the minimum element in the stack.
     */
    Optional<E> getMinimum();

}
```

**Example:**

```java
        LifoWithMinimum<Integer> lifoInt = new LifoWithMinimumImpl<>();
        lifoInt.push(3);    //3
        lifoInt.push(2);    //3, 2
        lifoInt.push(4);    //3, 2, 4
        assertEquals(2, lifoInt.getMinimum());

        lifoInt.push(5);    //3, 2, 4, 5
        lifoInt.push(1);    //3, 2, 4, 5, 1
        assertEquals(1, lifoInt.getMinimum());

        lifoInt.pop();      //3, 2, 4, 5
        lifoInt.pop();      //3, 2, 4
        assertEquals(2, lifoInt.getMinimum());
```


## Exercise 4: RPN parsing

Your task is to evaluate the value of an arithmetic expression in [RPN](https://en.wikipedia.org/wiki/Reverse_Polish_notation).

Valid operators are `+`, `-`, `*`, and `/`. Each operand may be an integer or another expression.

It is guaranteed that the given RPN expression is always valid. This means the expression will always evaluate to a result and there will never be any division by zero operation.

You are provided with the following template for the implementation:

```java
/**
 * Returns the evaluation result of a given list of RPN tokens.
 *
 * @param rpnTokens a list of RPN tokens
 * @return the evaluation result
 */
public static int evaluateRpnTokens(String[] rpnTokens)
```


**Example 1:**

`tokens` = {"3", "2", "+", "10", "*"}

Expected output: 50.

Explanation: `(3 + 2) * 10 = 50`

**Example 2:**

`tokens` = {"10", "4", "-", "2", "*", "4", "/"}

Expected output: 2.

Explanation: `((10 - 4) * 2) / 5 = 2`
