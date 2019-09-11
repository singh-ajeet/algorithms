package org.ajeet.learnings.algorithms.math;

import org.ajeet.learnings.algorithms.ds.tree.Tuple;

import java.util.HashMap;
import java.util.Map;

import static org.ajeet.learnings.algorithms.ds.tree.Tuple.pair;

public final class TwoSumProblem {

    /**
     * O(N) time, O(1) space
     *
     * @param input
     * @param sum
     * @return
     */
    public static Tuple<Integer, Integer> findWithSorted_Efficiently(int[] input, int sum){
        int i = 0;
        int j = input.length -1;

        while (i < j){
            int tmpSum = input[i] + input[j];
            if(tmpSum < sum)
                i++;
            else if(tmpSum > sum)
                j--;
            else
                return pair(i, j);
        }
        throw new IllegalArgumentException("No two sum solution exists.");
    }

        /**
         * O(NlogN) time and O(1) space
         * @param input
         * @param sum
         * @return
         */
    public static Tuple<Integer, Integer> findWithSorted(int[] input, int sum){

        for(int i=0; i<input.length; i++){
            int tmp  = sum - input[i];
            int index2 = binarySearch(input, i+1,input.length-1, tmp);
            if(index2 != -1)
                return new Tuple<>(i, index2);
        }
        throw new IllegalArgumentException("No two sum solution exists.");
    }

    private static int binarySearch(int[] input, int from, int to, int sum) {
        if(from > to){
            return -1;
        }
        int mid = from + (to  - from)/2;
        if (input[mid] == sum)
            return mid;
        else if(input[mid] > sum){
            return binarySearch(input, from, mid - 1, sum);
        } else {
            return binarySearch(input, mid + 1, to, sum);
        }
    }

    /**
     * O(N) time and O(N) space
     * @param input
     * @param sum
     * @return
     */
    public static Tuple<Integer, Integer> find(int[] input, int sum){
        Map<Integer, Integer> cache = new HashMap<>();
        for(int i =0; i<input.length; i++){
            int tmp = sum - input[i];
            if(cache.containsKey(tmp))
                return new Tuple<>(cache.get(tmp), i);
            cache.put(input[i], i);
        }
        throw new IllegalArgumentException("No two sum solution exists.");
    }

    public static void main(String[] args) {
        int[] input1 = {2,3,1,4,5};
        System.out.println(find(input1, 8));
        System.out.println(findWithSorted(input1, 8));
        System.out.println(findWithSorted_Efficiently(input1, 8));
        int[] input2 = {2,3,1,4,5};
        System.out.println(find(input1, 10));
    }
}
