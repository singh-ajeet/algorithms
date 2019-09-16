package org.ajeet.learnings.algorithms.dp;

public final class LongestSubStringWithNonRepeatingCharacters {

    public static int subString(String input) {
        boolean[] exist = new boolean[256];
        int i = 0, maxLen = 0;
        for (int j = 0; j < input.length(); j++) {
            if (!exist[input.charAt(j)]) {
                i++;
               // maxLen = Math.max(j - i + 1, maxLen);
            }
            exist[input.charAt(j)] = true;

            //exist[input.charAt(j)] = true;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(subString("aaa"));
        System.out.println(subString("abc"));
        System.out.println(subString("aaabbaaccd"));
    }
}
