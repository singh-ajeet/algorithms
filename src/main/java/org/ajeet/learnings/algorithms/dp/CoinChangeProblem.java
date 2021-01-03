package org.ajeet.learnings.algorithms.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * We have infinite quantity of each type of coins
 * find ot all possible way to pay a given amount by using given coins
 *
 */
public final class CoinChangeProblem {

    public static int minCoins(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    private static long maxWays(int[] coins, int sum){
        long[] results = new long[sum+1];

        results[0] = 1; // only 1 way for 0 sum
        for(int i=0; i<coins.length; i++){
            for(int j=coins[i]; j<=sum; j++) {
                results[j] += results[j - coins[i]];
            }
        }
        return results[sum];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 4;
        System.out.println(maxWays(coins, sum));
        System.out.println(minCoins(coins, sum));
    }
}
