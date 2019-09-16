package org.ajeet.learnings.algorithms.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * O(NlogN) solution for longest increasing sub sequence
 *
 */
public final class LongestIncreasingSubsequence2 {

    public static List<Integer> get(int[] input){
        if (input == null || input.length == 0)
            return null;

        int n = input.length;
        if (n == 1)
            return Collections.singletonList(input[0]);

        int N = input.length;

        int[] sEnd = new int[N];
        sEnd[0] = input[0];
        int sInd = 0;
        for (int i = 1; i < N; i++) {
            if (input[i] > sEnd[sInd]) {
                sEnd[++sInd] = input[i];
            } else {
                int binInd = Arrays.binarySearch(sEnd, 0, sInd + 1, input[i]);
                if (binInd < 0) {
                    binInd = (binInd + 1) * -1;
                    sEnd[binInd] = input[i];
                }
            }
        }

        return null;// dp.find(maxIndex);
    }

    public static void main(String[] args) {
        int[] input1 = { 3,2,6,4,5,1 };
        int[] input2 = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

        System.out.println(get(input1));
    //    System.out.println(find(input2));
    }

}
