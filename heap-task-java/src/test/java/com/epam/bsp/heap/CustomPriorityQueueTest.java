package com.epam.bsp.heap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomPriorityQueueTest {

    @Test
    public void testCustomPriorityQueue() {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>();

        //Example 1
        assertTrue(pq.isEmpty());

        pq.insert(4);   //[4]
        pq.insert(3);   //[3, 4]
        pq.insert(2);   //[2, 3, 4]
        assertEquals(3, pq.size());

        assertEquals(2, pq.pop());  //[3, 4]
        assertEquals(3, pq.getMinimum());

        pq.insert(1);   //[1, 3, 4]
        assertEquals(1, pq.getMinimum());

        //Example 2
        pq = new CustomPriorityQueue<>();
        pq.insert(1);   //[1, 2]
        pq.insert(2);   //[1, 2]
        pq.insert(3);   //[1, 2, 3]
        pq.insert(4);   //[1, 2, 3, 4]
        pq.insert(5);   //[1, 2, 3, 4, 5]

        assertEquals(1, pq.pop());  //[2, 3, 4, 5]
        assertEquals(2, pq.pop());  //[3, 4, 5]
        assertEquals(3, pq.pop());  //[4, 5]
        assertEquals(4, pq.pop());  //[5]
        assertEquals(5, pq.pop());  //[]

        assertTrue(pq.isEmpty());

        //Example 3
        CustomPriorityQueue<String> strpq = new CustomPriorityQueue<>();
        strpq.insert("4");   //["4"]
        strpq.insert("3");   //["3", "4"]
        strpq.insert("2");   //["2", "3", "4"]
        assertEquals(3, strpq.size());

        assertEquals("2", strpq.pop());  //["3", "4"]
        assertEquals("3", strpq.getMinimum());

        strpq.insert("1");   //["1", "3", "4"]
        assertEquals("1", strpq.getMinimum());

    }
}
