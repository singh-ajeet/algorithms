package org.ajeet.learnings.algorithms.dp;

/**
 * Longest palindromic sub-sequence
 */
public final class LongestPalindromeSubsequence {
    private final LongestCommonSubsequence longestCommonSubsequence;

    public LongestPalindromeSubsequence(String input) {
        longestCommonSubsequence = new LongestCommonSubsequence(input, new StringBuilder(input).reverse().toString());
    }

    public String lps(){
        return longestCommonSubsequence.lcs();
    }

    public int length(){
        return longestCommonSubsequence.length();
    }

    public static void main(String[] args) {
        LongestPalindromeSubsequence lps = new LongestPalindromeSubsequence("Ajeet");
        System.out.println("LongestPalindromeSubsequence: " + lps.lps() + ", length: " + lps.length());
    }
}
