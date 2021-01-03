package org.ajeet.learnings.algorithms.search;


import org.ajeet.learnings.algorithms.sorting.MergeSort;
import java.util.Arrays;

public final class BinarySearch {

    /**
     * If element does not exists than return -1
     *
     * @param nums
     * @param element
     * @return
     */
    public static int findIndex(int[] nums, int element) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int n = nums.length-1;
        return search(nums,element, 0, n);
    }

    private static int search(int[] nums, int element, int from, int to) {
        if(from == to) {
            if(nums[from] == element)
                return from;
            else
                return -1;
        }

        int mid = from + (to-from)/2;
        if(nums[mid] > element) {
            return search(nums, element,0, mid-1);
        } else if(nums[mid] < element){
            return search(nums, element, mid+1, to);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,5,1,6,8,9};
        MergeSort.sort(nums);

        System.out.println("Sorted array:" + Arrays.toString(nums));
        System.out.println(findIndex(nums, 8));
    }
}