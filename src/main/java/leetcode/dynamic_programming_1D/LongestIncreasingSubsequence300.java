package leetcode.dynamic_programming_1D;

public class LongestIncreasingSubsequence300 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,2,3};
        System.out.println(new LongestIncreasingSubsequence300().lengthOfLIS(nums));
    }
    public int lengthOfLIS(int[] nums) {
        int res = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                }
            }
        }
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
