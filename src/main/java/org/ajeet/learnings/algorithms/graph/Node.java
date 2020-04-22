package org.ajeet.learnings.algorithms.graph;

import java.util.List;
import java.util.Map;

final class Node<K,V> {
    private final K key;
    private final V value;
    private final IGraph<K,V> graph;

    public Node(K key, V value, IGraph<K, V> graph) {
        this.key = key;
        this.value = value;
        this.graph = graph;
    }

    public List<Node<K,V>> getNeighbors(){
        return graph.getNeighbors(this);
    }

    public void addEdge(Node<K,V> to, Map<String, Object> properties) {
        graph.addEdge(this, to, properties);
    }

    public boolean hasEdge(){
        return graph.hasEdge(this);
    }
}
