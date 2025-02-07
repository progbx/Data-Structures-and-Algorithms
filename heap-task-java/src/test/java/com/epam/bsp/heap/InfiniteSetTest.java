package com.epam.bsp.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class InfiniteSetTest {

    @Test
    public void testInfiniteSet() {
        //Example 1
        InfiniteSet infSet = new InfiniteSet();         //[1, 2, 3, 4, 5, ...]
        assertEquals(1, infSet.popMinimum());  //[2, 3, 4, 5, 6, ...]
        assertEquals(2, infSet.popMinimum());  //[3, 4, 5, 6, ...]
        assertEquals(3, infSet.popMinimum());  //[4, 5, 6, ...]
        assertEquals(4, infSet.popMinimum());  //[5, 6, 7, ...]
        assertEquals(5, infSet.popMinimum());  //[6, 7, 8, ...]

        infSet.insert(3);   //[3, 6, 7, ...]
        infSet.insert(1);   //[1,- 3, 6, 7, ...]

        assertEquals(1, infSet.popMinimum());  //[3, 6, 7, ...]
        assertEquals(3, infSet.popMinimum());  //[6, 7, 8, ...]
        assertEquals(6, infSet.popMinimum());  //[7, 8, 9, ...]

        //Example 2
        infSet = new InfiniteSet();
        for (int i = 0; i < 100; i++) {
            assertEquals(i + 1, infSet.popMinimum());
        }
        //After 100 popMinimum() operations
        assertEquals(101, infSet.popMinimum());    //[102, 103, 104, ...]
        infSet.insert(35);   //[35, 102, 103, ...]
        infSet.insert(23);   //[23, 35, 102, 103, ...]

        assertEquals(23, infSet.popMinimum());    //[35, 102, 103, 104, ...]
        assertEquals(35, infSet.popMinimum());    //[102, 103, 104, ...]
        assertEquals(102, infSet.popMinimum());    //[103, 104, ...]
    }
}
