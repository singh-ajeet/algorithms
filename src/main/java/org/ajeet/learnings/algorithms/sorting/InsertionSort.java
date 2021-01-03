package org.ajeet.learnings.algorithms.sorting;

import java.util.Arrays;

/**
 * In insertion sort algorithm we select an item and insert it at its sorted place.
 */
public final class InsertionSort {

    public static void sort2(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }

        int n = nums.length;
        for(int i=1; i<n; i++) {
            int j=i;
            while( j>0 && (nums[j-1] > nums[j])) {
                swap(nums, j, j-1);
                j--;
            }
        }
    }

    private static void swap(int[] nums, int j, int i) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    public static void sort(int[] nums, int from, int to){
        if(nums == null || nums.length == 0){
            return;
        }

        int n = nums.length;
        for (int i= from+1; i<=to; i++){
            int key = nums[i];
            int j = i-1;
            while (j >= from && nums[j] > key){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
    }

    public static void sort(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }

        int n = nums.length;
        for (int i= 1; i<n; i++){
            int key = nums[i];
            int j = i-1;
            while (j >= 0 && nums[j] > key){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2,5,1,6,8,9};
        sort(nums1);

        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {2,5,1,6,8,9};
        sort2(nums2);

        System.out.println(Arrays.toString(nums2));
    }
}
