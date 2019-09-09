package org.ajeet.sdk.algorithms.text;

public final class LCS {
    private final int[][] lcs;
    private final String first;
    private final String second;
    private final int L1;
    private final int L2;

    public LCS(String first, String second) {
        if(first == null || first.length() == 0 || second == null || second.length() == 0)
            throw new IllegalArgumentException("first and second both strings must be non empty and non null.");

        this.first = first;
        this.second = second;

        this.L1 = first.length();
        this.L2 = second.length();

        lcs = new int[L1 + 1][L2 + 1];
        lcs();
    }

    private void lcs(){
        for (int i = 1; i<= L1; i++){
            for (int j = 1; j<= L2; j++){
                if (first.charAt(i-1) == second.charAt(j-1))
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                else
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
            }
        }
    }

    public int find(){
        return lcs[L1][L2];
    }

    public static void main(String[] args) {
        System.out.println(new LCS("Ajeet Singh", "Singh").find());
        System.out.println(new LCS("Ajeet Singh", "Atigh").find());
    }
}
