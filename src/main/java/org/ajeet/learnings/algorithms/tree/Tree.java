package org.ajeet.learnings.algorithms.tree;

import java.util.List;

public interface Tree<K, V> {
    /**
     * Add an entry to tree, if an entry with same key already exists than replace old value
     *
     * @param key
     * @param value
     * @return
     */
    public void add(K key, V value);

    /**
     * Return value corresponding to the provided key, if key does not exists than return null
     *
     * @param key
     * @return
     */
    public V get(K key);

    /**
     * Remove an entry with specified key from the tree
     *
     * @param key
     * @return
     */
    public void remove(K key);


    /**
     * Return all entries between key1 and key2.
     *
     * @param from
     * @param to
     * @return
     */
    public List<Entry<K, V>> range(K from, K to);

    /**
     * Return all entries those have keys greater than this key. Excluding this key.
     *
     * @param key
     * @return
     */
    public List<Entry<K, V>> greaterThan(K key);

    /**
     * Return all entries those have keys smaller than this key. Excluding this key.
     *
     * @param key
     * @return
     */
    public List<Entry<K, V>> smallerThan(K key);

   class Entry<K, V> {
        public final K key;
        public final V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
