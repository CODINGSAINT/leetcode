package dynamicprogramming;

import java.util.Arrays;

//322. Coin Change
public class CoinChange {
    int dp[];

    public int coinChange(int[] coins, int amount) {

        int dp[] = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int compare = 0;

        for (int coin : coins) {
            for (int value = 0; value < dp.length; value++) {
                if (coin <= value) {
                    if (dp[value - coin] == Integer.MAX_VALUE) {
                        compare = dp[value - coin];
                    } else {
                        compare = dp[value - coin] + 1;
                    }
                    dp[value] = Integer.min(dp[value], compare);

                }
            }
        }

        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;

    }
}