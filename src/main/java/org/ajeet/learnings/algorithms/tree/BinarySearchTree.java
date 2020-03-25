package org.ajeet.learnings.algorithms.tree;

import java.util.List;

public final class BinarySearchTree<K extends Comparable<K>,V> implements Tree<K , V> {
    private Node<K, V> root;

    @Override
    public void add(K key, V value) {
        if(key == null)
            throw new NullPointerException();

        root =  add(root, key, value);
    }

    private Node<K,V> add(Node<K,V> root, K key, V value) {
        if(root == null)
            return new Node<>(key, value);

        int cpm = key.compareTo(root.key());
        if (cpm < 0) {
            return add(root.left, key, value);
        } else if (cpm > 0) {
            return add(root.right, key, value);
        } else {
            root.update(value);
            return root;
        }
    }

    @Override
    public V get(K key) {
        if(key == null)
            throw new NullPointerException();

        return get(root, key);
    }

    @Override
    public void remove(K key) {
        if(key == null)
            throw new NullPointerException();

        root = remove(root, key);
    }

    private Node<K,V> remove(Node<K,V> root, K key) {
        if (root == null)
            return null;

        int cpm = key.compareTo(root.key());
        if (cpm < 0) {
            root.left =  remove(root.left, key);
        } else if (cpm > 0) {
            root.right = remove(root.right, key);
        } else {
            if(root.left == null){
                Node tmp = root.right;
                root.right = null;
                root.entry = null;
                return tmp;
            } else if(root.right == null) {
                Node tmp = root.left;
                root.left = null;
                root.entry = null;
                return tmp;
            }
            Node<K,V> maxValue = findMax(root.left);
            root.update(maxValue.value());
            root.left =  remove(maxValue, maxValue.key());
        }
        return root;
    }

    private Node findMax(Node<K,V> root) {
        Node tmp = root;
        while (root.right != null) {
            tmp = tmp.right;
        }
        return tmp;
    }

    private V get(Node<K,V> root, K key) {
        if(root == null)
            return null;
        int cpm = key.compareTo(root.key());
        if (cpm < 0) {
            return get(root.left, key);
        } else if (cpm > 0) {
            return get(root.right, key);
        } else {
            return root.value();
        }
    }

    @Override
    public List<Entry<K, V>> range(K from, K to) {
        return null;
    }

    @Override
    public List<Entry<K, V>> greaterThan(K key) {
        return null;
    }

    @Override
    public List<Entry<K, V>> smallerThan(K key) {
        return null;
    }

    private class Node<K,V> {
        private Entry<K,V> entry;
        private Node<K,V> left;
        private Node<K,V> right;

        private Node(K key, V value) {
            this.entry = new Entry<>(key, value);
        }

        private K key() {
            return entry.key;
        }

        private V value() {
            return entry.value;
        }

        private void update(V value) {
            entry = new Entry<>(key(), value);
        }
    }
}
