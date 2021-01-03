package org.ajeet.learnings.algorithms.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public final class MinHeap {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counters = new HashMap<>(k+1);
        PriorityQueue<Integer> minQ = new PriorityQueue<>((a,b) -> a - b);

        return null;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>((a,b) -> a.compareTo(b));
 //       PriorityQueue<Integer> maxQ = new PriorityQueue<>((a,b) -> b.compareTo(a));

        minQ.add(1);
        minQ.add(100);
        minQ.add(8);
        minQ.add(7);

        System.out.println(minQ.peek());
        System.out.println(minQ.poll());
    }
}
