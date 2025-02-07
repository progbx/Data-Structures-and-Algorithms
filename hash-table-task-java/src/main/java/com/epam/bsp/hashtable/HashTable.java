package com.epam.bsp.hashtable;

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
