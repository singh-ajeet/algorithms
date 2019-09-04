package org.ajeet.sdk.algorithms.tree;

import java.util.TreeMap;

public final class BinaryTree<K extends Comparable<K>, V> {
    private Node<K, V> root;

    public void put(K key, V value){
        root = put(root, key, value);
    }

    public void remove(K key){
        root = remove(root, key);
    }

    private Node<K, V> remove(Node<K,V> root, K key) {
        if(root ==null)
            return null;

        int compare = root.key.compareTo(key);

        if(compare > 0)
            root.left = remove(root.left, key);
        else if (compare < 0)
            root.right = remove(root.right, key);
        else
            return removeNode(root);

        return root;
    }

    private Node<K, V> removeNode(Node<K, V> root) {
        if(root.left == null && root.right == null){
            return null;
        } else if(root.right == null){
            return root.left;
        } else {
            Node tmpRoot = root.right;
            Node tmp = getLeftMostNode(tmpRoot);
            tmp.left = root.left;
            return tmpRoot;
        }
    }

    private Node getLeftMostNode(Node tmpRoot) {
        Node tmp = tmpRoot;
        while (tmp.left != null){
            tmp = tmp.left;
        }
        return tmp;
    }

    private Node<K, V> put(Node<K,V> root, K key, V value) {
        if(root ==null)
            return new Node<>(key, value);

        int compare = root.key.compareTo(key);

        if(compare > 0)
            root.left = put(root.left, key, value);
        else if (compare < 0)
            root.right = put(root.right, key, value);
        else
            root.value = value;

        return root;
    }

    private static class Node<K extends Comparable<K>, V> implements Comparable<K> {
        private K key;
        private V value;
        private Node<K, V> left;
        private Node<K, V> right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(K other) {
            return key.compareTo(other);
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.put(8,8);
        tree.put(4, 4);
        tree.put(10, 10);
        tree.put(1, 1);
        tree.put(3, 3);
        tree.put(4, 444);
        tree.put(9,9);
        tree.put(7,7);

        System.out.println(tree);

        tree.remove(4);
        System.out.println(tree);
    }
}
