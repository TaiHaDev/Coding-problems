package leetcode.dynamic_programming_1D;

import java.util.Arrays;

public class CoinChange322 {
    public static void main(String[] args) {
        int[] coins = {2};
        System.out.println(new CoinChange322().coinChange(coins, 3));
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(1 + dp[i - coin], dp[i]);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    /**
     * Top down memoization approach
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        if(amount<1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if(rem == 0) return 0;
        if (count[rem -1] != 0) return count[rem-1];
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = 1 + coinChange(coins, rem - coin, count);
            if (res > 0) {
                result = Math.min(result, res);
            }
        }
        count[rem -1] = result == Integer.MAX_VALUE ? -1 : result;
        return count[rem - 1];
    }
}
