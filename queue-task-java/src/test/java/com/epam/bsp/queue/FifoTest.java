package com.epam.bsp.queue;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class FifoTest {
    @Test
    public void testFifoSample() {
        Fifo<Integer> fifoInt = new FifoImpl<>();
        assertThrowsExactly(NoSuchElementException.class, fifoInt::pop);
        assertTrue(fifoInt.empty());
        IntStream.range(0, 5).forEach(fifoInt::push);
        assertEquals(5, fifoInt.size());
        IntStream.range(0, 5).forEach(i -> assertEquals(i, fifoInt.pop()));
        assertThrowsExactly(NoSuchElementException.class, fifoInt::peek);

        Fifo<String> fifoStr = new FifoImpl<>();
        assertTrue(fifoStr.empty());
        fifoStr.push("abc");
        String str = fifoStr.peek();
        assertEquals("abc", str);
        assertEquals(1, fifoStr.size());
    }

    @Test
    public void testAdditionalLifoSample() {
        Lifo<Integer> lifoInt = new LifoImpl<>();
        assertThrowsExactly(NoSuchElementException.class, lifoInt::pop);
        assertTrue(lifoInt.empty());
        IntStream.range(0, 5).forEach(lifoInt::push);
        assertEquals(5, lifoInt.size());
        IntStream.range(0, 5).forEach(i -> assertEquals(i, 4 - lifoInt.pop()));
        assertThrowsExactly(NoSuchElementException.class, lifoInt::peek);
    }

    @Test
    public void testQueueViaStacksSample() {
        QueueViaStacks<Integer> queue = new QueueViaStacks<>();

        //using reflection to make sure implementation with two stacks
        assertEquals(2, QueueViaStacks.class.getDeclaredFields().length);
        assertEquals(Lifo.class, QueueViaStacks.class.getDeclaredFields()[0].getType());
        assertEquals(Lifo.class, QueueViaStacks.class.getDeclaredFields()[1].getType());

        assertThrowsExactly(NoSuchElementException.class, queue::pop);
        assertTrue(queue.empty());
        IntStream.range(0, 5).forEach(queue::push);
        assertEquals(5, queue.size());
        IntStream.range(0, 5).forEach(i -> assertEquals(i, queue.pop()));
        assertThrowsExactly(NoSuchElementException.class, queue::peek);
    }

}
