package org.ajeet.learnings.algorithms.ds.linear;

public interface IList<T> {

    public void add(T element);
    public void addFirst(T element);
    public void addLast(T element);
    public T remove(int index);
    public T find(int index);
}
