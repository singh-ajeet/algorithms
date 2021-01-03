package org.ajeet.learnings.algorithms.sorting;

import java.util.Arrays;

/**
 *  We find an smallest element and place it at first by swapping with first element.
 */
public final class SelectionSort {

    public static void sort(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }

        int n = nums.length;

        for(int i=0; i<n; i++){
            int min = i;
            int minIndex = i;
            for(int j=i+1; j<n;j++){
                if(nums[j] < nums[min]){
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }

    private static void swap(int[] nums, int j, int i) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,1,6,8,9};
        sort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
