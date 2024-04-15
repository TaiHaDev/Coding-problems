package leetcode.kadane;

public class MaximumSumCircularSubArray918 {
    public static void main(String[] args) {
        System.out.println(new MaximumSumCircularSubArray918().maxSubarraySumCircular(new int[] {5,-3,5}));
    }
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = nums[0];
        int minSum = nums[0];
        int curMax = 0;
        int curMin = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            curMax = Math.max(nums[i], curMax + nums[i]);
            curMin = Math.min(nums[i], curMin + nums[i]);
            maxSum = Math.max(maxSum, curMax);
            minSum = Math.min(curMin, minSum);
        }
        if (minSum == totalSum) {
            return maxSum;
        } else {
            return Math.max(maxSum, totalSum - minSum);
        }

    }
}
