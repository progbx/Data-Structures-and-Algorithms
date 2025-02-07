package com.epam.bsp.linked.list;

import java.util.List;

public class CustomLinkedList<E> {

    protected static class CustomListNode<E> {
        protected E element;
        protected CustomListNode<E> next;

        public CustomListNode(E element, CustomListNode<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    protected CustomListNode<E> head;

    public CustomLinkedList(List<E> elements) {
        for (int i = elements.size() - 1; i >= 0; i--) {
            head = new CustomListNode<>(elements.get(i), head);
        }
    }

    public CustomLinkedList<E> removeNodes(E element) {
        CustomListNode<E> dummy = new CustomListNode<>(null, head);
        CustomListNode<E> current = dummy;
        while (current.next != null) {
            if (current.next.element.equals(element)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        head = dummy.next;
        return this;
    }

    public CustomLinkedList<E> reverse() {
        CustomListNode<E> prev = null;
        CustomListNode<E> current = head;
        while (current != null) {
            CustomListNode<E> nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        head = prev;
        return this;
    }

    public CustomLinkedList<E> getRightMiddle() {
        CustomListNode<E> slow = head;
        CustomListNode<E> fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        head = slow;
        return this;
    }

    public boolean check(List<E> elements) {
        CustomListNode<E> curr = head;
        for(E element : elements) {
            if(curr == null) {
                return false;
            }
            if(!element.equals(curr.element)) {
                return false;
            } else {
                curr = curr.next;
            }
        }
        return curr == null;
    }
}
