package org.ajeet.learnings.algorithms.ds.linear;

public final class StackArray<T> {
    private final T[] buffer;
    private int head = 0;

    public StackArray(int capacity) {
        if(capacity < 1){
            throw new IllegalArgumentException("capacity should be greater than zero.");
        }

        this.buffer = (T[]) new Object[capacity];
    }

    public int size(){
        return head;
    }

    public void push(T element){
        buffer[head++] = element;
    }

    public T pop() {
        return buffer[--head];
    }
}
