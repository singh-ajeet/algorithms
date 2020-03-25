package org.ajeet.learnings.algorithms.network;

public final class UnionFind {
    private int components = 0;
    private int[] size;
    private int[] parent;

    /**
     * Need to provide size of UNionFind datastructure to start with
     *
     * @param size
     */
    public UnionFind(int size) {
        this.size = new int[size];
        parent = new int[size];
        components = size;
    }

    /**
     * Find which component this node belongs.
     *
     * @param node
     * @return
     */
    public int find(int node){
        int parent = node;

        while(parent != this.parent[parent]) {
            parent = this.parent[parent];
        }

        while(node != parent){
            int p = this.parent[node];
            this.parent[node] = parent;
            node = p;
        }

        return parent;
    }

    /**
     * Return false if no union happened else true
     *
     * @param node1
     * @param node2
     * @return
     */
    public boolean union(int node1, int node2){
        if(parent[node1] == parent[node2])
            return false;

        int parent1 = find(node1);
        int parent2 = find(node2);

        if(size[node1] < size[node2]){
            parent[node1] = parent2;
        } else {
            parent[node2] = parent1;
        }
        components--;
        return true;
    }

    public boolean connected(int node1, int node2){
        return parent[node1] == parent[node2];
    }

    public int numOfComponents(){
        return components;
    }

    public int size(int componentId) {
        return size[componentId];
    }
}
