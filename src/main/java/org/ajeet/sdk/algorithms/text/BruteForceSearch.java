package org.ajeet.sdk.algorithms.text;

import java.util.ArrayList;
import java.util.List;

public final class BruteForceSearch {

    /**
     * It will return index of all matches
     *
     * @param text
     * @param keyword
     * @return
     */
    public static List<Integer> findAll(String text, String keyword){
        List<Integer> result = new ArrayList<>();

        if(text.length() < keyword.length())
            return result;

        for(int i=0; i <= text.length() - keyword.length(); i++) {
            int j = i;
            int k = 0;
            while ((text.charAt(j++) == keyword.charAt(k++)) && k < keyword.length()){
                if (k == keyword.length() -1)
                    result.add(i);
            }
        }
        return result;
    }

    /**
     * It will return index of first match
     *
     * @param text
     * @param keyword
     * @return
     */
    public static int find(String text, String keyword){
        if(text.length() < keyword.length())
            return -1;

        for(int i=0; i <= text.length() - keyword.length(); i++) {
            int j = i;
            int k = 0;
            while (text.charAt(j++) == keyword.charAt(k++)){
                if (k == keyword.length() -1)
                    return i;
            }
         }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(find("A king is always a king.", "king"));
        System.out.println(findAll("A king is always a king.", "king"));
    }
}
