package com.epam.bsp.disjoint.set;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DisjointSetsTest {

    @Test
    public void testDisjointSets() {
        //Sample tests for DisjointSets class.
        DisjointSets<Integer> ds = new DisjointSets<>();
        //Let's create 5 sets
        for (int i = 0; i < 5; i++) {
            ds.makeSet(i);
            assertEquals(i, ds.findSet(i));
        }
        //Let's join some sets: {0; 1, 2}, {3, 4}
        ds.unionSets(0, 1);
        ds.unionSets(0, 2);
        ds.unionSets(3, 4);
        assertEquals(ds.findSet(0), ds.findSet(1));
        assertEquals(ds.findSet(0), ds.findSet(2));
        assertEquals(ds.findSet(3), ds.findSet(4));
        assertNotEquals(ds.findSet(0), ds.findSet(3));
    }
}
