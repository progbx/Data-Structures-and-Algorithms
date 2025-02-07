package com.epam.bsp.hashtable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {

//    @Test
//    public void testBucket() {
//        Bucket<Integer, String> bucket = new Bucket<>();
//        bucket.put(0, "hello");
//        bucket.put(1, "world");
//        bucket.put(235134, "hell0, world!");
//        assertEquals(3, bucket.getElements().size());
//
//        assertNull(bucket.get(107));
//        assertEquals("hello", bucket.get(0));
//
//        assertTrue(bucket.remove(0));
//        assertNull(bucket.get(0));
//    }

    @Test
    public void testHashTable() {
        Bucket<Integer, String> bucket = new Bucket<>();
        bucket.put(0, "hello");
        bucket.put(1, "world");
        bucket.put(235134, "hell0, world!");
        assertEquals(3, bucket.getElements().size());

        assertNull(bucket.get(107));
        assertEquals("hello", bucket.get(0));

        assertTrue(bucket.remove(0));
        assertNull(bucket.get(0));

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
    }

}
