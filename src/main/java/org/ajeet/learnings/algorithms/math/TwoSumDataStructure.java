package org.ajeet.learnings.algorithms.math;

import org.ajeet.learnings.algorithms.ds.tree.Tuple;

import java.util.HashMap;
import java.util.Map;

public final class TwoSumDataStructure {
    private final Map<Integer, Integer> buffer = new HashMap<>();

    public void add(int number){
        if(buffer.containsKey(number)){
            // For duplicate values
            int count = buffer.get(number);
            buffer.put(number, count + 1);
        } else {
          buffer.put(number, 1);
        }
    }

    public Tuple find(int value){
        for(Map.Entry<Integer, Integer> entry: buffer.entrySet()){
            int tmpSum = value - entry.getKey();
            if(buffer.containsKey(tmpSum)) {
                // Handling duplicates here
                if (tmpSum == entry.getKey() && entry.getValue() < 2) {
                    return null;
                }
                return new Tuple(entry.getKey(), tmpSum);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSumDataStructure twoSum = new TwoSumDataStructure();
        twoSum.add(6);
     //   twoSum.add(4);
        twoSum.add(2);
     //   twoSum.add(5);
        twoSum.add(3);

        System.out.println(twoSum.find(8));
    }
}
