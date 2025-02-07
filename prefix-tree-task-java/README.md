# Prefix Tree (Trie)

## Purpose

The coding exercises are designed to test your knowledge of the following concepts:

* Prefix tree data structure
* Data structure augmentation

## Overview

The coding exercises cover the following practical problems:
* Implementing a basic version of a prefix tree
* Augmenting a prefix tree to support more complex operations
* Using a prefix tree to match strings

## Coding exercises

### Exercise 1: Basic version of Prefix Tree

Each node in a prefix tree should contain at least two things:
* some indication of whether the node corresponds to a string from the corpus (strings that were previously inserted)
* a mapping from characters to the corresponding prefix tree nodes

Consider the following class, which represents a prefix tree node:
```java
public class PrefixTreeNode {
   private Map<Character, PrefixTreeNode> children;
   private boolean terminal;
   // you may add additional field(s) if needed

   public PrefixTreeNode(boolean terminal) {
      this.children = new HashMap<>();
      this.terminal = terminal;
   }

   //add needed methods here

}
```

Your task is to implement the following class for supporting basic prefix tree operations:

```java
public class PrefixTree {
   public PrefixTreeNode rootNode;

   public PrefixTree() {
       this.rootNode = new PrefixTreeNode(false);
   }

   /**
    * Inserts a given string into the prefix tree.
    *
    * NOTE: the expected complexity is O(|s|), assuming HashMap operations have a complexity of O(1).
    *
    * @param s a given string for insertion.
    */
   public void insert(String s) {
       // put your code here
   }

   /**
    * Returns whether a given string is in the prefix tree (was inserted before).
    *
    * NOTE: the expected complexity is O(|s|), assuming HashMap operations have a complexity of O(1).
    *
    * @param s a given string for look-up.
    * @return whether a given string is in the prefix tree.
    */
   public boolean search(String s) {
       // put your code here
       return false;
   }

   /**
    * Returns whether there is a string in the prefix tree with the prefix equal to a given string.
    *
    * NOTE: the expected complexity is O(|s|), assuming HashMap operations have a complexity of O(1).
    *
    * @param s a given string (prefix) for look-up.
    * @return whether there is a string in the prefix tree that starts with a given string.
    */
   public boolean startsWith(String s) {
       // put your code here
       return false;
   }
}
```


**Example:**

Setup:
```java
PrefixTree pt = new PrefixTree();
pt.insert("aba");
pt.insert("aba");   // NOTE: duplicate strings are allowed
pt.insert("abab");
pt.insert("caba");
```

Queries:
```java
pt.search("a");             // false is expected
pt.search("ab");            // false is expected
pt.search("aba");           // true is expected
pt.search("abab");          // true is expected
pt.search("caba");          // true is expected
pt.search("cabacaba");      // false is expected

pt.starts_with("a");        // true is expected
pt.starts_with("ab");       // true is expected
pt.starts_with("aba");      // true is expected
pt.starts_with("abab");     // true is expected
pt.starts_with("caba");     // true is expected
pt.starts_with("cabacaba"); // false is expected
```

<br>

Please use the templates `PrefixTreeNode` and `PrefixTree` for the implementation.

### Exercise 2: Augment the basic Prefix Tree to support more complex operations

[Data structures augmentation](https://users.cs.fiu.edu/~giri/teach/UoM/7713/f98/lec3.html)

Basically, the process of augmenting a data structure consists of the following steps:
1. Choose an underlying data structure
   * We will use a basic prefix tree.
2. Determine additional information to be maintained in the underlying data structure
   * You need to understand what additional information needs to be stored to support new operations.
3. Verify whether the augmentation is feasible
   * Yes, it is. Trust us.
4. Implementation... Profit!

In this coding exercise, you will change the basic prefix tree data structure to support of more complex operations, like counting the number of words in the corpus (previously inserted words) that match a given string (prefix).

Take a look at the following class to be implemented:
```java
/**
 * NOTE: this class extends the superclass, so the basic operations should be supported:
 * - insert
 * - search
 * - startsWith
 * You may or may not override corresponding methods.
 *
 * In case you need to make changes in the `PrefixTreeNode` class, feel free to either
 *   create an additional class like `AugmentedPrefixTreeNode` or just add some additional
 *   attributes to the class.
 */
public class AugmentedPrefixTree extends PrefixTree {

   //put here field(s), constructor(s) if you need them

   //put here the code of `insert`, `search`, `startsWith` methods if you need to override them

   /**
    * Returns the number of strings in the prefix tree that are equal to a given string.
    *
    * NOTE: the expected complexity is O(|s|), assuming HashMap operations have a complexity of O(1).
    *
    * @param s a given string for look-up.
    * @return the number of strings in the prefix tree that are equal to a given string.
    */
   public int countWordsEqualTo(String s) {
       // put your code here
       return 0;
   }

   /**
    * Returns the number of strings in the prefix tree that start with a given string (prefix).
    *
    * NOTE: the expected complexity is O(|s|), assuming HashMap operations have a complexity of O(1).
    *
    * @param s a given string for look-up.
    * @return the number of strings in the prefix tree that start with a given string.
    */
   public int countWordsStartingWith(String s) {
       // put your code here
       return 0;
   }
}
```

**Example:**

Setup:
```java
AugmentedPrefixTree apt = AugmentedPrefixTree();
apt.insert("aba");
apt.insert("aba");
apt.insert("aba");
apt.insert("abab");
apt.insert("ababad");
apt.insert("caba");
```

Queries:
```java
// The basic operations should still work correctly.
apt.search("a");                // false is expected
apt.search("ab");               // false is expected
apt.search("aba");              // true is expected
apt.search("abab");             // true is expected
apt.search("caba");             // true is expected
apt.search("cabacaba");         // false is expected

apt.starts_with("a");           // true is expected
apt.starts_with("ab");          // true is expected
apt.starts_with("aba");         // true is expected
apt.starts_with("abab");        // true is expected
apt.starts_with("caba");        // true is expected
apt.starts_with("cabacaba");    // false is expected

// The new operations.
apt.count_words_equal_to("aba");        // 3
apt.count_words_equal_to("ab");         // 0
apt.count_words_equal_to("abab");       // 1
apt.count_words_equal_to("cabacaba");   // 0

apt.count_words_starting_with("");      // 6
apt.count_words_starting_with("a");     // 5
apt.count_words_starting_with("ab");    // 5
apt.count_words_starting_with("aba");   // 5
apt.count_words_starting_with("abab");  // 2
apt.count_words_starting_with("ababa"); // 1
apt.count_words_starting_with("c");     // 1
```

<br>

Please use the template `AugmentedPrefixTree` for the implementation.

### Exercise 3: Use Prefix Tree for string matching

Given a string `s` and an array of `patterns`. 
Your task is to implement the following static method 
to calculate the total number of times `patterns_i` match some substring in `s`:

```java
/**
 * Returns the number of times all given patterns occur in a given string.
 *
 * NOTE: If there are duplicates within the given patterns, each one should be counted.
 *
 * NOTE: You probably need to use trie somehow...
 *
 * NOTE: |text| >> max(|patterns_i|)
 *
 * NOTE: The expected complexity looks like O(|text| * ...) - linear in terms of the length of a given string.
 *
 * @param text a given string for matching.
 * @param patterns a given array of patterns for matching.
 * @return the number of times all given patterns occur in a given string.
 */
public static int getNumberOfMatches(String text, String[] patterns)
```

**Example 1:**

`text`="abracadabra"

`patterns`=["a", "a", "abra", "ca"]

Expected output: 13

Explanation:

* "a" occurs 5 times
* "a" occurs 5 times
* "abra" occurs 2 times
* "ca" occurs 1 time

**Example 2:**

`text`="hello world"

`patterns`=["hell", "l", "l", "o"]

Expected output: 9

Explanation:

* "hell" occurs 1 time
* "l" occurs 3 times
* "l" occurs 3 times
* "o" occurs 2 times

**Example 3:**

`text`="Tomatoes make great weapons when water balloons aren’t available."

`patterns`=["at", "ma", "great weapons"]

Expected output: 6

Explanation:

* "at" occurs 3 times
* "ma" occurs 2 times
* "great weapons" occurs 1 time

<br>

Please use the template `Solution.getNumberOfMatches` for the implementation.
