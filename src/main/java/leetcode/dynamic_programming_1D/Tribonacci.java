package leetcode.dynamic_programming_1D;

public class Tribonacci {
    public int tribonacci(int n) {
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        if (n < 3) return dp[n];
        while (n > 2) {
            int temp = dp[0] + dp[1] + dp[2];
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = temp;
            n--;
        }
        return dp[2];
    }
}
