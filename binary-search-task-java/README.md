# Binary Search

## Purpose

The coding exercises are designed to test your knowledge of the following concept:

* Binary search

## Overview

The coding exercises cover the following practical problems:
* Guessing a secret number
* Finding the minimum time to produce a given amount of product
* Finding the number of elements in an array in a given interval

## Coding exercises

### Exercise 1: Guess a secret number

Suppose you have a black box:

```java
/**
 * Mysterious class.
 */
class BlackBox implements Function<Integer, Integer> {
    private int secretNumber;   //a number to guess

    public BlackBox(int secretNumber) {
        this.secretNumber = secretNumber;
    }

    /**
     * @param value a given guess
     * @return the result of evaluation of the given guess
     */
    @Override
    public Integer apply(Integer value) {
        if (secretNumber == value) {
            return 0;
        }
        if (secretNumber > value) {
            return -1;
        }
        return 1;
    }
}
```

As you can see, a black box has the method `apply`, which accepts and evaluates guesses:
* it returns `0` if you guess correctly (in this case, your job is done)
* it returns `-1` if your guess is too low
* it returns `1` if your guess is too high

Your task is to implement the following static method, which guesses a secret number in a black box:

```java
/**
 * Returns the secret number based on a given black box.
 * the secret number lies in the [left_bound, right_bound] interval
 * you interact with a given black box to guess the secret number
 * the only assumption you can have about a black box is that is has a `apply` method
 * don't try to guess in which attribute the secret number is stored within a given black box ;)
 * trying all the numbers in [left_bound, right_bound] will be too slow to pass the hidden tests
 * 
 * @param leftBound the left bound while guessing
 * @param rightBound the right bound while guessing
 * @param blackBox some object with a `apply` method available
 * @return the secret number
 */
public static int guessNumber(int leftBound, int rightBound, Function<Integer, Integer> blackBox)
```

**Example 1:**

`secretNumber`=5

`leftBound`=1

`rightBound`=10

Expected result:

`blackBox.apply(10)` // 1

`blackBox.apply(3)` // -1

`blackBox.apply(10)` // -1

`blackBox.apply(9)` // 1

`blackBox.apply(5)` // 0 - Wow, you guessed correctly!


**Example 2:**

`secretNumber`=9

`leftBound`=1

`rightBound`=10

Expected result:

`blackBox.apply(10)` // 1

`blackBox.apply(3)` // -1

`blackBox.apply(1)` // -1

`blackBox.apply(5)` // -1

`blackBox.apply(9)` // 0 - Wow, you guessed correctly!

<br>


### Exercise 2: Find the minimum time to produce a given amount of product

Suppose there are `N` factories. Each factory produces one ton of product per $c_i$ hours. The target amount of product is `P`, and you want to know the minimum number of hours required to produce at least `P` tons of product.

Your task is to implement the following static method, which calculates the minimum number of hours to produce enough product:

```java
/**
 * Returns the minimum number of hours required to produce `target_amount` of product.
 * NOTE: it is guaranteed that result won't exceed 10^12 hours.
 * @param capacities capacities of factories, number of hours 
 * required for a given factory to produce 1 ton of product
 * @param targetAmount the target amount of product
 * @return the minimum number of hours required
 */
public static int getRequiredTime(List<Integer> capacities, int targetAmount)
```


**Example 1:**

`capacities`=[2, 4, 3]

`targetAmount`=10

Expected result: 9

Explanation:
* after 1 hour, `0` tons of product will be produced (0 + 0 + 0)
* after 2 hours, `1` ton of product will be produced (1 + 0 + 0)
* after 3 hours, `2` tons of product will be produced (1 + 0 + 1)
* after 4 hours, `4` tons of product will be produced (2 + 1 + 1)
* after 5 hours, `4` tons of product will be produced (2 + 1 + 1)
* after 6 hours, `6` tons of product will be produced (3 + 1 + 2)
* after 7 hours, `6` tons of product will be produced (3 + 1 + 2)
* after 8 hours, `8` tons of product will be produced (4 + 2 + 2)
* after 9 hours, `9` tons of product will be produced (4 + 2 + 3)
* after 10 hours, `10` tons of product will be produced (5 + 2 + 3)

**Example 2:**

`capacities`=[1, 1, 3, 5]

`targetAmount`=11

Expected result: 5

Explanation:
* after 1 hour, `2` tons of product will be produced (1 + 1 + 0 + 0)
* after 2 hours, `4` ton of product will be produced (2 + 2 + 0 + 0)
* after 3 hours, `7` tons of product will be produced (3 + 3 + 1 + 0)
* after 4 hours, `9` tons of product will be produced (4 + 4 + 1 + 0)
* after 5 hours, `12` tons of product will be produced (5 + 5 + 1 + 1)

<br>


### Exercise 3: Find the number of an array's elements in a given interval

Your task is to implement the following static method, which handles queries for a given sorted array:

```java
class Pair {
    private int left;   //left bound
    private int right;  //right bound
}

/**
 * Returns answers for a given list of queries.
 * Each query is represented by an instance of `Pair`.
 * The answer for a given query is the number of elements in a given array with values the interval [left, right].
 * NOTE: the expected time complexity per query is O(log N), where N=|array|.
 * NOTE: the expected time complexity is O(Q * log N), where Q=|queries|.
 * 
 * @param array a given sorted array
 * @param queries a given list of queries
 * @return the answers that correspond to a given list of queries
 */
public static List<Integer> processQueries(List<Integer> array, List<Pair> queries)
```

**Example 1:**

`array`=[0, 1, 2, 4, 6, 1000]

`queries=`=[(-100, 3), (5, 5), (1, 4)]

Expected result: [3, 0, 3]

Explanation:
* `(-100, 3)` - the numbers [0, 1, 2] are in the interval
* `(5, 5)` - no numbers are in the interval
* `(1, 4)` - the numbers [1, 2, 4] are in the interval


**Example 2:**

`array`=[0, 0, 1, 1, 2]

`queries=`=[(0, 1), (1, 2), (-5, 10)]

Expected result: [4, 3, 5]

Explanation:
* `(0, 1)` - the numbers [0, 0, 1, 1] are in the interval
* `(1, 2)` - the numbers [1, 1, 2] are in the interval
* `(-5, 10)` - the numbers [0, 0, 1, 1, 2] are in the interval

