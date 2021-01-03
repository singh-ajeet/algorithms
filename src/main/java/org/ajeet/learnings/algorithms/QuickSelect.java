package org.ajeet.learnings.algorithms;

import java.util.Arrays;

public final class QuickSelect {

    public static int[] topK(int[] input, int k) {
        if(input == null || input.length == 0) {
            throw new IllegalArgumentException("Input array cant be null or empty.");
        }
        int n = input.length - 1;
        quickSelect(input, 0, n, n - k);

        return Arrays.copyOfRange(input, n-k, n);
    }

    private static void quickSelect(int[] input, int left, int right, int k) {
        if(left>=right)
            return;
        int pivot = left;// Math.abs((right - left)/2);
        //Move pivot to end to avoid its displacement
        pivot = partition(input, left, right, pivot);
        if(pivot == k)
            return;
        else if(pivot < k)
            quickSelect(input, pivot+1, right, k);
        else
            quickSelect(input, left, pivot-1, k);

    }

    private static int partition(int[] input, int left, int right, int pivot) {
        int pivotElement = input[pivot];
        int p = left;
        swap(input, pivot, right);
        for(int i=left; i<=right; i++) {
            if(input[i] < pivotElement) {
                swap(input, i, p);
                p++;
            }
        }
        swap(input, p, right);
        return p;
    }

    private static void swap(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    public static void main(String[] args) {
        int[] input = {9,8,2,10,7,6};
        System.out.println("Original input: " + Arrays.toString(input));
        System.out.println("Top 4: " + Arrays.toString(topK(input, 4)));
    }
}
