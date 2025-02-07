# The Rabin-Karp Algorithm for string matching

## Purpose

The coding exercises are designed to test knowledge of the following concepts:

* Polynomial rolling hashing
* The Rabin-Karp algorithm for matching strings

## Overview

The coding exercises cover the following practical problems:
* Implementing an API for calculating a polynomial rolling hash
* Implementing the Rabin-Karp algorithm

## Coding exercises

### Exercise 1: Rolling hashing API

Your task is to implement a data structure that provides rolling hash capabilities on top of a given string. 

The following code snippet defines an interface for the target data structure:

```java
public class RollingHash {
    // a text that will be used for rolling hashing
    public String text;
    // a base value for polynomial hashing (P)
    public int hashBase;
    // a modulo that should be used for hashing (M)
    public int hashModulo;

    public RollingHash(String text, int hashBase, int hashModulo) {
        this.text = text;
        this.hashBase = hashBase;
        this.hashModulo = hashModulo;
    }

    /**
     * Returns a polynomial hash value for a given substring.
     * 
     * H(L, R) = ( ord(text[L]) * P^(R-L) + ... + ord(text[R]) ) % M
     * 
     * NOTE: ord(ch) <=> (int) ch
     * 
     * @param leftIndex the left index of the target substring.
     * @param rightIndex the right index of the target substring.
     * @return the value of polynomial hash function for the given substring
     */
    public int getHash(int leftIndex, int rightIndex) {
        // put your code here
        return 0;
    }
}
```

**Example**

`hashBase` = 3

`hashModulo` = 31

`text` = "hello"

H(0, 1) = (3 * ord('h') + ord('e') ) % 31 = (3 * 104 + 101) % 31 = 10

H(0, 2) = (3^2 * ord('h') + 3 * ord('e') + ord('l') ) % 31 = (3^2 * 104 + 3 * 101 + 108) % 31 = 14

H(2, 4) = (3^2 * ord('l') + 3 * ord('l') + ord('o') ) % 31 = 12

<br>

Please use the template `RollingHash` for the implementation.


### Exercise 2: The Rabin-Karp algorithm

Your task is to implement the following static method for matching strings using `the Rabin-Karp algorithm`:

```java
/**
 * Returns all positions within a text where a given pattern occurs.
 *
 * NOTE: Please use the Rabin-Karp algorithm.
 * 
 * NOTE: The parameter `deterministic` defines whether hash value hits 
 *   should be checked explicitly or whether false positive matches are fine.
 * 
 * @param text the text to be searched.
 * @param pattern the pattern to search for.
 * @param hashBase the base value for polynomial hashing (P).
 * @param hashModulo the modulo that will be used for hashing (M).
 * @param deterministic whether hash value hits should be checked explicitly.
 * @return all indices in the text where the pattern occurs.
 */
public static List<Integer> findOccurrencesViaRabinKarp(
        String text,
        String pattern,
        int hashBase,
        int hashModulo,
        boolean deterministic
) {
        //put your code here
        return List.of();
}
```

**Example 1**

`text`="hello world"

`pattern`="o"

`hashBase`=3

`hashModulo`=31

`deterministic`=true

Expected result: [4, 7]

**Example 2**

`text`="hello world"

`pattern`="o"

`hashBase`=3

`hashModulo`=2

`deterministic`=false

Expected result: [1, 4, 6, 7]

Explanation:

H("o") = 1 // Target hash

H("hello world", 1, 1) = 1

H("hello world", 4, 4) = 1

H("hello world", 6, 6) = 1

H("hello world", 7, 7) = 1

**NOTE:** As you can see, poor choices of both **P** and **M** can result in quite a few false positive matches in nondeterministic mode. 
However in practice this works quite well if hashing parameters are defined wisely.

<br>

Please use the template `Solution.findOccurrencesViaRabinKarp` for the implementation.
