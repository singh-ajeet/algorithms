package org.ajeet.learnings.algorithms.uf;

import java.util.Arrays;

public final class UnionFind {
    private final int[] grid;
    private final int[] size;
    private final int capacity;
    private int numOfComponents;

    public UnionFind(int capacity) {
        if(! (capacity > 0)){
            throw new IllegalArgumentException("Capacity should be greater than zero.");
        }
        this.capacity = capacity;
        numOfComponents = capacity;
        this.grid = new int[capacity + 1];
        for(int i=1; i<= capacity; i++)
            grid[i] = i;
        this.size = new int[capacity + 1];
        for(int i=1; i<= capacity; i++)
            size[i] = 1;
    }

    /**
     * Make smaller component to child of big component
     *
     * @param first
     * @param second
     */
    public void union(int first, int second){
        int firstId  = find(first);
        int secondId = find(second);
        //Check if these are already connected
        if(firstId == secondId){
            return;
        }
        if(size[firstId] < size[secondId]){
            size[secondId]+=size[firstId];
            grid[first] = secondId;
        }
        else {
            size[firstId]+=size[secondId];
            grid[second] = firstId;
        }
        --numOfComponents;
    }

    /**
     * Find component id of the element
     * @param element
     * @return
     */
    public int find(int element){
        while(grid[element] != element)
            element = grid[element];
        return element;
    }

    /**
     * Returns number of components
     *
     * @return
     */
    public int components() {
        return numOfComponents;
    }

    /**
     * To check if two elements are connected
     *
     * @param first
     * @param second
     * @return
     */
    public boolean connected(int first, int second) {
        return find(first) == find(second);
    }

    @Override
    public String toString() {
        return "UninFind{" +
                "grid=" + Arrays.toString(grid) +
                ", size=" + Arrays.toString(size) +
                ", capacity=" + capacity +
                '}';
    }
}
