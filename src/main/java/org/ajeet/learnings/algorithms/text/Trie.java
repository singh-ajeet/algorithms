package org.ajeet.learnings.algorithms.text;

public class Trie {
    private final int maxChars;
    private Node root;

    public Trie(int maxChars) {
        this.maxChars = maxChars;
    }

    public void add(String text, int value) {
       root = add(root, text, value, 0);
    }

    private Node add(Node node, String text, int value, int index) {
        if(node == null) {
            node = new Node(maxChars);
        }

        if(text.length() == index){
            node.value = value;
            return node;
        }

        int i = text.charAt(index) - 'a';
        node.children[i] = add(node.children[i], text, value, index+1);
        return node;
    }

    private int get(String text) {
        return get(root, text, 0);
    }

    private int get(Node node, String text, int index) {
        if(node == null){
            return -1;
        }

        if(text.length() == index){
            return node.value;
        }

        return get(node.children[text.charAt(index) - 'a'],text, index+1);
    }

    private static class Node  {
        private int value;
        private final Node[] children;

        private Node(int maxChildren) {
            this.children = new Node[maxChildren];
            this.value = -1;
        }

        private void setValue(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie(26);
        trie.add("ajeet", 100);
        trie.add("ajit", 200);
        trie.add("at", 300);

        System.out.println(trie.get("ajeet"));
        System.out.println(trie.get("ajit"));
        System.out.println(trie.get("at"));
    }
}
