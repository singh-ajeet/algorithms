package org.ajeet.learnings.algorithms.graph;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IGraph<K, V> {
    public void addNode(Node<K, V> node);
    public void addEdge(Node<K, V> source, Node<K, V> destination, Map<String, Object> properties);
    public boolean hasEdge(Node<K, V> from);
    public List<Node<K,V>> getNeighbors(Node<K, V> node);
    public Set<Node<K,V>> getNodes();
}
