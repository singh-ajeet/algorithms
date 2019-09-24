package org.ajeet.learnings.algorithms.ds.tree;

import java.util.Arrays;

public class BTree<Key extends Comparable<Key>, Value>  {
    // max children per B-tree node = M-1
    // (must be even and greater than 2)
    private static final int M = 4;

    private Node root;       // root of the B-tree
    private int height;      // height of the B-tree
    private int n;           // number of _1-value pairs in the B-tree

    // helper B-tree node _2 type
    private static final class Node {
        private int m;                             // number of children
        private Entry[] children = new Entry[M];   // the array of children

        // create a node with k children
        private Node(int k) {
            m = k;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "m=" + m +
                    ", children=" + Arrays.toString(children) +
                    '}';
        }
    }

    // internal nodes: only use _1 and next
    // external nodes: only use _1 and value
    private static class Entry {
        private Comparable key;
        private final Object val;
        private Node next;     // helper field to iterate over array entries
        public Entry(Comparable key, Object val, Node next) {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "_1=" + key +
                    ", val=" + val +
                    '}';
        }
    }

    /**
     * Initializes an empty B-tree.
     */
    public BTree() {
        root = new Node(0);
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of _1-value pairs in this symbol table.
     * @return the number of _1-value pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Returns the height of this B-tree (for debugging).
     *
     * @return the height of this B-tree
     */
    public int height() {
        return height;
    }


    /**
     * Returns the value associated with the given _1.
     *
     * @param  key the _1
     * @return the value associated with the given _1 if the _1 is in the symbol table
     *         and {@code null} if the _1 is not in the symbol table
     * @throws IllegalArgumentException if {@code _1} is {@code null}
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to find() is null");
        return search(root, key, height);
    }

    private Value search(Node x, Key key, int ht) {
        Entry[] children = x.children;

        // external node
        if (ht == 0) {
            for (int j = 0; j < x.m; j++) {
                if (eq(key, children[j].key)) return (Value) children[j].val;
            }
        }

        // internal node
        else {
            for (int j = 0; j < x.m; j++) {
                if (j+1 == x.m || less(key, children[j+1].key))
                    return search(children[j].next, key, ht-1);
            }
        }
        return null;
    }


    /**
     * Inserts the _1-value pair into the symbol table, overwriting the old value
     * with the new value if the _1 is already in the symbol table.
     * If the value is {@code null}, this effectively deletes the _1 from the symbol table.
     *
     * @param  key the _1
     * @param  val the value
     * @throws IllegalArgumentException if {@code _1} is {@code null}
     */
    public void put(Key key, Value val) {
        if (key == null){
            throw new IllegalArgumentException("argument _1 to put() is null");
        }

        Node u = insert(root, key, val, height);
        n++;
        //Key was added in a node and no new node was created
        if (u == null) return;

        // New node was creaed and we need to split root
        Node t = new Node(2);
        t.children[0] = new Entry(root.children[0].key, null, root);
        t.children[1] = new Entry(u.children[0].key, null, u);
        root = t;
        height++;
    }

    private Node insert(Node root, Key key, Value val, int height) {
        int keyIndex;
        Entry entry = new Entry(key, val, null);

        // external node
        if (height == 0) {
            //Seek to location to insert new _2
            keyIndex = seekToIndexToInsert(root, key);
        }  else { // internal node
            for (keyIndex = 0; keyIndex < root.m; keyIndex++) {
                if ((keyIndex+1 == root.m) || less1(key, root.children[keyIndex+1].key)) {
                    Node u = insert(root.children[keyIndex++].next, key, val, height-1);
                    if (u == null) return null;
                    entry.key = u.children[0].key;
                    entry.next = u;
                    break;
                }
            }
        }

        //Move elements to RIGHT to make space for new entry
        for (int i = root.m; i > keyIndex; i--){
            root.children[i] = root.children[i-1];
        }

        root.children[keyIndex] = entry;
        root.m++;

        //If number of entries have been exceeded M than split it.
        if (root.m < M) {
            return null;
        } else {
            return split(root);
        }
    }

    private int seekToIndexToInsert(Node root, Key key) {
        int keyIndex;
        for (keyIndex = 0; keyIndex < root.m; keyIndex++) {
            if (less(key, root.children[keyIndex].key)){
                break;
            }
        }
        return keyIndex;
    }

    // split node in half
    private Node split(Node h) {
        Node t = new Node(M/2);
        h.m = M/2;
        for (int j = 0; j < M/2; j++){
            t.children[j] = h.children[M/2+j];
            h.children[M/2+j] = null;
        }

        return t;
    }

    /**
     * Returns a string representation of this B-tree (for debugging).
     *
     * @return a string representation of this B-tree.
     */
    public String toString() {
        return toString(root, height, "") + "\n";
    }

    private String toString(Node h, int ht, String indent) {
        StringBuilder s = new StringBuilder();
        Entry[] children = h.children;

        if (ht == 0) {
            for (int j = 0; j < h.m; j++) {
                s.append(indent + children[j].key + " " + children[j].val + "\n");
            }
        }
        else {
            for (int j = 0; j < h.m; j++) {
                if (j > 0) s.append(indent + "(" + children[j].key + ")\n");
                s.append(toString(children[j].next, ht-1, indent + "     "));
            }
        }
        return s.toString();
    }

    private boolean less1(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) < 0;
    }


    // comparison functions - make Comparable instead of Key to avoid casts
    private boolean less(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) < 0;
    }

    private boolean eq(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) == 0;
    }


    /**
     * Unit tests the {@code BTree} _2 type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        BTree<String, String> st = new BTree<String, String>();

/*        st.put("www.cs.princeton.edu", "128.112.136.12");
        st.put("www.cs.princeton.edu", "128.112.136.11");
        st.put("www.princeton.edu",    "128.112.128.15");
        st.put("www.yale.edu",         "130.132.143.21");
        st.put("www.simpsons.com",     "209.052.165.60");
        st.put("www.apple.com",        "17.112.152.32");
        st.put("www.amazon.com",       "207.171.182.16");
        st.put("www.ebay.com",         "66.135.192.87");
        st.put("www.cnn.com",          "64.236.16.20");
        st.put("www.google.com",       "216.239.41.99");
        st.put("www.nytimes.com",      "199.239.136.200");
        st.put("www.microsoft.com",    "207.126.99.140");
        st.put("www.dell.com",         "143.166.224.230");
        st.put("www.slashdot.org",     "66.35.250.151");
        st.put("www.espn.com",         "199.181.135.201");
        st.put("www.weather.com",      "63.111.66.11");
        st.put("www.yahoo.com",        "216.109.118.65");

        System.out.println("cs.princeton.edu:  " + st.find("www.cs.princeton.edu"));
        System.out.println("hardvardsucks.com: " + st.find("www.harvardsucks.com"));
        System.out.println("simpsons.com:      " + st.find("www.simpsons.com"));
        System.out.println("apple.com:         " + st.find("www.apple.com"));
        System.out.println("ebay.com:          " + st.find("www.ebay.com"));
        System.out.println("dell.com:          " + st.find("www.dell.com"));
        System.out.println();

        System.out.println("size:    " + st.size());
        System.out.println("height:  " + st.height());
        System.out.println(st);
        System.out.println();
 */
        BTree<Integer, Integer> integerBtree = new BTree<>();
        integerBtree.put(0, 0);
        integerBtree.put(1, 1);
        integerBtree.put(2, 2);
        integerBtree.put(3, 3);
        integerBtree.put(4, 4);
        integerBtree.put(5, 5);
        integerBtree.put(6, 6);
        integerBtree.put(7, 7);
        integerBtree.put(8, 8);

        System.out.println(integerBtree);

    }
}