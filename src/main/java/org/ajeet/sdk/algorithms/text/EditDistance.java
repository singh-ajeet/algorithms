package org.ajeet.sdk.algorithms.text;

public final class EditDistance {
    private final int[][] distance;

    private final String first;
    private final String second;

    private final int L1;
    private final int L2;

    public EditDistance(String first, String second) {
        if(first == null || first.length() == 0 || second == null || second.length() == 0)
            throw new IllegalArgumentException("first and second both strings must be non empty and non null.");

        this.first = first;
        this.second = second;

        this.L1 = first.length();
        this.L2 = second.length();

        distance = new int[L1 + 1][L2 + 1];
        lcs();
    }

    private void lcs(){
        //Cost to convert empty string to a string will be equal to the length of that string
        for (int i=1; i<= L1; i++)
            distance[i][0] = i;
        for (int i=1; i<=L2; i++)
            distance[0][i] = i;

        for (int i = 1; i<= L1; i++){
            for (int j = 1; j<= L2; j++){
                if (first.charAt(i-1) == second.charAt(j-1))
                    distance[i][j] = distance[i-1][j-1];
                else
                    distance[i][j] = min(distance[i-1][j] + 1, distance[i][j-1] +1, distance[i-1][j-1] + 1);
            }
        }
    }

    private int min(int x, int y, int z){
        return Math.min(x, Math.min(y, z));
    }

    public int find(){
        return distance[L1][L2];
    }

    public static void main(String[] args) {
        System.out.println(new EditDistance("Sigh", "Singh").find());
        System.out.println(new EditDistance("Ajeet Singh", "Atigh").find());
    }
}
