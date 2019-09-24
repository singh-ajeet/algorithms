package org.ajeet.learnings.algorithms.dp;

public final class Knapsack01 {

    public static int solve(int[] values, int[] weights, int capacity){

        if(values == null || values.length ==0 || weights == null || weights.length == 0)
            return 0;

        int n = values.length;

        int[][] dp = new int[n+1][capacity+1];

        for (int i=1; i<=n; i++){
            for (int j=1; j<= capacity; j++){
                if(weights[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], values[i-1] + dp[i-1][j-weights[i-1]]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int values[] = {10, 40, 30, 50};
        int weights[] = {5, 4, 6, 3};
        int capacity = 10;

        System.out.println(solve(values, weights, capacity));
    }
}
