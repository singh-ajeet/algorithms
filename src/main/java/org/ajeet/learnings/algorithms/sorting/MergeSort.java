package org.ajeet.learnings.algorithms.sorting;

import java.util.Arrays;

public final class MergeSort {
    private final static int THRESOLD = 5;

    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length-1;
        sort(nums, 0, n);
    }

    private static void sort(int[] nums, int from, int to) {
        if(from >= to){
            return;
        }

        if(to - from == THRESOLD){
            InsertionSort.sort(nums, from, to);
            return;
        }

        int mid = from + (to - from)/2;
        sort(nums, from, mid);
        sort(nums, mid+1, to);
        merge(nums, from, mid, to);
    }

    private static void merge(int[] nums, int from, int mid, int to) {
        int[] aux = new int[to - from + 1];

        int lo = from;
        int high = mid;
        for(int i= 0; i<= to-from; i++){
            if(lo == mid){
                aux[i] = nums[high++];
            } else if(high == to){
                aux[i] = nums[lo++];
            } else if(nums[lo] < nums[high]){
                aux[i] = nums[lo++];
            } else {
                aux[i] = nums[high++];
            }
        }

        int j = 0;
        for(int i= from; i<= to; i++){
            nums[i] = aux[j++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,5,1,6,8,9};
        sort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
