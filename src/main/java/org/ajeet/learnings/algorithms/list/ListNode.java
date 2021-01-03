package org.ajeet.learnings.algorithms.list;

public class ListNode<T> {
    public T value;
    public ListNode<T> next;

    public ListNode(T value, ListNode<T> next) {
        this.value = value;
        this.next = next;
    }
    public ListNode(T value) {
        this(value, null);
    }

    public T getValue() {
        return value;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node [" + value + "]";
    }
}

