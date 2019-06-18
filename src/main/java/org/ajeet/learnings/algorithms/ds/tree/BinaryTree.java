package org.ajeet.learnings.algorithms.ds.tree;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class BinaryTree<K extends Comparable<K>, V> {
    private TreeNode<K, V> root;

    public void put(K key, V data) {
        if (root == null){
            root = new TreeNode<>(key, data);
            return;
        }
        put(root, key, data);
    }

    private TreeNode<K, V> put(TreeNode<K, V> root, K key, V data) {
        if(root == null){
            return new TreeNode<>(key, data);
        }
        int comparison = root.key.compareTo(key);
        if(comparison > 0) {
            root.leftChild = put(root.leftChild, key, data);
        } else if(comparison < 0){
           root.rightChild = put(root.rightChild, key, data);
        } else {
            root.data = data;
        }
        return root;
    }

    public TreeNode<K, V> find(K key){
        return find(root, key);
    }

    private TreeNode<K,V> find(TreeNode<K,V> root, K key) {
        if(root ==null){
            return null;
        }
        int cmp = root.key.compareTo(key);
        if(cmp> 0){
            return find(root.leftChild, key);
        } else if(cmp < 0){
            return find(root.rightChild, key);
        } else {
            return root;
        }
    }

    public int size(){
        return size(0, root);
    }

    private int size(int i, TreeNode<K, V> root) {
        if(root == null){
            return i;
        }
        return size(i, root.leftChild) + size(i, root.rightChild) + 1;
    }

    public TreeNode<K, V> commonParent(K key1, K key2){
        return commonParent(root, key1, key2);
    }

    private TreeNode<K,V> commonParent(TreeNode<K,V> root, K key1, K key2) {
        if(root == null){
            return null;
        } else if(root.key == key1 || root.key == key2){
            return root;
        }

        TreeNode left = commonParent(root.leftChild, key1, key2);
        TreeNode right = commonParent(root.rightChild, key1, key2);

        if(left == null){
            return right;
        } else if(right == null) {
            return left;
        } else {
            return root;
        }
    }

    /**
     * The depth of a node is the number of edges from the node to the tree's root node.
     * A root node will have a depth of 0.
     * https://stackoverflow.com/questions/2603692/what-is-the-difference-between-tree-depth-and-height
     * @return
     */
    public int depth(K key){
         return depth(0, key, root);
    }

    private int depth(int i, K key, TreeNode<K, V> root) {
        if (root == null || key == root.key){
            return i;
        }
        if(root.leftChild != null && root.leftChild.key == key){
            return i+1;
        }
        if(root.rightChild != null && root.rightChild.key == key){
            return i + 1;
        }
        int leftLevel = depth(i, key,  root.leftChild);
        int rightLevel = depth(i, key, root.rightChild);

        return  Math.max(leftLevel, rightLevel)+ 1;
    }

    /**
     * The diameter (or width) of a tree is the number of nodes on the longest path between any two leaf nodes. The tree below has a diameter of 6 nodes.
     * https://stackoverflow.com/questions/2603692/what-is-the-difference-between-tree-depth-and-height
     * https://www.techiedelight.com/find-diameter-of-a-binary-tree/
     *
     * @return
     */
    public int diameter(){
        AtomicInteger diameter = new AtomicInteger(0);
        diameter(0, diameter, root);
        return diameter.get();
    }

    /**
     * The height of a binary tree is the largest number of edges in a path from the root node to a leaf node.
     *
     * @return
     */
    public int height(){
        return height(0, root);
    }

    private int height(int i, TreeNode<K, V> root) {
        if(root ==null){
            return i;
        }
        int leftHeight = height(i, root.leftChild);
        int rightHeight = height(i, root.rightChild);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private int diameter(int i, AtomicInteger diameter, TreeNode<K, V> root) {
        if(root == null){
            return 0;
        }
        int left = diameter(i, diameter, root.leftChild);
        int right = diameter(i, diameter, root.rightChild);
        //Calcualte through root
        int tmp = left + right + 1;
        diameter.set(Math.max(diameter.get(), tmp));

        return Math.max(left, right) + 1;
    }


    public List<TreeNode<K, V>> levels(){
        throw new UnsupportedOperationException("Serialization is not supported.");
    }

    /**
     * Build binary tree form sorted data.
     *
     * @param data
     */
    public void build(Pair<K, V>[] data){
        if(data == null || data.length == 0){
            throw new IllegalArgumentException("data array cant be null or empty");
        }

        root = build(0, data.length-1, data);
    }

    private TreeNode<K, V> build(int start, int end, Pair<K,V>[] data) {
        if(start > end){
            return null;
        }

        int mid = start + end >>> 1;

        TreeNode<K, V> node = new TreeNode<>(data[mid].key, data[mid].data);

        node.leftChild = build(start, mid -1, data);
        node.rightChild = build(mid + 1, end, data);

        return node;
    }

    public byte[] serialize(){
        throw new UnsupportedOperationException("Serialization is not supported.");
    }

    public void deSerialize(byte[] serializedTree){
        throw new UnsupportedOperationException("Serialization is not supported.");
    }

    public <T> TreeNode<K, V> root() {
        return root;
    }

    final class TreeNode<K extends Comparable<K>, V> {
        K key;
        V data;
        TreeNode<K, V> leftChild = null;
        TreeNode<K, V> rightChild = null;

        public TreeNode(K key, V data) {
            this.key = key;
            this.data = data;
        }

        @Override
        public String toString() {
            return "TreeNode{" + "key=" + key + ", data=" + data + '}';
        }
    }
}
