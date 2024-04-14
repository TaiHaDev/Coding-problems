package leetcode.dynamic_programming_1D;

import java.util.Arrays;

public class JumpGameII45 {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 100000);
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i] && i+j < nums.length; j++) {
                dp[i] = Math.min(1 + dp[i + j], dp[i]);
            }
        }
        return dp[0];
    }
    public int jump2(int[] nums) {
        int curIndex = 0;
        int jumpCount = 0;
        int curEndIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curIndex = Math.max(curIndex, i + nums[i]);
            if (i == curEndIndex) {
                jumpCount++;
                curEndIndex = curIndex;
            }
        }
        return jumpCount;
    }
}
