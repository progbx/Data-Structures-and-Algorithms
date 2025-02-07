package com.epam.bsp.queue;

public class QueueViaStacks<E> implements Fifo<E> {
    private final Lifo<E> stack1 = new LifoImpl<>();
    private final Lifo<E> stack2 = new LifoImpl<>();

    @Override
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }

    @Override
    public int size() {
        return stack1.size() + stack2.size();
    }

    @Override
    public E push(E e) {
        stack1.push(e);
        return e;
    }

    @Override
    public E pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    @Override
    public E peek() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
}