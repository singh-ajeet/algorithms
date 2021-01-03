package org.ajeet.learnings.algorithms.dictionaries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MyHashSet {
    private static final int BUFFER_SIZE = 1000000;
    private final List<Integer>[] buffer;

    public MyHashSet() {
        buffer = new List[BUFFER_SIZE];
    }

    public void add(int key) {
        int index = findIndex(key);
        List<Integer> bucket = buffer[index];
        if( bucket == null) {
            bucket = new ArrayList<>();
        }  else if(bucket.contains(key)){
            return;
        }
        bucket.add(key);
    }

    private int findIndex(int key) {
        if(key == 0)
            return 0;
        else {
            return BUFFER_SIZE % key;
        }
    }

    public void remove(int key) {
        int index = findIndex(key);
        List<Integer> bucket = buffer[index];
        if( bucket == null) {
            return;
        }
        if(bucket.contains(key)) {
            bucket.remove(key);
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = findIndex(key);
        List<Integer> bucket = buffer[index];
        if( bucket == null) {
            return false;
        }
        if(bucket.contains(key)) {
            return true;
        }
        return false;
    }

    public  int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> cache = new HashMap<>();
        for(int x : nums1)
            cache.put(x, true);
        List<Integer> result = new ArrayList<>();
        for(int x : nums2) {
            if (cache.containsKey(x) && !result.contains(x))
                result.add(x);
        }
        int[] arr = new int[result.size()];
        int i = 0;
        for(int x : result)
            arr[i++] = x;
        return arr;
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        Character preS = null;
        Character preT = null;
        int i = 0;
        for(char ch : s.toCharArray()){
            if(preS != null && preS.charValue() != ch && preT == t.charAt(i)) {
                return false;
            }
            if(preS != null && preS.charValue() == ch && preT != t.charAt(i)) {
                return false;
            }
            preS = ch;
            preT = t.charAt(i++);
        }
        return true;
    }

    public static void main(String[] args) {
        String  s = "foo", t = "bar";
        System.out.println(isIsomorphic(s, t));
    }
}
