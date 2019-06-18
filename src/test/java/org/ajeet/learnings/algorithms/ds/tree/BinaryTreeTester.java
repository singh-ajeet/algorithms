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

        assertThat(3, Is.is(tree.diameter()));
    }

}
