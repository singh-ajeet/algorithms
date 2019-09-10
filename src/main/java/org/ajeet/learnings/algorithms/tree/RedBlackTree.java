package org.ajeet.learnings.algorithms.tree;

public final class RedBlackTree<K extends Comparable<K>, V> {
    private Node<K, V> root;

    public void add(K key, V value){
        root = add(root, key, value);
    }

    private Node<K,V> add(Node<K,V> root, K key, V value) {
        if(root == null)
            return new Node<>(key, value, Color.RED);

        int cmp = key.compareTo(root.key);
        if(cmp < 0)
            root.left = add(root.left, key, value);
        else if(cmp > 0)
            root.right = add(root.right, key, value);
        else
            root.value = value;

        balance(root);
        return root;
    }

    private void balance(Node<K,V> root) {
        if (isRed(root.left) && !isRed(root.right))
            rotateRight(root.left);
        else if(!isRed(root.left) && isRed(root.right))
            rotateLeft(root.right);
        else if(isRed(root.left) && isRed(root.right))
            flipColor(root);
    }

    private void flipColor(Node<K, V> node) {
        if(isRed(node))
        node.color = Color.RED;
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;
    }

    private void rotateLeft(Node<K,V> node) {

    }

    private void rotateRight(Node<K,V> node) {
    }

    private boolean isRed(Node<K, V> node){
        return node == null || Color.RED.equals(node.color);
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> left;
        private Node<K, V> right;
        private Color color;

        public Node(K key, V value, Color color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    private enum Color {
        RED,
        BLACK
    }
}