package org.ajeet.learnings.algorithms.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DFS<K,V> {
    private final IGraph<K,V> graph;
    private final Map<Node<K,V>, Boolean> visited = new HashMap<>();
    private int connectedComponents;
    private DFS(IGraph<K,V> graph){
        this.graph = graph;
    }

    private void dfs(Node source){
        visited.clear();
    }

    private void dfs_(Node source){
        if(visited.containsKey(source))
            return;
        visited.put(source, true);
        connectedComponents++;
        List<Node> neighbors = graph.getNeighbors(source);
        for(Node neighbor : neighbors) {
            dfs_(neighbor);
        }
    }

    public boolean areConnected(Node node1, Node node2) {
        return visited.containsKey(node1) &&
                visited.containsKey(node2);
    }

    public int getConnectedComponents(){
        return connectedComponents;
    }
}
