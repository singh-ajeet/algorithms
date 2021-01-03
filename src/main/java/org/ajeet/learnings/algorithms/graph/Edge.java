package org.ajeet.learnings.algorithms.graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Edge<K,V> {
    private final Node<K, V> source;
    private final Node<K, V> destination;
    private final Map<String, Object> properties = new HashMap<>();

    public Edge(Node<K, V> source, Node<K, V> destination) {
        this(source, destination, null);
    }

    public Edge(Node<K, V> source, Node<K, V> destination, Map<String, Object> properties) {
        this.source = source;
        this.destination = destination;
        if(properties != null){
            this.properties.putAll(properties);
        }
    }

    public boolean addProperty(String name, Object value){
        return properties.put(name, value) == null;
    }

    public void addProperties(Map<String, Object> properties){
        properties.putAll(properties);
    }

    public Object getProperty(String name) {
        return properties.get(name);
    }

    public Map<String, Object> getProperties(){
        return Collections.unmodifiableMap(properties);
    }

    public boolean hasProperty(String name){
        return properties.containsKey(name);
    }

    public void clearProperties(){
        properties.clear();
    }

    public Node<K,V> getAnother(Node<K, V> node) {
        if(source.equals(node))
            return destination;
        else
            return source;
    }

    @Override
    public String toString() {
        return source + "---" + properties + "-->" + destination;
    }
}
