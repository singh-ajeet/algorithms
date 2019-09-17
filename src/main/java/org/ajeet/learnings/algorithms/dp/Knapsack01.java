package org.ajeet.learnings.algorithms.dp;

public final class Knapsack01 {

    public static int maxValue(int[] values, int[] weights, int capacity) {
        if(values == null || weights == null || values.length ==0 || weights.length == 0)
            return 0;

        int m = values.length;
        int[][] dp = new int[m + 1][capacity + 1];

        for(int i=0; i<=m; i++) {
            for (int j=0; j<=capacity; j++) {
                if(i==0 || j == 0)
                    dp[i][j] = 0;
                else if(weights[i-1] <= j)
                    dp[i][j] = Math.max(values[i-1] + dp[i-1][j - weights[i-1]] ,
                                        dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[m][capacity];
    }

    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        System.out.println(maxValue(val, wt, W));
    }
}
