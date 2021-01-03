package org.ajeet.learnings.algorithms.sorting;

import java.util.Arrays;

public final class MergeSortBottomUp {

    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        int[] aux = new int[nums.length];
        for(int i = 1; i< n; i = i + i){
            for(int j=0; j< n-i; j+= i + i){
                merge(nums, aux, j, j+i-1,Math.min(j+i+i -1, n-1));
            }
        }
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
