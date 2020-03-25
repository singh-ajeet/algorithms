package org.ajeet.learnings.algorithms.tree;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public final class BinaryTreeTester {

/*
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
        Tuple<Integer, Integer>[] data = new Tuple[]{
                new Tuple(1, 1),
                new Tuple(2, 2),
                new Tuple(3, 3),
                new Tuple(4, 4),
                new Tuple(5, 5),
                new Tuple(6, 6),
                new Tuple(7, 7),
                new Tuple(8, 8)

        };
        tree.build(data);

        assertThat(8, Is.is(tree.size()));
        assertThat(4, Is.is(tree.root().key));
    }

    @Test
    public void preOrderTraversal(){
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        Tuple<Integer, Integer>[] data = new Tuple[]{
                new Tuple(1, 1),
                new Tuple(2, 2),
                new Tuple(3, 3),
                new Tuple(4, 4),
                new Tuple(5, 5),
                new Tuple(6, 6),
                new Tuple(7, 7),
                new Tuple(8, 8)

        };
        tree.build(data);
        List<Integer> values = tree.traverse(BinaryTree.Traverse.PRE_ORDER);

        assertThat(8, Is.is(values.size()));
        assertThat(Arrays.asList(4,2,1,3,6,5,7,8), Is.is(values));
    }

    @Test
    public void inOrderTraversal(){
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        Tuple<Integer, Integer>[] data = new Tuple[]{
                new Tuple(1, 1),
                new Tuple(2, 2),
                new Tuple(3, 3),
                new Tuple(4, 4),
                new Tuple(5, 5),
                new Tuple(6, 6),
                new Tuple(7, 7),
                new Tuple(8, 8)

        };
        tree.build(data);
        List<Integer> values = tree.traverse(BinaryTree.Traverse.IN_ORDER);

        assertThat(8, Is.is(values.size()));
        assertThat(values, Is.is(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)));
    }

    @Test
    public void postOrderTraversal(){
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        Tuple<Integer, Integer>[] data = new Tuple[]{
                new Tuple(1, 1),
                new Tuple(2, 2),
                new Tuple(3, 3),
                new Tuple(4, 4),
                new Tuple(5, 5),
                new Tuple(6, 6),
                new Tuple(7, 7),
                new Tuple(8, 8)

        };
        tree.build(data);
        List<Integer> values = tree.traverse(BinaryTree.Traverse.POST_ORDER);

        assertThat(8, Is.is(values.size()));
        assertThat(values, Is.is(Arrays.asList(1, 3, 2, 5, 8, 7, 6, 4)));
    }

*/
}
