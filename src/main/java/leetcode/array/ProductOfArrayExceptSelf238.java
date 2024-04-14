package leetcode.array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf238 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

    }

    /**
     * suffice product and prefix product array
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        for (int i = 1; i < nums.length; i++) {
            ans[i] *= ans[i - 1] * nums[i-1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            ans[i] *= nums[i + 1];
            nums[i] *= nums[i + 1];
        }
        return ans;
    }
}
