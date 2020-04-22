package org.ajeet.learnings.algorithms.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph<K, V> implements IGraph<K,V> {
    private final Map<Node<K, V>, List<Edge<K, V>>> adjancyList = new HashMap<>();

    @Override
    public void addNode(Node<K, V> node) {
        if (adjancyList.containsKey(node))
            throw new RuntimeException("Node already exists.");
        adjancyList.put(node, null);
    }

    @Override
    public void addEdge(Node<K, V> source, Node<K, V> destination, Map<String, Object> properties) {
        if(!adjancyList.containsKey(source) || !adjancyList.containsKey(destination))
            throw new RuntimeException("Source and destination both are mendatory to create an edge.");
        List<Edge<K,V>> edges = adjancyList.get(source);
        for (Edge<K,V> edge : edges) {
            //If an edge already exists than update the properties and return
            if (edge.getAnother(source) != null) {
                edge.addProperties(properties);
                return;
            }
        }
        //Create an new edge
        edges.add(new Edge<>(source, destination, properties));

    }

    @Override
    public boolean hasEdge(Node<K, V> from) {
        return adjancyList.containsKey(from);
    }

    @Override
    public List<Node<K, V>> getNeighbors(Node<K, V> node) {
        List<Node<K, V>> neighbors = new ArrayList<>();
        for (Edge<K,V> edge: adjancyList.get(node)) {
            neighbors.add(edge.getAnother(node));
        }
        return neighbors;
    }

    @Override
    public Set<Node<K,V>> getNodes() {
        return Collections.unmodifiableSet(adjancyList.keySet());
    }

}
