package org.ajeet.learnings.algorithms.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class PlusOne {

    public static List<Integer> add(List<Integer> number){
        if(number == null || number.size() == 0)
            return Collections.emptyList();

        int n= number.size();
        List<Integer> result = new ArrayList<>(number);

        for (int i = n-1; i>=0; i--) {
            int digit = result.get(i);
            if (digit < 9) {
                result.set(i, digit + 1);
                return result;
            } else {
                result.set(i, 0);
            }
        }
        result.add(0);
        result.set(0, 1);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3 );
        input = add(input);
        System.out.println(input);

        List<Integer> input2 = Arrays.asList(9, 9, 9);
        input2 = add(input2);
        System.out.println(input2);

    }
}
