package org.ajeet.learnings.algorithms.ds.tree;

class Pair<K, V> {
    K key;
    V data;

    public Pair(K key, V data) {
        this.key = key;
        this.data = data;
    }

    static <K, V> Pair<K, V> pair(K key, V data){
        return new Pair<>(key, data);
    }
}
