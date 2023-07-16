package leetcode.array;

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores1984 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int difference = nums[k-1] - nums[0];
        for (int i = k; i <nums.length; i++) {
            difference = Math.min(nums[i] - nums[i-k+1], difference);
        }
        return difference;
    }
}
