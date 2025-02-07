# Hash table

## Purpose

The following coding exercises are designed to test your knowledge of the following concepts:

* Hash table data structure and its API
* Resolving collisions using the chaining (bucketing) method

## Overview

The coding exercises cover the following practical problems:
* Implementing a hash table with chaining
* The 2-SUM problem
* Finding repeated patterns in a DNA sequence

## Coding exercises

### Exercise 1: Implement a hash table with chaining

Implement the HashTable class 
**without using any `java.util.Map` implementations**.

The following building blocks are provided for you:

* Assume that the class `KeyValueData` wraps a (key, value) pair.
```java

/**
 * Data that will be stored in hash table.
 * NOTE: no need to change this class.
 * @param <K> type of key
 * @param <V> type of value
 */
public class KeyValueData<K, V> {

    private K key;
    private V value;

    public KeyValueData(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

}
```

* Each chain or bucket of `HashTable` will be handled by the `Bucket` class that has the following API:
```java

/**
 * Represents a set of (K,V) pairs that were assigned to the same bin/chain/bucket.
 * @param <K> type of key
 * @param <V> type of value
 */
public class Bucket<K, V> {

    /**
     * List of KeyValueData in the bucket.
     */
    private List<KeyValueData<K, V>> elements;

    public Bucket() {
        //put your code here
    }


    public List<KeyValueData<K, V>> getElements() {
        return elements;
    }

    /**
     * Searches a value on a given key in the bucket
     * @param key the key for search
     * @return the value for a given key; otherwise null, if no corresponding (K,V) is found.
     */
    public V get(K key) {
        //put your code here
        return null;
    }

    /**
     * Puts a given (K,V) pair into the bucket.
     * @param key the key
     * @param value the value
     */
    public void put(K key, V value) {
        //put your code here
    }

    /**
     * Removes the (K,V) pair for a given key
     * @param key the key
     * @return whether an element for a given key was really removed
     */
    public boolean remove(K key) {
        //put your code here
        return false;
    }

}
```

* Main `HashTable` API:
```java

/**
 * Simple hash table implementation
 * @param <K> type of key
 * @param <V> type of value
 */
public class HashTable<K, V> {

    /**
     * Number of buckets
     */
    private int nBuckets;
    /**
     * Array of buckets
     */
    private Bucket<K, V>[] buckets;

    public Bucket<K, V>[] getBuckets() {
        return buckets;
    }

    /**
     * Initializes fields
     * @param nBuckets number of buckets
     */
    public HashTable(int nBuckets) {
        //put your code here
    }

    public HashTable() {
        this(100);
    }

    /**
     * Here we use the simplest type of hash function.
     * @param key the key
     * @return the number of a bucket
     */
    private int h(K key) {
        return (key.hashCode() % nBuckets + nBuckets) % nBuckets;
    }

    /**
     * @param key the key
     * @return the bucket on a given key
     */
    public Bucket<K,V> getBucket(K key) {
        return buckets[h(key)];
    }

    /**
     * Inserts a given (K,V) pair.
     * NOTE: If the key is already in the hash table, the value should be replaced.
     * @param key the key
     * @param value the value
     */
    public void set(K key, V value) {
        //put your code here
    }

    /**
     * Searches a value on a given key
     * @param key the key for search
     * @return the value for a given key; otherwise null, if no corresponding (K,V) is found.
     */
    public V get(K key) {
        //put your code here
        return null;
    }

    /**
     * Removes the (K,V) pair for a given key
     * @param key the key
     * @return whether an element for a given key was really removed
     */
    public boolean remove(K key) {
        //put your code here
        return false;
    }

}
```

**Example:**

```java
        HashTable<Integer, String> hashTable = new HashTable<>(5);
        hashTable.set(10, "hello2");
        hashTable.set(11, "world");
        hashTable.set(3, "hello3");
        assertEquals(1, hashTable.getBuckets()[0].getElements().size());
        hashTable.set(0, "hello_new");
        assertEquals(2, hashTable.getBuckets()[0].getElements().size());
        assertEquals("hello_new", hashTable.get(0));
        assertTrue(hashTable.remove(0));
        assertFalse(hashTable.remove(0));
```

<br>

Please use the templates `Bucket.java` and `HashTable.java` for the implementation.

### Exercise 2: Find two numbers that add up to a given target

Given a list of integers `values` and an integer `target`, 
return *indices of the two numbers so that they add up to `target`*.

Assume that each input will have **exactly one solution** and you may not use the same element twice.

You can return the answer in any order.

**Constraints**
* 2 <= values.size() <= 3*10^5
* -10^9 <= values.get(i) <= 10^9
* -10^9 <= target <= 10^9
* Only one valid answer exists.

Your task is to implement the following static method to solve the problem above:

```java
    /**
     * Returns a pair of indices so that the corresponding values add up to a given target.
     * @param values available elements for look-up.
     * @param target target sum for look-up.
     * @return two indices of interest; otherwise null, if no pair exists.
     */
    public static Pair findTargetSum(List<Integer> values, int target)
```

The nested class Pair is implemented in the template completely.

**Example 1:**

Input: values = [1, 2, 3, 4, 5], target = 4

Output: `new Pair(0, 2)`

Explanation: values[0] + values[2] == 4


**Example 2:**

Input: values = [1, 2, 3, 4, 5], target = 8

Output: `new Pair(2, 4)`

Explanation: values[2] + values[4] == 8

<br>

Please use the template `Solution.findTargetSum()` for the implementation.

### Exercise 3: Repeated DNA Sequences

A **DNA sequence** is composed of a series of nucleotides abbreviated `'A'`, `'C'`, `'G'`, and `'T'`.

For example, `"ACGAATTCCG"` is a DNA sequence.
When studying **DNA**, it is useful to identify repeated sequences within the DNA.

Given a string `dnaSequence` that represents a **DNA sequence**, 
return all the `8`**-letter-long** sequences (substrings) 
that occur more than once in a DNA molecule. 
You may return the answer in **any order**.

**Constraints**
* 1 <= dnaSequence.size() <= 10^5
* dnaSequence contains only 'A', 'C', 'G' and 'T' characters.

Your task is to implement the following static method to solve the problem above:

```java
    /**
 * Returns all 8-letter-long substrings that occur more than once.
 * @param dnaSequence a given DNA sequence.
 * @return set of all 8-letter-long substrings that occur more than once.
 */
public static Set<String> findRepeatedDnaSequences(String dnaSequence)
```

**Example 1**

Input: dnaSequence="AAAATTTTAAAATTTT"

Output: ["AAAATTTT"]


**Example 2**

Input: dnaSequence="ATATATATATA"

Output: ["ATATATAT", "TATATATA"]

<br>

Please use the template `Solution.findRepeatedDnaSequences` for the implementation.
