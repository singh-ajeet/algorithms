package org.ajeet.learnings.algorithms.ds.tree;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public final class BinaryTreeTester {

    @Test
    public void root(){
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.put(8, 8);
        tree.put(7, 7);
        tree.put(11, 11);
        tree.put(10, 10);
        tree.put(15, 15);
        tree.put(14, 14);

        assertThat(8, Is.is(tree.root().key));
    }

    @Test
    public void height(){
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.put(8, 8);
        tree.put(7, 7);
        tree.put(11, 11);
        tree.put(10, 10);
        tree.put(15, 15);
        tree.put(14, 14);

        assertThat(4, Is.is(tree.height()));
    }

    @Test
    public void depth(){
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.put(8, 8);
        tree.put(7, 7);
        tree.put(11, 11);
        tree.put(10, 10);
        tree.put(15, 15);
        tree.put(14, 14);

        assertThat(3, Is.is(tree.depth(14)));
    }

    @Test
    public void commonParent(){
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.put(8, 8);
        tree.put(7, 7);
        tree.put(11, 11);
        tree.put(10, 10);
        tree.put(15, 15);
        tree.put(14, 14);

        assertThat(8, Is.is(tree.commonParent(7, 14).key));
    }

    @Test
    public void diameter(){
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.put(8, 8);
        tree.put(7, 7);
        tree.put(11, 11);
        tree.put(10, 10);
        tree.put(15, 15);
        tree.put(14, 14);

        assertThat(5, Is.is(tree.diameter()));
    }

    @Test
    public void size(){
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.put(8, 8);
        tree.put(7, 7);
        tree.put(11, 11);
        tree.put(10, 10);
        tree.put(15, 15);
        tree.put(14, 14);

        assertThat(6, Is.is(tree.size()));
    }

    @Test
    public void buildTree(){
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        Pair<Integer, Integer>[] data = new Pair[]{
                new Pair(1, 1),
                new Pair(2, 2),
                new Pair(3, 3),
                new Pair(4, 4),
                new Pair(5, 5),
                new Pair(6, 6),
                new Pair(7, 7),
                new Pair(8, 8)

        };
        tree.build(data);

        assertThat(8, Is.is(tree.size()));
        assertThat(4, Is.is(tree.root().key));
    }
}
