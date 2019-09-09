package org.ajeet.sdk.algorithms.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.nayuki.io/page/knuth-morris-pratt-string-matching
 */
public final class KMPSearch {

    private KMPSearch(){
        throw new IllegalStateException(this.getClass().getName() + " is not instantiable.");
    }

    public static List<Integer> searchAllPlaces(String text, String pattern){
        if(text == null || text.length() == 0 || pattern == null || pattern.length() == 0)
            return Collections.emptyList();

        List<Integer> indexes = new ArrayList<>();
        int[] failFunction = failFunction(pattern);

        int n = text.length();
        int m = pattern.length();
        int j = 0;
        for (int i=0; i<n; i++){
            while (j>0 && text.charAt(i) != pattern.charAt(j))
                j = failFunction[j-1];
            if(text.charAt(i) == pattern.charAt(j))
                j++;
            if(j == m) {
                indexes.add(i-j+1);
                j = 0;
            }
        }
        return Collections.unmodifiableList(indexes);
    }

    public static int search(String text, String pattern){
        if(text == null || text.length() == 0 || pattern == null || pattern.length() == 0)
            return -1;

        int[] failFunction = failFunction(pattern);

        int n = text.length();
        int m = pattern.length();
        int j = 0;
        for (int i=0; i<n; i++){
            while (j>0 && text.charAt(i) != pattern.charAt(j))
                j = failFunction[j-1];
            if(text.charAt(i) == pattern.charAt(j))
                j++;
            if(j == m)
                return i-j+1;
        }

        return -1;
    }

    private static int[] failFunction(String pattern){
        int m = pattern.length();
        int[] failFunction = new int[m+1];
        for(int i=1; i< m; i++) {
            int j = failFunction[i-1];
            while(j >0 && pattern.charAt(i) != pattern.charAt(j))
                j = failFunction[j-1];
            if(pattern.charAt(i) == pattern.charAt(j))
                j++;
            failFunction[i] = j;
        }
        return failFunction;
    }


        public static void main(String[] args) {
            System.out.println(search("A king is always a king", "king"));
            System.out.println(searchAllPlaces("A king is always a king", "king"));
    }
}
