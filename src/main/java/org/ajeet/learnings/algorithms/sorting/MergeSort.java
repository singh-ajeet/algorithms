package org.ajeet.learnings.algorithms.sorting;

import java.util.Arrays;

public final class MergeSort {
    private final static int THRESOLD = 5;

    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        int[] aux =  new int[n];
        sort(nums, aux, 0, n-1);
    }

    private static void sort(int[] nums, int[] aux, int from, int to) {
        if(from >= to){
            return;
        }

        if(to - from == THRESOLD){
            InsertionSort.sort(nums, from, to);
            return;
        }

        int mid = from + (to - from)/2;
        sort(nums, aux, from, mid);
        sort(nums, aux, mid+1, to);
        merge(nums, aux, from, mid, to);
    }

    private static void merge(int[] nums, int[] aux, int from, int mid, int to) {
        int lo = from;
        int high = mid+1;

        for(int i= from; i<= to; i++){
            aux[i] = nums[i];
        }

        for(int i= from; i<= to; i++){
            if(lo > mid){
                nums[i] = aux[high++];
            } else if(high > to){
                nums[i] = aux[lo++];
            } else if(nums[lo] < nums[high]){
                nums[i] = aux[lo++];
            } else {
                nums[i] = aux[high++];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,5,1,6,8,9};
        sort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
