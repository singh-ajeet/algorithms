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

    public void push(T element){
        buffer[head++] = element;
    }

    public T pop() {
        return buffer[--head];
    }

    public static void main(String[] args) {
        StackArray<Integer> stack = new StackArray<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        for (int i=0; i<5; i++){
            System.out.println(stack.pop());
        }
    }
}
