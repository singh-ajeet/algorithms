package org.ajeet.learnings.algorithms.ds.tree;

public final class BinaryMaxHeap<E extends Comparable<E>> {
    private final E[] m_buffer;
    private final int m_capacity;
    private int index = 0;

    public BinaryMaxHeap(int capacity) {
        m_capacity = capacity;
        m_buffer = (E[]) new Object[capacity];
    }

    public void insert(E element){
        if (m_buffer.length == index -1 ) {
            throw new IllegalArgumentException("Heap is full !!");
        }
        if (element == null) {
            throw new NullPointerException();
        }
        m_buffer[++index] = element;
        swim(index);
    }

    private void swim(int index) {
        int j = index ;
        while(j > 1 && m_buffer[j/2].compareTo(m_buffer[j]) < 0) {
            swap(j, j/2);
            j = j / 2;
        }
    }

    private void dive(int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int largest = i;

        if(left <= m_buffer.length -1 && m_buffer[left].compareTo(m_buffer[i]) > 0) {
            largest = left;
        } else if(right <= m_buffer.length - 1 && m_buffer[right].compareTo(m_buffer[i]) > 0){
            largest = right;
        }
        if (largest != i){
            swap(largest, i);
            dive(largest);
        }
    }

    private void swap(int first, int second) {
        E tmp = m_buffer[first];
        m_buffer[first] = m_buffer[second];
        m_buffer[second] = tmp;
    }

    public E maxElement(){
        if (index == 0)
            throw new IllegalStateException("");
        return null;
    }

    public boolean removeMaxElement(E element){
        return false;
    }
}
