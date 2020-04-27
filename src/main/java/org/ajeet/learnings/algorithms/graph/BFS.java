package org.ajeet.learnings.algorithms.graph;

import java.util.HashMap;
import java.util.Map;

public final class BFS<K,V> {
    private final IGraph<K,V> graph;
    private final Map<Node<K,V>, Boolean> visited = new HashMap<>();

    private BFS(IGraph<K,V> graph){
        this.graph = graph;
    }

}
