package org.ajeet.learnings.algorithms.tree;

import java.lang.reflect.Array;
import java.util.Arrays;

public final class FenwickTree {
    private final int[] buffer;

    public FenwickTree(int size) {
        buffer = new int[size + 1];
    }

    public FenwickTree(int[] input) {
        buffer = new int[input.length + 1];
        System.arraycopy(input, 0, buffer,1, input.length);
    }

    public void update(int index, int value) {

    }

    public int sum(int from, int to) {
        return 0;
    }

    private int lastOneDigit(int number) {
        return number & -number;
    }

    public static void main(String[] args) {
        System.out.println(3 & -3);
    }
}
