package org.ajeet.learnings.algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class TreeCenter<K,V> {

    public static List<Node> find(IGraph graph) {
        if(graph == null)
            throw new NullPointerException("Input graph cant be null.");

        Map<Node, Boolean> visited = new HashMap();
        Map<Node, Integer> degrees = new HashMap();
        List<Node> leaves = new ArrayList<>();

        Set<Node> nodes = graph.getNodes();
        for(Node node :nodes) {
            if(!visited.containsKey(node)) {
                visited.put(node, true);
                int degree = node.getNeighbors().size();
                //Mark all leaves with one degree as leaves
                if(degree <= 1) {
                    leaves.add(node);
                } else {
                    degrees.put(node, degree);
                }
            }
        }
        if (leaves.isEmpty())
            throw new IllegalArgumentException("Input graph is not a tree.");

        int count = leaves.size();
        while (count < graph.getNodes().size()) {
            List<Node> newLeaves = new ArrayList<>();

            for(Node node : leaves) {
                List<Node> neighbours = node.getNeighbors();
                for(Node neighbour :  neighbours) {
                    if(degrees.containsKey(neighbour)) {
                        int degree = degrees.remove(neighbour)-1;
                        if(degree<=1){
                            newLeaves.add(neighbour);
                        }
                    }
                }
            }
            count+=newLeaves.size();
            leaves = newLeaves;
        }
        return leaves;
    }
}
