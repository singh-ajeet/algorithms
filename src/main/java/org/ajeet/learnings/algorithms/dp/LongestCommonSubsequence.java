package org.ajeet.learnings.algorithms.dp;

/**
 * Dynamic programming approach to solve 'Longest Common Subsequence' problem
 */
public final class LongestCommonSubsequence {
    private final int[][] lcs;
    private final String first;
    private final String second;
    private final int L1;
    private final int L2;

    private String subSequence;

    public LongestCommonSubsequence(String first, String second) {
        if(first == null || first.length() == 0 || second == null || second.length() == 0)
            throw new IllegalArgumentException("first and second both strings must be non empty and non null.");

        this.first = first;
        this.second = second;

        this.L1 = first.length();
        this.L2 = second.length();

        lcs = new int[L1 + 1][L2 + 1];
        process();
        backtrackToBuildLCS();
    }

    private void process(){
        for (int i = 0; i < first.length(); i++) {
            for (int j = 0; j < second.length(); j++){
                if (first.charAt(i) == second.charAt(j)) {
                    //Match found, increase sub sequence
                    lcs[i+1][j+1] = lcs[i][j] + 1;
                }
                else {
                    lcs[i+1][j+1] = Math.max(lcs[i+1][j], lcs[i][j+1]);
                }
            }
        }
    }

    private void backtrackToBuildLCS(){
        StringBuilder builder = new StringBuilder();
        for (int i = L1, j = L2; i != 0 && j != 0; ) {
            if (lcs[i][j] == lcs[i-1][j])
                i--;
            else if (lcs[i][j] == lcs[i][j-1])
                j--;
            else {
                //Match found
                builder.append(first.charAt(i-1));
                i--;
                j--;
            }
        }
        subSequence = builder.reverse().toString();
    }

    public int length(){
        return lcs[L1][L2];
    }

    public String lcs(){
        return subSequence;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence1 = new LongestCommonSubsequence("Simplicity is ultimate sofistication.", "Simple");
        System.out.println("Sub sequence: " + longestCommonSubsequence1.lcs() + ", length: " + longestCommonSubsequence1.length());

        LongestCommonSubsequence longestCommonSubsequence2 = new LongestCommonSubsequence("Do not repeat yourself", "coding");
        System.out.println("Sub sequence: " + longestCommonSubsequence2.lcs() + ", length: " + longestCommonSubsequence2.length());

        LongestCommonSubsequence longestCommonSubsequence3 = new LongestCommonSubsequence("Keep it simple stupid.", "COMPLEX");
        System.out.println("Sub sequence: " + longestCommonSubsequence3.lcs() + ", length: " + longestCommonSubsequence3.length());

        LongestCommonSubsequence lps  = new LongestCommonSubsequence("Ajeet", "teejA");
        System.out.println("Sub sequence: " + lps.lcs() + ", length: " + lps.length());

    }
}
