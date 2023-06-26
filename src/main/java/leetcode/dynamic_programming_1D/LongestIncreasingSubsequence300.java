package leetcode.dynamic_programming_1D;

import java.util.Arrays;

public class LongestIncreasingSubsequence300 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,2,3};
        System.out.println(new LongestIncreasingSubsequence300().lengthOfLIS(nums));
    }
    public int lengthOfLIS(int[] nums) {
        int res = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int index = i + 1; index < nums.length; index++) {
                if (nums[i] < nums[index]) {
                    dp[i] = Math.max(dp[i],1 + dp[index]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
