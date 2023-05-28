package dynamic_programming_1D;

import java.util.Arrays;

public class HouseRobberII213 {
    /**
     * make use of the previous solution and a little trick
     */
    public int rob(int[] nums) {
        if (nums.length <= 2) return helper(nums);
        return Math.max(helper(Arrays.copyOfRange(nums, 0, nums.length -1)), helper(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    public int helper(int[] nums) {
        int rob1 = 0, rob2 = 0;
        for (int num : nums) {
            int temp = Math.max(rob2, rob1 + num);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
