package org.ajeet.learnings.algorithms.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LongestBitonicSubsequence {

    public static List<Integer> find(int[] input){
        if(input == null || input.length == 0)
            return Collections.emptyList();

        int n = input.length;
        List<Integer> increasing[] = new ArrayList[n];

        for(int i=0; i<n; i++) {
            increasing[i] = new ArrayList<>();
        }
        increasing[0].add(input[0]);

        for (int i=1; i< n; i++){
            for (int j=0; j<i; j++) {
                if(input[i] > input[j] && increasing[i].size() < increasing[j].size()) {
                    increasing[i] = new ArrayList<>(increasing[j]);
                }
            }
            increasing[i].add(input[i]);
        }

        List<Integer> decreasing[] = new ArrayList[n];

        for(int i=0; i<n; i++) {
            decreasing[i] = new ArrayList<>();
        }
        decreasing[0].add(input[0]);

        for (int i=1; i< n; i++){
            for (int j=0; j<i; j++) {
                if(input[i] < input[j] && decreasing[i].size() < decreasing[j].size()) {
                    decreasing[i] = new ArrayList<>(decreasing[j]);
                }
            }
            decreasing[i].add(input[i]);
        }

        int maxI = 0;
        int maxD = 0;
        int maxSize = 1;
        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                if(increasing[i].size() + decreasing[j].size() > maxSize){
                    maxSize = increasing[i].size() + decreasing[j].size();
                    maxI = i;
                    maxD = j;
                }

            }
        }
        List<Integer> result = new ArrayList<>(increasing[maxI]);
        result.addAll(decreasing[maxD]);
        return result;
    }

    public static void main(String[] args) {
        int[] input1 = { 3,2,6,4,5,1 };
        int[] input2 = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

        System.out.println(find(input1));
        System.out.println(find(input2));
    }
}


