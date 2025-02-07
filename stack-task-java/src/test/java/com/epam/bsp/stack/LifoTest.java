package com.epam.bsp.stack;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class LifoTest {

    @Test
    public void lifoTestSample() {
        Lifo<Integer> lifoInt = new LifoImpl<>();
        assertThrowsExactly(NoSuchElementException.class, lifoInt::pop);
        assertTrue(lifoInt.empty());
        IntStream.range(0, 5).forEach(lifoInt::push);
        assertEquals(5, lifoInt.size());
        IntStream.range(0, 5).forEach(i -> assertEquals(i, 4 - lifoInt.pop()));
        assertThrowsExactly(NoSuchElementException.class, lifoInt::peek);

        Lifo<String> lifoStr = new LifoImpl<>();
        assertTrue(lifoStr.empty());
        lifoStr.push("abc");
        String str = lifoStr.peek();
        assertEquals("abc", str);
        assertEquals(1, lifoStr.size());
    }

    @Test
    public void lifoWithMinimumTestSample() {
        LifoWithMinimum<Integer> lifoInt = new LifoWithMinimumImpl<>();
        lifoInt.push(3);
        lifoInt.push(2);
        lifoInt.push(4);
        assertEquals(2, lifoInt.getMinimum().get());

        lifoInt.push(5);
        lifoInt.push(1);
        assertEquals(1, lifoInt.getMinimum().get());

        lifoInt.pop();
        lifoInt.pop();
        assertEquals(2, lifoInt.getMinimum().get());
        assertEquals(3, lifoInt.size());

        LifoWithMinimum<String> lifoStr = new LifoWithMinimumImpl<>();
        lifoStr.push("asd");
        lifoStr.push("qwe");
        assertEquals("asd", lifoStr.getMinimum().get());
        assertEquals(2, lifoStr.size());
    }

}
