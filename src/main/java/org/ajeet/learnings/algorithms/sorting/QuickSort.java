package org.ajeet.learnings.algorithms.sorting;

import java.util.Arrays;

public final class QuickSort {

    public static void sort(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }

        sort(nums, 0, nums.length-1);
    }
    public static void sort(int[] nums, int from, int to) {
        if(from >= to) {
            return;
        }

        int mid = partition(nums, from, to);
        sort(nums, from,  mid-1);
        sort(nums, mid+1, to);
    }

    private static int partition(int[] nums, int from, int to) {
        int pivot = nums[from];
        int i = from;
        int j = to+1;

        while(true){
            while(nums[++i] < pivot){
                if(i == to){
                    break;
                }
            }
            while(nums[--j] > pivot){
                if(j == from){
                    break;
                }
            }
            if(i>=j){
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, from, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,1,6,8,9};
        sort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
