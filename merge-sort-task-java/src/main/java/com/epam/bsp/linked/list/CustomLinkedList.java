package com.epam.bsp.linked.list;

import java.util.List;
public class CustomLinkedList<E extends Comparable<E>> {
    protected static class CustomListNode<E> {
        protected E element;
        protected CustomListNode<E> next;
        public CustomListNode() {
        }
        public CustomListNode(E element, CustomListNode<E> next) {
            this.element = element;
            this.next = next;
        }
    }
    protected CustomListNode<E> head;
    public CustomLinkedList() {
        head = null;
    }
    public CustomLinkedList(CustomLinkedList list) {
        head = list.head;
    }
    public CustomLinkedList(List<E> elements) {
        this();
        CustomListNode<E> curr = null;
        for(E element : elements) {
            if(head == null) {
                head = new CustomListNode<>(element, null);
                curr = head;
                continue;
            }
            curr.next = new CustomListNode<>(element, null);
            curr = curr.next;
        }
    }
    public CustomLinkedList<E> merge(CustomLinkedList<E> sorted) {
        CustomLinkedList<E> result = new CustomLinkedList<>();
        CustomListNode<E> curr1 = this.head;
        CustomListNode<E> curr2 = sorted.head;
        CustomListNode<E> curr = null;
        while (curr1 != null && curr2 != null) {
            if (curr1.element.compareTo(curr2.element) <= 0) {
                if (result.head == null) {
                    result.head = new CustomListNode<>(curr1.element, null);
                    curr = result.head;
                } else {
                    curr.next = new CustomListNode<>(curr1.element, null);
                    curr = curr.next;
                }
                curr1 = curr1.next;
            } else {
                if (result.head == null) {
                    result.head = new CustomListNode<>(curr2.element, null);
                    curr = result.head;
                } else {
                    curr.next = new CustomListNode<>(curr2.element, null);
                    curr = curr.next;
                }
                curr2 = curr2.next;
            }
        }
        while (curr1 != null) {
            if (result.head == null) {
                result.head = new CustomListNode<>(curr1.element, null);
                curr = result.head;
            } else {
                curr.next = new CustomListNode<>(curr1.element, null);
                curr = curr.next;
            }
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            if (result.head == null) {
                result.head = new CustomListNode<>(curr2.element, null);
                curr = result.head;
            } else {
                curr.next = new CustomListNode<>(curr2.element, null);
                curr = curr.next;
            }
            curr2 = curr2.next;
        }
        return result;
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