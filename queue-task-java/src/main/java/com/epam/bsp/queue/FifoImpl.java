package com.epam.bsp.queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class FifoImpl<E> implements Fifo<E> {
    private Queue<E> queue = new LinkedList<>();

    @Override
    public boolean empty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public E push(E e) {
        queue.add(e);
        return e;
    }

    @Override
    public E pop() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queue.poll();
    }

    @Override
    public E peek() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queue.peek();
    }
}