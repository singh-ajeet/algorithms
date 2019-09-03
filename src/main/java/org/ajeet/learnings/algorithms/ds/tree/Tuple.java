package org.ajeet.learnings.algorithms.ds.tree;

class Tuple<K, V> {
    K key;
    V data;

    public Tuple(K key, V data) {
        this.key = key;
        this.data = data;
    }

    static <K, V> Tuple<K, V> pair(K key, V data){
        return new Tuple<>(key, data);
    }
}
