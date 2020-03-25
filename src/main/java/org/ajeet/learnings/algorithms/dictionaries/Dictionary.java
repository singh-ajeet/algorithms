package org.ajeet.learnings.algorithms.dictionaries;

public interface Dictionary<K,V> {
    public V get(K key);
    public boolean put(K key, V value);
    public boolean contains(K key);
}
