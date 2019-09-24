package org.ajeet.learnings.algorithms.ds.tree;

import java.util.PriorityQueue;

public final class BinaryMinHeap<E extends Comparable<E>> {
    private final Object[] m_buffer;
    private final int m_capacity;
    private int m_index = 0;

    public BinaryMinHeap(int capacity) {
        m_capacity = capacity;
        m_buffer =  new Object[capacity];
    }

    public void insert(E element){
        if (m_buffer.length == m_index -1 ) {
            throw new IllegalArgumentException("Heap is full !!");
        }
        if (element == null) {
            throw new NullPointerException();
        }
        m_buffer[++m_index] = element;
        swim(m_index);
    }

    public boolean isEmpty(){
        return m_index == 0;
    }
    private void swim(int index) {
        int j = index ;
        while(j > 1) {
            if(((E)m_buffer[j/2]).compareTo((E)m_buffer[j]) > 0)
                swap(j, j/2);
            j = j / 2;
        }
    }

    private void dive(int i) {
        while(2* i <= m_index ){
            int k = 2 * i;
            if( k < m_index && ((E)m_buffer[k + 1]).compareTo((E)m_buffer[k]) < 0){
                k++;
            }
            if (! (((E)m_buffer[i]).compareTo((E)m_buffer[k]) >  0)){
                break;
            }
            swap(k, i);
            i = k;
        }
    }

    private void swap(int first, int second) {
        E tmp = (E) m_buffer[first];
        m_buffer[first] = m_buffer[second];
        m_buffer[second] = tmp;
    }

    public E peek(){
        if (isEmpty())
            throw new IllegalStateException("");
        return (E) m_buffer[1];
    }

    public E pop(){
        if (isEmpty())
            throw new IllegalStateException("Heap is empty !!");

        E element = (E) m_buffer[1];
        swap(1, m_index--);
        dive(m_index);
        m_buffer[m_index+1] = null;
        return element;
    }

    public static void main(String[] args) {
        BinaryMinHeap<Integer> heap = new BinaryMinHeap<>(10);
        heap.insert(200);
        heap.insert(100);
        heap.insert(10);
        heap.insert(50);
        heap.insert(300);

        System.out.println(heap.peek());
        System.out.println("deleting ...");
        while (!heap.isEmpty())
            System.out.println(heap.pop());

    }
}
