package org.ajeet.learnings.algorithms.ds.linear;

public final class Node<T> {
    T value;
    Node<T> next = null;

    public Node(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + '}';
    }
}
