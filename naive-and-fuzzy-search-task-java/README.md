# Naive string matching and fuzzy search

## Purpose

The following coding exercises are designed to test your knowledge of the following concepts:

* The naive string-matching algorithm
* The Levenshtein distance
* Fuzzy search

## Overview

The coding exercises cover the following practical problems:
* Implementing the naive string-matching algorithm
* Implementing the Levenshtein distance
* Implementing a simple fuzzy search engine on top of the Levenshtein distance

## Coding exercises

### Exercise 1: The Naive string matching algorithm

Your task is to implement the following static method for string-matching using the naive algorithm:

```java
/**
 * Returns all positions within a given text where a given pattern occurs.
 *
 * NOTE: Nothing fancy is expected here, you can just use the naive algorithm.
 *
 * @param text a given text for searching.
 * @param pattern a given pattern for searching.
 * @return all indices in the text where the pattern occurs.
 */
public static List<Integer> findOccurrences(String text, String pattern)
```

**Example 1:**

`text`="abababa"

`pattern`="aba"

Expected result: [0, 2, 4]

Explanation:

**aba**baba - 1st match.

ab**aba**ba - 2nd match.

abab**aba** - 3rd match.

**Example 2:**

`text`="question"

`pattern`="answer"

Expected result: []

**Example 3:**

`text`="Who’s there? Figs. Figs who? Figs the doorbell; it's not working!"

`pattern`="Figs"

Expected result: [13, 19, 29]

<br>

Please use the template `Solution.findOccurrences` for the implementation.

### Exercise 2: The Levenshtein distance

Your task is to implement the following static method to calculate the Levenshtein distance between two strings:

```java
/**
 * Returns the Levenshtein distance between two strings.
 *
 * @param a the first string.
 * @param b the second string.
 * @return the Levenshtein distance between the given strings.
 */
public static int findLevenshteinDistance(String a, String b)
```

**Example 1:**

`a`="property"

`b`="attribute"

Expected result: 8

**Example 2:**

`a`="maximization"

`b`="minimization"

Expected result: 2

**Example 3:**

`a`="confusion"

`b`="induction"

Expected result: 5

<br>

Please use the template `Solution.findLevenshteinDistance` for the implementation.

### Exercise 3: Basic FuzzySearch Engine

Your task is to implement the following class for a basic fuzzy search engine:

```java
public class FuzzySearchEngine {
    public List<String> corpus;

    public FuzzySearchEngine(List<String> corpus) {
        this.corpus = corpus;
    }

    /**
     * Returns the most similar texts from the corpus based on a query text.
     *
     * NOTE: Please use the Levenshtein distance to measure the similarity between strings.
     *
     * NOTE: If there are multiple texts with the same Levenshtein distance for the query text
     *   within the corpus, order the results lexicographically.
     *
     * NOTE: If the corpus contains less than 'nResults' texts, please return all the available ones.
     *
     * @param queryText a query text that should be used to retrieve texts from the corpus.
     * @param nResults the number of texts that should be returned (the most similar ones).
     * @return the best matches from the corpus.
     */
    public List<String> findBestMatches(String queryText, int nResults) {
        return List.of();
    }

}
```

For the examples below the following `corpus` will be used:

* "refund"
* "spy"
* "retailer"
* "concede"
* "dozen"

**Example 1**

`queryText` = "recruit"

`nResults` = 3

Expected result: ["refund", "retailer", "concede"]

Explanation:

Levenshtein_Distance ("refund", "recruit") = 4 // The closest

Levenshtein_Distance ("spy", "recruit") = 7

Levenshtein_Distance ("retailer", "recruit") = 6 // The second closest

Levenshtein_Distance ("concede", "recruit") = 7 // Lexicographically smallest among other texts

Levenshtein_Distance ("dozen", "recruit") = 7



**Example 2**

`queryText` = "button"

`nResults` = 3

Expected result: ["dozen", "refund", "spy"]

Explanation:

Levenshtein_Distance ("refund", "button") = 6 // The second one "refund" < "spy"

Levenshtein_Distance ("spy", "button") = 6 // The third one

Levenshtein_Distance ("retailer", "button") = 7

Levenshtein_Distance ("concede", "button") = 7

Levenshtein_Distance ("dozen", "button") = 5 // The closest


<br>

Please use the template `FuzzySearchEngine` for the implementation.
