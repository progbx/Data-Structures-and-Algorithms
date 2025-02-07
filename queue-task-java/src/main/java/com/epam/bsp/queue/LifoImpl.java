package com.epam.bsp.queue;

import java.util.NoSuchElementException;
import java.util.Stack;

public class LifoImpl<E> implements Lifo<E> {
    private Stack<E> stack = new Stack<>();

    @Override
    public boolean empty() {
        return stack.empty();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public E push(E e) {
        return stack.push(e);
    }

    @Override
    public E pop() {
        if (stack.empty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return stack.pop();
    }

    @Override
    public E peek() {
        if (stack.empty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return stack.peek();
    }
}