package org.ajeet.learnings.algorithms.dp;

/**
 * Longest palindromic sub-sequence
 */
public final class LPS {
    private final LCS lcs;

    public LPS(String input) {
        lcs = new LCS(input, new StringBuilder(input).reverse().toString());
    }

    public String lps(){
        return lcs.lcs();
    }

    public int length(){
        return lcs.length();
    }

    public static void main(String[] args) {
        LPS lps = new LPS("Ajeet");
        System.out.println("LPS: " + lps.lps() + ", length: " + lps.length());
    }
}
