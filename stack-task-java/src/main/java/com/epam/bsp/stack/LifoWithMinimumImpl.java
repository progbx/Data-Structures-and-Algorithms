package com.epam.bsp.stack;

import java.util.Optional;
import java.util.Stack;

public class LifoWithMinimumImpl<E extends Comparable<E>> extends LifoImpl<E> implements LifoWithMinimum<E> {
    private Stack<E> minStack = new Stack<>();

    @Override
    public E push(E e) {
        E pushed = super.push(e);
        if (minStack.empty() || e.compareTo(minStack.peek()) <= 0) {
            minStack.push(e);
        }
        return pushed;
    }

    @Override
    public E pop() {
        E popped = super.pop();
        if (popped.equals(minStack.peek())) {
            minStack.pop();
        }
        return popped;
    }

    @Override
    public Optional<E> getMinimum() {
        if (minStack.empty()) {
            return Optional.empty();
        } else {
            return Optional.of(minStack.peek());
        }
    }
}