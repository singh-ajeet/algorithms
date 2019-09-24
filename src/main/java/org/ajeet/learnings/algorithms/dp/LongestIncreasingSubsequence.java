package org.ajeet.learnings.algorithms.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LongestIncreasingSubsequence {

   public static List<Integer> find(int[] input){
        if (input == null || input.length == 0)
            return null;

        int n = input.length;
        if (n == 1)
            return Collections.singletonList(input[0]);

        List<List<Integer>> dp = new ArrayList();
        for(int i=0; i<input.length; i++)
            dp.add(new ArrayList<>());

        dp.get(0).add(input[0]);
        for (int i = 1; i<n; i++) {
            for (int j = 0; j<i; j++) {
                if (input[j] < input[i] && ( dp.get(i).size() < dp.get(j).size())) {
                    dp.set(i, new ArrayList<>(dp.get(j)));
                }
            }
            dp.get(i).add(input[i]);
        }

       int maxIndex = 0;
       for (int i = 0; i < n; i++) {
           if (dp.get(maxIndex).size() < dp.get(i).size()) {
               maxIndex = i;
           }
       }

       return dp.get(maxIndex);
    }

    public static void main(String[] args) {
        int[] input1 = { 3,2,6,4,5,1 };
        int[] input2 = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

        System.out.println(find(input1));
        System.out.println(find(input2));
    }
}
