package org.ajeet.learnings.algorithms.search;

import java.util.Arrays;

public final class LinearSearch {

    public static int findIndex(int[] nums, int element) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int n = nums.length-1;
        for (int i=0; i<=n; i++){
            if(nums[i] == element){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,1,6,8,9};

        System.out.println("Sorted array:" + Arrays.toString(nums));
        System.out.println(findIndex(nums, 8));
    }
}
